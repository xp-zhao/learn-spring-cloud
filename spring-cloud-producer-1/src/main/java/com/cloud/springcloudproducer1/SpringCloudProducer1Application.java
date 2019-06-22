package com.cloud.springcloudproducer1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudProducer1Application {

  public static void main(String[] args) {
    SpringApplication.run(SpringCloudProducer1Application.class, args);
  }

}
