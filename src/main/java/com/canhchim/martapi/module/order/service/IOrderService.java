package com.canhchim.martapi.module.order.service;

import com.canhchim.martapi.dto.OrderDto;
import com.canhchim.martapi.entity.Order;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface IOrderService {
    List<OrderDto> getList(Integer page, Integer size);

    String addOrder(OrderDto orderDto);

    String updateOrder(OrderDto orderDto);

    String deleteOrder(Long id);

    OrderDto getByOrderCode(String orderCode);
}
