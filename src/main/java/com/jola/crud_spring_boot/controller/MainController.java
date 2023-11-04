package com.jola.crud_spring_boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {


    @GetMapping("")
    public String homePage() {
        return "index";

    }
}