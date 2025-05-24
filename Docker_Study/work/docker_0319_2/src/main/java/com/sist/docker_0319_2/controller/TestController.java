package com.sist.docker_0319_2.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {
  @Value("${values.msg}")
  private String msg;

  @RequestMapping("/msg")
  public Map<String, Object> test() {
    Map<String, Object> map = new HashMap<>();
    map.put("msg", msg);
    return map;
  }
}
