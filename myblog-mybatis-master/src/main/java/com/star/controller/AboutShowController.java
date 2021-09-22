package com.star.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description: 关于我界面显示控制器

 */
@Controller
@RequestMapping("/templates")
public class AboutShowController {

    @GetMapping("/about")
    public String about() {
        return "about";
    }

}