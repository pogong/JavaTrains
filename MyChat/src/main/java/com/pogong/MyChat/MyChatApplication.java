package com.pogong.MyChat;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.pogong.MyChat.dao")
public class MyChatApplication{
	public static void main(String[] args) {
		SpringApplication.run(MyChatApplication.class, args);
	}
}
