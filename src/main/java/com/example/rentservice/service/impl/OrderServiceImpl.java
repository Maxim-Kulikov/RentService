package com.example.rentservice.service.impl;

import com.example.rentservice.dto.order.OrderCreateReq;
import com.example.rentservice.dto.order.OrderResp;
import com.example.rentservice.exception.CarNotFoundException;
import com.example.rentservice.exception.OrderNotFoundException;
import com.example.rentservice.exception.UserIsNotAdminException;
import com.example.rentservice.exception.UserNotFoundException;
import com.example.rentservice.mapper.order.OrderMapper;
import com.example.rentservice.model.Car;
import com.example.rentservice.model.Order;
import com.example.rentservice.model.User;
import com.example.rentservice.repository.car.CarDao;
import com.example.rentservice.repository.order.OrderDao;
import com.example.rentservice.repository.user.UserDao;
import com.example.rentservice.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final Short ROLE_ADMIN_ID = 1;
    @Autowired
    private final OrderDao orderDao;
    @Autowired
    private final OrderMapper orderMapper;
    @Autowired
    private final UserDao userDao;
    @Autowired
    private final CarDao carDao;


    @Override
    @Transactional
    public List<OrderResp> getAll() {
        return orderMapper.toListOrderCreationResponses(((List<Order>) orderDao.findAll()));
    }

    @Override
    @Transactional
    public OrderResp save(OrderCreateReq dto) throws UserNotFoundException, CarNotFoundException {
        Long idUser = dto.getIdUser();
        Integer idCar = dto.getIdCar();

        User user = userDao.findById(idUser)
                .orElseThrow(() -> new UserNotFoundException(idUser));
        Car car = carDao.findById(idCar)
                .orElseThrow(() -> new CarNotFoundException(idCar));
        Order order = orderMapper.toOrder(dto, user, car);

        Long difference = (dto.getFinishDate().getTime() - dto.getStartDate().getTime()) / (24 * 60 * 60 * 1000);
        Long price = car.getPrice() * difference;

        order.setPrice(price);
        order.setStatus(false);
        orderDao.save(order);
        return orderMapper.toOrderResp(order);
    }

    @Override
    @Transactional
    public OrderResp update(OrderResp dto) throws OrderNotFoundException, UserNotFoundException, CarNotFoundException {
        Order order = orderDao.findById(dto.getId())
                .orElseThrow(() -> new OrderNotFoundException(dto.getId()));
        updateOrder(dto, order);
        orderDao.save(order);
        return orderMapper.toOrderResp(order);
    }

    @Override
    @Transactional
    public void delete(Long id) throws OrderNotFoundException {
        if (!orderDao.existsById(id)) {
            throw new OrderNotFoundException(id);
        }
        orderDao.deleteById(id);
    }

    @Override
    @Transactional
    public OrderResp allowOrder(Long idOrder, Long idAdmin, Boolean status, String refuseReason) throws UserNotFoundException, OrderNotFoundException, UserIsNotAdminException {
        User admin = userDao.findById(idAdmin)
                .orElseThrow(() -> new UserNotFoundException(idAdmin));

        if (!admin.getRole().getId().equals(ROLE_ADMIN_ID)) {
            throw new UserIsNotAdminException(idAdmin);
        }

        Order order = orderDao.findById(idOrder)
                .orElseThrow(() -> new OrderNotFoundException(idOrder));
        order.setAdmin(admin);
        order.setStatus(status);

        if (!status) {
            if (refuseReason == null || refuseReason.isBlank()) {
                throw new RuntimeException("You did not write the reason of refuse");
            }
            order.setRefuseReason(refuseReason);
        }
        orderDao.save(order);
        return orderMapper.toOrderResp(order);
    }

    private Order updateOrder(OrderResp dto, Order model) throws UserNotFoundException, CarNotFoundException {
        return model.changer()
                .admin(userDao.findById(dto.getIdAdmin())
                        .orElseThrow(() -> new UserNotFoundException(dto.getIdAdmin())))
                .price(dto.getPrice())
                .startDate(dto.getStartDate())
                .finishDate(dto.getFinishDate())
                .status(dto.getStatus())
                .refuseReason(dto.getRefuseReason())
                .car(carDao.findById(dto.getIdCar()).orElseThrow(() -> new CarNotFoundException(dto.getIdCar())))
                .change();
    }
}
