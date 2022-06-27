package com.canhchim.martapi.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.time.Instant;
@Entity
@Table(name = "products")
@Setter
@Getter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false)
    private Long id;
    @Column(name = "code", nullable = false, length = 15)
    private String code;

    @Column(name = "type", nullable = false)
    private Boolean type = false;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
    @Column(name = "name", nullable = false, length = 60)
    private String name;
    @Column(name = "price", nullable = false)
    private Long price;
    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "supply_id", nullable = false)
    private ProductSupply supply;

    @Column(name = "input_date", nullable = false)
    private Instant inputDate;

    @Column(name = "last_update", nullable = false)
    private Instant lastUpdate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_input", nullable = false)
    private User userInput;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_last_update", nullable = false)
    private User userLastUpdate;

    @Column(name = "status", nullable = false)
    private Boolean status = false;

    @Column(name = "avatar", length = 256)
    private String avatar;

    @Column(name = "product_parent")
    private Long productParent;

    @Column(name = "sale_status")
    private Integer saleStatus;

    @Column(name = "has_top_up")
    private Integer hasTopUp;

    @Column(name = "is_top_up")
    private Integer isTopUp;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_unit_id", nullable = false)
    private ProductUnit productUnit;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "shop_id", nullable = false)
    private Shop shop;

    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted = false;
}