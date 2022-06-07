package com.canhchim.martapi.module.order.controller;

import com.canhchim.martapi.dto.OrderDto;
import com.canhchim.martapi.module.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping("/all") // lay danh sach all order
    ResponseEntity<List<OrderDto>> getAll(HttpServletRequest httpServletRequest) throws IOException{
        List<OrderDto> orderDtoList = orderService.getList();
        return ResponseEntity.ok().body(orderDtoList);
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
    public String deleteOrder(@RequestParam(name = "id") Long id){
        return orderService.deleteOrder(id);
    }
}