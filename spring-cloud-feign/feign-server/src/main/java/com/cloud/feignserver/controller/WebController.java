package com.cloud.feignserver.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

  @PostMapping("/post")
  public void web(@RequestHeader(value = "reqKey", defaultValue = "0") String reqKey) {
    System.out.println(reqKey);
    System.out.println("请求成功");
  }
}
