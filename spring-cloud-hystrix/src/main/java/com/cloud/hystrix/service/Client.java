package com.cloud.hystrix.service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Client.java hystrix测试
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/14
 **/
public class Client {

  public static void main(String[] args)
      throws InterruptedException, ExecutionException, TimeoutException {
    CommandOrder commandPhone = new CommandOrder("手机");
    CommandOrder command = new CommandOrder("电视");

    // 阻塞的方式直执行
    String excute = commandPhone.execute();
    System.out.println(excute);

    // 异步非阻塞的方式运行
    Future<String> queue = command.queue();
    String value = queue.get(200, TimeUnit.MILLISECONDS);
    System.out.println(value);

    CommandUser commandUser = new CommandUser("张三");
    String name = commandUser.execute();
    System.out.println(name);
  }
}