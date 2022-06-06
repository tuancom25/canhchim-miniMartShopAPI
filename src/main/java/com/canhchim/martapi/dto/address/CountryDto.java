package com.canhchim.martapi.dto.address;

import lombok.Data;

import java.io.Serializable;

@Data
public class CountryDto implements Serializable {
    private Integer id;
    private String name;
    private Integer code;
}
