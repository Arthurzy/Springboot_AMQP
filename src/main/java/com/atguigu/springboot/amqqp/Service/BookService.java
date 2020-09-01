package com.atguigu.springboot.amqqp.Service;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.atguigu.springboot.amqqp.bean.Book;

@Service
public class BookService {

    @RabbitListener(queues = "atguigu.news")
    public void receive(Book book) {
         System.out.println("收到消息， 消息内容是 = " + book);
    }
    
    @RabbitListener(queues = "atguigu")
    public void receiveMsg(Message message) {
        System.out.println("message.getMessageProperties() = " + message.getMessageProperties());
        System.out.println("message.getBody() = " + message.getBody());
    }
}
