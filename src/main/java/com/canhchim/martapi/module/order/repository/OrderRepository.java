package com.canhchim.martapi.module.order.repository;

import com.canhchim.martapi.entity.Order;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("select o from Order o where o.shop.id = ?1")
    List<Order> listOrder(Pageable pageable, Integer id);

    @Query("select o.orderCode from Order o where o.shop.id = ?1")
    List listOrderCode(Integer id);

    @Query("select o from Order o where o.orderCode = ?1 and o.shop.id = ?2")
    Order findByOrderCode(String orderCode, Integer shopId);



//    @Query(value = "select * from Order where orderCode = ?", nativeQuery = true)
//    List<Order>
}