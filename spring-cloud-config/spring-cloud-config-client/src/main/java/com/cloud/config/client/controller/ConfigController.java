package com.cloud.config.client.controller;

import com.cloud.config.client.config.PersonConfig;
import com.cloud.config.client.entity.Employee;
import com.cloud.config.client.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description: 配置文件控制类
 * @author: zhaoxiaoping
 * @create: 2019/06/25
 **/
@RestController
@RefreshScope
public class ConfigController {

    @Value("${cloud.hello}")
    private String hello;
    @Value("${config.test}")
    private String config;
    @Value("${db.url}")
    private String dbUrl;
    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private PersonConfig personConfig;

    @RequestMapping("/hello")
    public String hello() {
        return hello + "\nperson: " + personConfig.toString();
    }

    @RequestMapping("/getConfig")
    public String getConfig() {
        return config;
    }

    @RequestMapping("/getDbUrl")
    public String getDbUrl(){
        return dbUrl;
    }

    @RequestMapping("/getAll")
    public List<Employee> getAll(){
        return repository.findAll();
    }
}