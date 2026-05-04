package com.example.todoapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodoApiApplication {

	public static void main(String[] args) {
		System.setProperty("spring.h2.console.enabled", "true"); // 強制設定
		SpringApplication.run(TodoApiApplication.class, args);
	}

}
