package com.atguigu.springboot;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.atguigu.springboot.amqqp.bean.Book;

@SpringBootTest
class SpringBootRabbitMqApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;
    
    @Autowired
    AmqpAdmin amqpAdmin;
    
    
    
    @Test
    public void createExchange() {
        amqpAdmin.declareExchange(new DirectExchange("amqpadmin.exchange"));
    }
    
    @Test
    public void createQueue() {
        amqpAdmin.declareQueue(new Queue("amqpadmin.queue", true));
    }
    
    @Test
    public void createBinding() {
        amqpAdmin.declareBinding(new Binding("amqpadmin.queue", Binding.DestinationType.QUEUE, 
                "amqpadmin.exchange", "amqpadmin.haha", null));
    }
       
    /**
          *  广播
     */
    @Test
    void sendMsg() {
        rabbitTemplate.convertAndSend("exchange.fanout", null, new Book("三国演义", "罗贯中"));
    }
    
	/**
	 * 1.点播
	 */
	@Test
	void send() { 
	   // rabbitTemplate.send(exchange, routingKey, message);
	    Map<String, Object> map = new HashMap<>();
	    map.put("msg", "This is first message!");
	    map.put("data", Arrays.asList("helloworld",123,true));
	    
	    rabbitTemplate.convertAndSend("exchange.direct", "atguigu", map); 
	    rabbitTemplate.convertAndSend("exchange.direct", "atguigu.news", new Book("西游记", "吴承恩"));
	}
	
	@Test
	public void receive() {
	    Object object = rabbitTemplate.receiveAndConvert("atguigu");
	    System.out.println(object.getClass());
	    System.out.println(object);
	}

}
