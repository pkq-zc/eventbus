package com.buydeem.ex2;

import com.google.common.eventbus.Subscribe;

import java.util.Random;

/**
 * @Auther: zengchao
 * @Date: 2019/7/26 21:32
 * @Description:
 */
public class MessageLister {
    @Subscribe
    public void processMessage(Object event) throws InterruptedException {
        Random r = new Random();
        int number = r.nextInt(10);
        Thread.sleep(number*1000);
        String name = Thread.currentThread().getName();
        System.out.println(String.format("当前线程名称:[%s],消息内容为:[%s]",name,event.toString()));
    }
}
