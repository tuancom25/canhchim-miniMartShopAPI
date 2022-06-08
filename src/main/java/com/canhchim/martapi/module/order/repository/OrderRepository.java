package com.canhchim.martapi.module.order.repository;

import com.canhchim.martapi.entity.Order;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("select o from Order o order by o.orderCode asc ")
    List<Order> listOrder(Pageable pageable);

    @Query("select o.orderCode from Order o")
    List listOrderCode();

//    @Query(value = "select * from Order where orderCode = ?", nativeQuery = true)
//    List<Order>
}