package com.cloud.feignserver.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    @PostMapping("/post")
    public void web(){
        System.out.println("请求成功");
    }
}
