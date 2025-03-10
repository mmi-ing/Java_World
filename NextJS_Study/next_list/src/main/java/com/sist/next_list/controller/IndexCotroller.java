package com.sist.next_list.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexCotroller {
    @RequestMapping("/")
    public String requestMethodName() {
        return "index";
    }
    
}
