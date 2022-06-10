package com.canhchim.martapi.module.order.service;

import com.canhchim.martapi.dto.OrderDto;
import com.canhchim.martapi.entity.Order;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface IOrderService {
    List<OrderDto> getList(Integer page, Integer size, Integer shopId);

    String addOrder(OrderDto orderDto, Integer shopId);

    String updateOrder(OrderDto orderDto, Integer shopId);

    String deleteOrder(Long id, Integer shopId);

    OrderDto getByOrderCode(String orderCode, Integer shopId);
}
