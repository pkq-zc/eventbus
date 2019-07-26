package com.buydeem.ex2;

import com.buydeem.ex1.ChildMessage;
import com.buydeem.ex1.ParentMessage;
import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: zengchao
 * @Date: 2019/7/23 22:20
 * @Description:
 */
public class App {
    public static void main(String[] args) {
        //创建线程工厂
        ThreadFactory threadFactory = new ThreadFactory() {
            private static final String prefixName = "处理消息线程-";
            private int count = 1;
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r);
                t.setName(prefixName+count);
                count++;
                return t;
            }
        };
        //创建线程池
        ThreadPoolExecutor executor = new ThreadPoolExecutor(4, 4, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(), threadFactory);
        //创建异步消息处理
        AsyncEventBus asyncEventBus = new AsyncEventBus(executor);
        asyncEventBus.register(new MessageLister());
        //发送消息
        for (int i = 0; i < 10; i++) {
            String message = "message id is :" + i;
            asyncEventBus.post(message);
            System.out.println("已发送消息 = "+message);
        }
    }
}
