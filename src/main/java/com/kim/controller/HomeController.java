package com.kim.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by admin on 2018/5/13.
 */
@Controller
public class HomeController {

    @RequestMapping()
    @ResponseBody
    public String home(){
        return "hello,kim";
    }
}
