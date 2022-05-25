package com.canhchim.martapi.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/TestAPI")
public class TestAPI {
    //TestAPI/test1
    @GetMapping("test1")
    public String Getdata1() {
        return "Test1 GetData ok ." ;
    }

}
