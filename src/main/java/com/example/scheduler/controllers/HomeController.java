package com.example.scheduler.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "scheduler";
    }

    @GetMapping("/user")
    @ResponseBody
    public String user() {
        return "<h1>Welcome user</h1>";
    }

    @GetMapping("/admin")
    @ResponseBody
    public String admin() {
        return "<h1>Welcome admin</h1>";
    }

}
