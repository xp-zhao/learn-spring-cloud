package com.cloud.springcloudconsumer.controller;

import com.cloud.springcloudconsumer.remote.HelloRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 服务调用者控制层
 * @author: zhaoxiaoping
 * @create: 2019/06/22
 **/
@RestController
public class ConsumerController {

  @Autowired
  HelloRemote helloRemote;

  @RequestMapping("/hello/{name}")
  public String index(@PathVariable("name") String name) {
    return helloRemote.hello(name);
  }
}