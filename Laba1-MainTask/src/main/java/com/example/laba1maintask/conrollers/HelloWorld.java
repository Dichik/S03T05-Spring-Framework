package com.example.laba1maintask.conrollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloWorld {
    @RequestMapping("/hello")
    public String helloWorld() {
        return "hello.html";
    }

}
