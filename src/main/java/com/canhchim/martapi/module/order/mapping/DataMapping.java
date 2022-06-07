package com.canhchim.martapi.module.order.mapping;

import com.canhchim.martapi.dto.OrderDto;
import com.canhchim.martapi.entity.Order;
import com.canhchim.martapi.module.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataMapping {
    @Autowired
    private OrderRepository orderRepository;

    public OrderDto mappingOrderToDto(Order order) {
        OrderDto orderDto = new OrderDto();
        // các thành phần không được null
        orderDto.setId(order.getId());
        orderDto.setOrderCode(order.getOrderCode());
        orderDto.setUserId(order.getUser().getId());
        orderDto.setDate1(order.getDate1());
        orderDto.setDate2(order.getDate2());
        orderDto.setTotalMoney(order.getTotalMoney());
        orderDto.setMoneyType(order.getMoneyType());
        orderDto.setGetMoney(order.getGetMoney());
        orderDto.setRejectMoney(order.getRejectMoney());
        orderDto.setStatusPay(order.getStatusPay());
        orderDto.setType(order.getType());
        orderDto.setPayType(order.getPayType());
        orderDto.setShopId(order.getShop().getId());
        // Các thành phần có thể null
        orderDto.setCustomerName(order.getCustomerName());
        orderDto.setCustomerName(order.getCustomerName());
        orderDto.setStatusShip(order.getStatusShip());
        orderDto.setStatusShipComment(order.getStatusShipComment());
        orderDto.setCustomerAdrress(order.getCustomerAdrress());
        orderDto.setCustomerAdrress2(order.getCustomerAdrress2());
        orderDto.setOrderComment(order.getOrderComment());
        if (order.getCustomer() != null) {
            orderDto.setCustomerId(order.getCustomer().getId());
        }
        if (order.getShipper() != null) {
            orderDto.setShipperId(order.getShipper().getId());
        }
        if (order.getShipCompany() != null) {
            orderDto.setShipCompanyId(order.getShipCompany().getId());
        }
        return orderDto;
    }
}
