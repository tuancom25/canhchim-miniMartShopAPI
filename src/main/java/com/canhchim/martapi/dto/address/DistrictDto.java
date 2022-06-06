package com.canhchim.martapi.dto.address;

import lombok.Data;

import java.io.Serializable;

@Data
public class DistrictDto implements Serializable {
    private Integer id;
    private String name;
    private String code;
    private Boolean type;
}
