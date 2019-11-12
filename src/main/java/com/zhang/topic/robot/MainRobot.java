package com.zhang.topic.robot;

import cn.hutool.core.util.StrUtil;
import io.github.biezhi.wechat.WeChatBot;
import io.github.biezhi.wechat.api.annotation.Bind;
import io.github.biezhi.wechat.api.constant.Config;
import io.github.biezhi.wechat.api.enums.AccountType;
import io.github.biezhi.wechat.api.enums.MsgType;
import io.github.biezhi.wechat.api.model.WeChatMessage;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MainRobot extends WeChatBot {

    public MainRobot(Config config) {
        super(config);
    }

    @Bind(msgType = MsgType.TEXT)
    public void handleText(WeChatMessage message) {
        if (StrUtil.isNotEmpty(message.getName())) {
            log.info("接收到 [{}] 的消息: {}", message.getName(), message.getText());
            this.sendMsg(message.getFromUserName(), "自动回复: " + message.getText());
        }
    }

    @Bind(accountType = AccountType.TYPE_FRIEND)
    public void friendMessage(WeChatMessage message) {
        if(StrUtil.isNotEmpty(message.getName())){
            log.info("接收到好友 [{}] 的消息: {}", message.getName(), message.getText());
            this.sendMsg(message.getFromUserName(), "自动回复: " + message.getText());
        }
    }
}
