package com.example.kakaobank_subject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value="com.example.kakaobank_subject.mapper")
@SpringBootApplication
public class KakaobankSubjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(KakaobankSubjectApplication.class, args);
	}

}
