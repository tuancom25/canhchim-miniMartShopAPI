package com.canhchim.martapi.dto.address;

import lombok.Data;

import java.io.Serializable;

@Data
public class WardDto implements Serializable {
    private Integer id;
    private String name;
    private Integer code;
    private Boolean type;
}
