package com.example.angularschool.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping({"/","/home"})
    public String homePage(){
        return "index";
    }
}
