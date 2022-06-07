package com.canhchim.martapi.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Data
@Getter
@Setter
public class OrderDto {
    private Long id;
    private String orderCode;
    private Integer customerId;
    private Integer userId;
    private String date1;
    private Instant date2;
    private Integer totalMoney;
    private Integer moneyType;
    private Integer getMoney;
    private Integer rejectMoney;
    private String customerName;
    private String customerPhone;
    private Integer statusPay;
    private Integer statusShip;
    private String statusShipComment;
    private Integer type;
    private Integer payType;
    private String customerAdrress;
    private String customerAdrress2;
    private Integer shopId;
    private Integer shipperId;
    private Integer shipCompanyId;
    private String orderComment;
}
