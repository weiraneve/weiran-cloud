package com.weiran.apollo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/")
@RestController
public class TestController {

    @Value("${ap-key:default}")
    private String ap_key;

    @GetMapping("/get")
    public String getApolloKey(){
        return ap_key;
    }

}
