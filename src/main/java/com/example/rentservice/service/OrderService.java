package com.example.rentservice.service;

import com.example.rentservice.dto.order.OrderCreateReq;
import com.example.rentservice.dto.order.OrderResp;
import com.example.rentservice.exception.CarNotFoundException;
import com.example.rentservice.exception.OrderNotFoundException;
import com.example.rentservice.exception.UserIsNotAdminException;
import com.example.rentservice.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    List<OrderResp> getAll();

    OrderResp save(OrderCreateReq dto) throws UserNotFoundException, CarNotFoundException;

    OrderResp update(OrderResp dto) throws OrderNotFoundException, UserNotFoundException, CarNotFoundException;

    void delete(Long id) throws OrderNotFoundException;

    OrderResp allowOrder(Long idOrder, Long idAdmin, Boolean statusBoolean, String refuseReason) throws UserNotFoundException, OrderNotFoundException, UserIsNotAdminException;
}
