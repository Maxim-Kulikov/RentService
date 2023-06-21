package com.example.rentservice.repository.order;

import com.example.rentservice.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao extends CrudRepository<Order, Long> {
    List<Order> findAllByStatusIs(Boolean status);
}
