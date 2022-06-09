package com.canhchim.martapi.module.order.controller;

import com.canhchim.martapi.dto.OrderDto;
import com.canhchim.martapi.dto.ResponseDto;
import com.canhchim.martapi.module.order.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    IOrderService orderService;

    @GetMapping("/all") // lay danh sach all order
    ResponseEntity<?> getAll(@RequestParam Integer page, @RequestParam Integer size) throws IOException{
        ResponseDto responseDto = new ResponseDto();
        List<OrderDto> list = orderService.getList(page, size);
        responseDto.setData(list);
        return ResponseEntity.ok().body(responseDto);
    }

    @GetMapping("/order") // lay thong tin order theo order Code
    ResponseEntity<?> getByOrderCode(@RequestParam String orderCode) throws IOException {
        ResponseDto responseDto = new ResponseDto();
        OrderDto orderDto = orderService.getByOrderCode(orderCode);
        responseDto.setData(orderDto);
        return ResponseEntity.ok().body(responseDto);
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