package com.canhchim.martapi.module.order.service;

import com.canhchim.martapi.dto.OrderDto;
import com.canhchim.martapi.entity.Order;
import com.canhchim.martapi.module.order.repository.OrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements IOrderService{
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    private final ModelMapper modelMapper;

    public OrderService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public List<Order> getList() {
        return orderRepository.findAll(Sort.by(Sort.Direction.ASC,"id"));
    }

    @Override
    public String addOrder(OrderDto orderDto) {
        if (orderRepository.existsById(orderDto.getId())){
            return "orderId da ton tai";
        } else {
            Order order = modelMapper.map(orderDto, Order.class);
            orderRepository.save(order);
            return "them order thanh cong";
        }
    }

    @Override
    public String updateOrder(OrderDto orderDto) {
        if (orderRepository.existsById(orderDto.getId())){
            Order order = modelMapper.map(orderDto, Order.class);
            orderRepository.save(order);
            return "chinh sua thanh cong";
        } else {
            return "orderId khong ton tai";
        }
    }

    @Override
    public String deleteOrder(Integer id) {
        if (orderRepository.existsById(id)){
            orderRepository.deleteById(id);
            return "xoa order thanh cong";
        } else {
            return "orderId khong ton tai";
        }
    }
}
