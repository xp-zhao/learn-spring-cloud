package com.cloud.springcloudconsumer.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @description: 远程调用
 * @author: zhaoxiaoping
 * @create: 2019/06/22
 **/
@FeignClient(name = "spring-cloud-producer")
public interface HelloRemote {

  @RequestMapping("/hello")
  String hello(@RequestParam(value = "name") String name);
}