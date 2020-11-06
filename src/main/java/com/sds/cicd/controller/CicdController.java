package com.sds.cicd.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CicdController {

    @GetMapping("/helloworld")
    public String helloworld(){
        System.out.println("helloworld");
        return "helloworld";
    }
}
