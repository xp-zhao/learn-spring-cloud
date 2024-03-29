package com.cloud.hystrix.service;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.HystrixCommandProperties.ExecutionIsolationStrategy;
import com.netflix.hystrix.HystrixThreadPoolKey;
import com.netflix.hystrix.HystrixThreadPoolProperties;
import java.util.concurrent.TimeUnit;

/**
 * CommandOrder.java 用户服务
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/14
 **/
public class CommandUser extends HystrixCommand<String> {

  private String userName;

  protected CommandUser(String userName) {
    super(Setter.withGroupKey(
        // 服务分组
        HystrixCommandGroupKey.Factory.asKey("UserGroup"))
        // 线程分组
        .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("UserPool"))
        // 线程池配置
        .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter()
            .withCoreSize(10)
            .withKeepAliveTimeMinutes(5)
            .withMaxQueueSize(10)
            .withQueueSizeRejectionThreshold(10000))
        .andCommandPropertiesDefaults(
            HystrixCommandProperties.Setter()
                .withExecutionIsolationStrategy(ExecutionIsolationStrategy.THREAD)
        ));
    this.userName = userName;
  }

  @Override
  protected String run() throws Exception {
    TimeUnit.MICROSECONDS.sleep(100);
    return "UserName = " + userName;
  }
}