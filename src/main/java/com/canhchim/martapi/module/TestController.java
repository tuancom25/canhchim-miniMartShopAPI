package com.canhchim.martapi.module;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/shop/test")
public class TestController {
    @GetMapping("a")
    public String a() {
        return  "a";
    }

    public ResponseEntity<Test> getData() {

        return  ResponseEntity.ok().body( new Test()) ;
    }
    class Test{
    }
}
