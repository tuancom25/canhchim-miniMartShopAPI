package com.canhchim.martapi.dto.address;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProvinceDto implements Serializable {
    private Integer id;
    private String name;
    private String code;
    private Boolean type;
}
