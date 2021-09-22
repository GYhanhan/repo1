package com.star.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description: 音乐盒页面显示控制器

 */
@Controller
@RequestMapping("/templates")
public class MusicShowController {

    @GetMapping("/music")
    public String about() {
        return "music";
    }

}