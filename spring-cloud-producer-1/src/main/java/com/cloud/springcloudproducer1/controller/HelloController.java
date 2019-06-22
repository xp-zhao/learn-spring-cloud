package com.cloud.springcloudproducer1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 测试
 * @author: zhaoxiaoping
 * @create: 2019/06/22
 **/
@RestController
public class HelloController {

  @RequestMapping("/hello")
  public String index(@RequestParam String name) {
    return "hello " + name + ", this is producer 2  send first messge";
  }
}