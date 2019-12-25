package com.veselov.alex.controller;

import com.veselov.alex.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class DemoController {
    @Autowired
    private DemoService service;

    @ResponseBody
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("welcome")
    public String welcome(@RequestParam String user, @RequestParam int age, Model model) {
        model.addAttribute("helloMsg", this.service.getHelloMsg(user));
        model.addAttribute("age", age);
        log.info("Model -> {}", model);
        return "welcome";
    }

    @ModelAttribute("welcomeMessage")
    public String welcomeMsg() {
        log.info("+welcomeMsg()");
        return this.service.getWelcomeMsg();
    }

}
