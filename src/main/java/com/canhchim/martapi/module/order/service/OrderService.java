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
     * @param orderDto : la order can them vao
     * @return order : la order la duoc them vao
     */
    @Override
    public String addOrder(OrderDto orderDto) {
        List listOrderCode = orderRepository.listOrderCode();
        for (Object code: listOrderCode) {
            if (orderDto.getOrderCode().equals(code)) {
                return "orderCode bị trùng rồi. Thay orderCode khác đê";
            }
        }
        Order order = new Order();
        order = mapping.mappingOderDtoToOrder(orderDto);
        orderRepository.save(order);
        return "thêm order thành công";
    }

    /**
     * lấy id(orderId) kiểm tra có tồn tại không. Nếu có thì dùng modelmapper để chuyển modelDto thành order.
     * Thêm order chèn vào orderRepository
     *
     * @param orderDto : la order can update
     * @return order : la order duoc update thanh cong
     */
    @Override
    public String updateOrder(OrderDto orderDto) {
        if (orderRepository.existsById(orderDto.getId())) {
            Order order = new Order();
            order = mapping.mappingOderDtoToOrder(orderDto);
            orderRepository.save(order);
            return "chinh sua thanh cong";
        } else {
            return "orderId không tồn tại";
        }
    }

    /**
     * xoa order dua tren id
     * @param id : la id cua order can xoa
     * @return xoa order thanh cong
     */
    @Override
    public String deleteOrder(Long id) {
        if (orderRepository.existsById(id)) {
            orderRepository.deleteById(id);
            return "xoa order thành công";
        } else {
            return "orderId không tồn tại";
        }
    }

    /**
     * tim kiem order = orderCode
     * @param orderCode : la orderCode cua order can tim
     * @return order : la order can tim
     */
    @Override
    public OrderDto getByOrderCode(String orderCode) {
        Order order = orderRepository.findByOrderCode(orderCode);
        OrderDto orderDto = new OrderDto();
        orderDto = mapping.mappingOrderToDto(order);
        return orderDto;
    }
}