package com.canhchim.martapi.dto;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class OrderDto {
    private Integer id;
    private String orderStatusShipComment;
}
