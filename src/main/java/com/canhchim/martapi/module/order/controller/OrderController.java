package com.canhchim.martapi.module.order.controller;

import com.canhchim.martapi.dto.OrderDto;
import com.canhchim.martapi.entity.Order;
import com.canhchim.martapi.module.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping("/all") // lay danh sach all order
    public List<Order> getList(){
        return orderService.getList();
    }

    @PostMapping("/order")
    public String addOrder(@RequestBody OrderDto orderDto){
        return orderService.addOrder(orderDto);
    }

    @PutMapping("/order")
    public String updateOrder(@RequestBody OrderDto orderDto){
        return orderService.updateOrder(orderDto);
    }

    @DeleteMapping("/order")
    public String deleteOrder(@RequestParam(name = "id") Integer id){
        return orderService.deleteOrder(id);
    }
}
