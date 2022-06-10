package com.canhchim.martapi.module.order.controller;

import com.canhchim.martapi.dto.OrderDto;
import com.canhchim.martapi.dto.ResponseDto;
import com.canhchim.martapi.module.order.service.IOrderService;
import com.canhchim.martapi.util.PermissionUtil;
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
    IOrderService orderService;
    @Autowired
    PermissionUtil permissionUtil;
    @GetMapping("/all") // lay danh sach all order
    ResponseEntity<?> getAll(HttpServletRequest request, @RequestParam Integer page, @RequestParam Integer size) throws IOException{
        ResponseDto responseDto = new ResponseDto();
        List<OrderDto> list = orderService.getList(page, size, permissionUtil.getShopId(request));
        responseDto.setData(list);
        return ResponseEntity.ok().body(responseDto);
    }

    @GetMapping("/order") // lay thong tin order theo order Code
    ResponseEntity<?> getByOrderCode(HttpServletRequest request, @RequestParam String orderCode) throws IOException {
        ResponseDto responseDto = new ResponseDto();
        OrderDto orderDto = orderService.getByOrderCode(orderCode, permissionUtil.getShopId(request));
        responseDto.setData(orderDto);
        return ResponseEntity.ok().body(responseDto);
    }

    @PostMapping("/order")
    public String addOrder(HttpServletRequest request, @RequestBody OrderDto orderDto) throws IOException{
        orderDto.setShopId(permissionUtil.getShopId(request));
        String str = orderService.addOrder(orderDto, permissionUtil.getShopId(request));
        return str;
    }

    @PutMapping("/order")
    public String updateOrder(HttpServletRequest request, @RequestBody OrderDto orderDto){
        return orderService.updateOrder(orderDto, permissionUtil.getShopId(request));
    }

    @DeleteMapping("/order")
    public String deleteOrder(HttpServletRequest request, @RequestParam(name = "id") Long id){
        return orderService.deleteOrder(id, permissionUtil.getShopId(request));
    }
}