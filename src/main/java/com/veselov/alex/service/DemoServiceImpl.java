package com.veselov.alex.service;

import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {
    @Override
    public String getHelloMsg(String user) {
        return String.format("Hello %s", user);
    }

    @Override
    public String getWelcomeMsg() {
        return "Welcome to this Demo app.";
    }
}
