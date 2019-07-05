package com.cloud.config.client.controller;

import com.cloud.config.client.config.PersonConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 配置文件控制类
 * @author: zhaoxiaoping
 * @create: 2019/06/25
 **/
@RestController
@RefreshScope
public class ConfigController {

  @Value("${cloud.hello}")
  private String hello;

  @Autowired
  private PersonConfig personConfig;

  @RequestMapping("/hello")
  public String hello() {
    return hello + "\nperson: " + personConfig.toString();
  }
}