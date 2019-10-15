package com.cloud.feignclient.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "feign", url = "http://localhost:8015")
public interface FeignRemote {
    @PostMapping("/feignServer/post")
    void web();
}
