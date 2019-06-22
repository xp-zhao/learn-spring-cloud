package com.cloud.springcloudconsumer.remote;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @description: HelloRemote回调类
 * @author: zhaoxiaoping
 * @create: 2019/06/22
 **/
@Component
public class HelloRemoteHystrix implements HelloRemote {

  @Override
  public String hello(@RequestParam(value = "name") String name) {
    return "hello" + name + ", this messge send failed ";
  }
}