package com.cloud.hystrix.service;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.HystrixCommandProperties.ExecutionIsolationStrategy;
import com.netflix.hystrix.HystrixThreadPoolKey;
import com.netflix.hystrix.HystrixThreadPoolProperties;
import java.util.concurrent.TimeUnit;

/**
 * CommandOrder.java 订单服务
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/14
 **/
public class CommandOrder extends HystrixCommand<String> {

  private String orderName;

  protected CommandOrder(String orderName) {
    super(Setter.withGroupKey(
        // 服务分组
        HystrixCommandGroupKey.Factory.asKey("OrderGroup"))
        // 线程分组
        .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("OrderPool"))
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
    this.orderName = orderName;
  }

  @Override
  protected String run() throws Exception {
    TimeUnit.MICROSECONDS.sleep(100);
    return "OrderName = " + orderName;
  }
}