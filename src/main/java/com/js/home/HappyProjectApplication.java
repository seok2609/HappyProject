package com.js.home;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication

//AOP를 사용하기 위한 어노테이션이지만 생략가능 
//※잘 안 돌아간다면 활성화
@EnableAspectJAutoProxy
public class HappyProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(HappyProjectApplication.class, args);
	}

}
