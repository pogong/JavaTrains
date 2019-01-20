package com.pogong.MyChat;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
@MapperScan("com.pogong.MyChat.dao")
public class MyChatApplication{
	public static void main(String[] args) {
		SpringApplication.run(MyChatApplication.class, args);
	}
}
