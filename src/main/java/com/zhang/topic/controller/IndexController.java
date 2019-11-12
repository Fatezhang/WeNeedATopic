package com.zhang.topic.controller;

import com.zhang.topic.robot.MainRobot;
import io.github.biezhi.wechat.api.constant.Config;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @RequestMapping("/")
    public String index() {
        new MainRobot(Config.me().autoLogin(true).showTerminal(true)).start();
        return "Hello wechat robot!";
    }
}
