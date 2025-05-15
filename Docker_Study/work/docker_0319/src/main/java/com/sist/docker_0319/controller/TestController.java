package com.sist.docker_0319.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {

  @RequestMapping("/test")
  public Map<String, Object> test() {
    Map<String, Object> map = new HashMap<>();
    map.put("msg", "Docker 연습");

    return map;
  }
}
