package com.cloud.config.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 配置文件控制类
 * @author: zhaoxiaoping
 * @create: 2019/06/25
 **/
@RestController
public class ConfigController {

  @Value("${cloud.hello}")
  private String hello;

  @RequestMapping("/hello")
  public String hello() {
    return hello;
  }
}