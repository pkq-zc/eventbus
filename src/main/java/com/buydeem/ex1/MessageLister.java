package com.buydeem.ex1;

import com.google.common.eventbus.DeadEvent;
import com.google.common.eventbus.Subscribe;

/**
 * @Auther: zengchao
 * @Date: 2019/7/23 22:20
 * @Description:
 */
public class MessageLister {

    /**
     * 处理类型为 ParentMessage消息
     * @param message
     */
    @Subscribe
    public void processParentMessage(ParentMessage message){
        String name = Thread.currentThread().getName();
        System.out.println(String.format("当前线程名称:[%s],处理器名称:processParentMessage,消息处理器名称:[%s]",name,message.toString()));
    }

    /**
     * 处理类型为 ChildMessage消息
     * @param message
     */
    @Subscribe
    public void processChildMessage(ChildMessage message){
        String name = Thread.currentThread().getName();
        System.out.println(String.format("当前线程名称:[%s],处理器名称:processChildMessage,消息处理器名称:[%s]",name,message.toString()));
    }

    /**
     * 处理死信消息
     * @param event
     */
    @Subscribe
    public void processDeadEventMessage(DeadEvent event){
        String name = Thread.currentThread().getName();
        System.out.println(String.format("当前线程名称:[%s],处理器名称:processDeadEventMessage,消息处理器名称:[%s]",name,event.getEvent().toString()));
    }
}
