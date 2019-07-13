package com.cloud.config.client.config;

import java.util.List;
import java.util.Map;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * PersonConfig.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/06/27
 **/
@Component
@ConfigurationProperties(prefix = "person")
public class PersonConfig {

  private String name;
  private Integer id;
  private List<String> list;
  private Map<String, String> map;

  public PersonConfig() {

  }

  public PersonConfig(String name, Integer id, List<String> list,
      Map<String, String> map) {
    this.name = name;
    this.id = id;
    this.list = list;
    this.map = map;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public List<String> getList() {
    return list;
  }

  public void setList(List<String> list) {
    this.list = list;
  }

  public Map<String, String> getMap() {
    return map;
  }

  public void setMap(Map<String, String> map) {
    this.map = map;
  }

  @Override
  public String toString() {
    return "PersonConfig{" +
        "name='" + name + '\'' +
        ", id=" + id +
        ", list=" + list +
        ", map=" + map +
        '}';
  }
}