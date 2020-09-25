package com.atguigu.springboot;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
  *  自动配置
 * A. RabbitAutoConfiguration
 * B. 有自动配置了连接工厂ConnectionFactory
 * C. RabbitProperties 封装了RabbitMQ的配置
 * D. RabbitTemplate: 给RabbitMQ发送和接受消息
 * E. AmqpAdmin: RabbitMQ系统管理功能组件
 * F. @EnableRabbit + @RabbitListener监听消息队列的内容
 */
@EnableRabbit // 开启基于注解的RabbitMQ模式
@SpringBootApplication
public class SpringBootAMQPApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAMQPApplication.class, args);
	}

}
