package com.canhchim.martapi.module.order.service;

import com.canhchim.martapi.dto.OrderDto;
import com.canhchim.martapi.entity.Order;

import java.util.List;

public interface IOrderService {
    List<OrderDto> getList();

    String addOrder(OrderDto orderDto);

    String updateOrder(OrderDto orderDto);

    String deleteOrder(Long id);
}
