package com.canhchim.martapi.module.order.service;

import com.canhchim.martapi.dto.OrderDto;
import com.canhchim.martapi.entity.Order;
import com.canhchim.martapi.module.customer.CustomerRepository;
import com.canhchim.martapi.module.order.mapping.DataMapping;
import com.canhchim.martapi.module.order.repository.OrderRepository;
import com.canhchim.martapi.module.shipper.ShipCompanyRepository;
import com.canhchim.martapi.module.shipper.ShipperRepository;
import com.canhchim.martapi.module.shop.repository.ShopRepository;
import com.canhchim.martapi.module.user.IUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService implements IOrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private DataMapping mapping;
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
    /**
     * không dùng modelmapper, chuyển order thành orderDto = DataMapping
     *
     * @return : trả về list orderDto
     */
    @Override
    public List<OrderDto> getList(Integer page, Integer size) {
        List<OrderDto> orderDtoList = new ArrayList<>();
//        List<Order> orderList = orderRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
        List<Order> orderList = orderRepository.listOrder(PageRequest.of(page, size));
        for (Order order : orderList) {
            OrderDto orderDto = new OrderDto();
            orderDto = mapping.mappingOrderToDto(order);
            orderDtoList.add(orderDto);
        }
        return orderDtoList;
    }

    /**
     * dùng modelmapper để chuyển orderDTO thành order, thêm order vào orderRepository
     *
     * @param orderDto
     * @return order
     */
    @Override
    public String addOrder(OrderDto orderDto) {
        //
        List listOrderCode = orderRepository.listOrderCode();
        for (Object code: listOrderCode) {
            if (orderDto.getOrderCode().equals(code)) {
                return "orderCode bị trùng rồi. Thay orderCode khác đê";
            }
        }
        //
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
        orderRepository.save(order);
        return "thêm order thành công";
    }

    /**
     * lấy id(orderId) kiểm tra có tồn tại không. Nếu có thì dùng modelmapper để chuyển modelDto thành order.
     * Thêm order chèn vào orderRepository
     *
     * @param orderDto
     * @return order
     */
    @Override
    public String updateOrder(OrderDto orderDto) {
        if (orderRepository.existsById(orderDto.getId())) {
            Order order = modelMapper.map(orderDto, Order.class);
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
            orderRepository.save(order);
            return "chinh sua thanh cong";
        } else {
            return "orderId không tồn tại";
        }
    }

    @Override
    public String deleteOrder(Long id) {
        if (orderRepository.existsById(id)) {
            orderRepository.deleteById(id);
            return "xoa order thành công";
        } else {
            return "orderId không tồn tại";
        }
    }
}