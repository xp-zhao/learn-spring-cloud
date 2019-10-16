package com.cloud.feignclient.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "feign", url = "${remote.url}")
public interface FeignRemote {

  /**
   * 请求示例
   */
  @PostMapping(value = "/feignServer/post", headers = {"reqKey=${remote.url}"})
  void web();
}
