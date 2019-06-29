package com.ryanslevin.ereg.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestAPI {


    @RequestMapping("/getthatdata")
    public String getData() {
        return "test";
    }

}