package com.buydeem.ex1;

import com.google.common.eventbus.EventBus;

/**
 * @Auther: zengchao
 * @Date: 2019/7/23 22:20
 * @Description:
 */
public class App {
    public static void main(String[] args) {
        //创建EventBus
        EventBus eventBus = new EventBus();
        //注册监听器
        eventBus.register(new MessageLister());
        //发送消息
        eventBus.post(new ParentMessage("1","this is parent message"));
        eventBus.post(new ChildMessage("2","this is child message","send"));
        eventBus.post("this is dead message");
    }
}
