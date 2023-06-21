package com.example.rentservice.controller.order;

import com.example.rentservice.dto.order.OrderCreateReq;
import com.example.rentservice.dto.order.OrderResp;
import com.example.rentservice.exception.CarNotFoundException;
import com.example.rentservice.exception.OrderNotFoundException;
import com.example.rentservice.exception.UserIsNotAdminException;
import com.example.rentservice.exception.UserNotFoundException;
import com.example.rentservice.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Orders", description = "CRUD operations with orders")
@RestController
@AllArgsConstructor
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private final OrderService orderService;

    @Operation(
            summary = "Orders",
            description = "Returns orders information"
    )
    @GetMapping("")
    public List<OrderResp> getAll() {
        return orderService.getAll();
    }

    @Operation(
            summary = "Save order",
            description = "Saves order and returns information about this order"
    )
    @PostMapping("/save")
    public OrderResp save(@RequestBody @Parameter(description = "Parameters for order saving") OrderCreateReq dto)
            throws UserNotFoundException, CarNotFoundException {
        return orderService.save(dto);
    }

    @Operation(
            summary = "Allow order",
            description = "After saving order has not allowed status (false), admin should change its status. Returns updated information about this order"
    )
    @PatchMapping("/allow")
    public OrderResp allow(@RequestParam @Parameter(description = "Order id")
                           Long idOrder,
                           @RequestParam @Parameter(description = "Admin id")
                           Long idAdmin,
                           @RequestParam @Parameter(description = "Status for this order, to allow or not (true/false)")
                           String status,
                           @RequestParam(required = false) @Parameter(description = "If you choose status false, write refuse reason")
                           String refuseReason)
            throws UserNotFoundException, OrderNotFoundException, UserIsNotAdminException {
        return orderService.allowOrder(idOrder, idAdmin, Boolean.parseBoolean(status), refuseReason);
    }

    @Operation(
            summary = "Delete order",
            description = "Deletes order by order id"
    )
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable @Parameter(description = "Order id") Long id) throws OrderNotFoundException {
        orderService.delete(id);
    }
}
