package com.canhchim.martapi.dto;

import lombok.Data;

@Data
public class ResponseDto {
    int responseCode = 200;
    String message = "OK";
    Object data;
}
