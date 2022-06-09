package com.canhchim.martapi.module.order.mapping;

import com.canhchim.martapi.dto.OrderDto;
import com.canhchim.martapi.entity.Order;
import com.canhchim.martapi.module.customer.CustomerRepository;
import com.canhchim.martapi.module.order.repository.OrderRepository;
import com.canhchim.martapi.module.shipper.ShipCompanyRepository;
import com.canhchim.martapi.module.shipper.ShipperRepository;
import com.canhchim.martapi.module.shop.repository.ShopRepository;
import com.canhchim.martapi.module.user.IUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataMapping {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private ShopRepository shopRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ShipperRepository shipperRepository;
    @Autowired
    private ShipCompanyRepository shipCompanyRepository;

    public OrderDto mappingOrderToDto(Order order) {
        OrderDto orderDto = new OrderDto();
        orderDto = modelMapper.map(order, OrderDto.class);
        // các thành phần không được null
        orderDto.setUserId(order.getUser().getId());
        orderDto.setShopId(order.getShop().getId());
        // Các thành phần có thể null
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

    public Order mappingOderDtoToOrder(OrderDto orderDto) {
        Order order = new Order();
        order = modelMapper.map(orderDto, Order.class);
        order.setUser(userRepository.findById(orderDto.getUserId()).get());
        order.setShop(shopRepository.findById(orderDto.getShopId()).get());
        if (orderDto.getCustomerId() != null) {
            order.setCustomer(customerRepository.findById(orderDto.getCustomerId()).get());
        }
        if (orderDto.getShipperId() != null) {
            order.setShipper(shipperRepository.findById(orderDto.getShipperId()).get());
        }
        if (orderDto.getShipCompanyId() != null) {
            order.setShipCompany(shipCompanyRepository.findById(orderDto.getShipCompanyId()).get());
        }
        return order;
    }
}
