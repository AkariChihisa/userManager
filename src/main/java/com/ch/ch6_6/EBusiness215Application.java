package com.ch.ch6_6;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages={"com.ch.ch6_6.repository"})
public class EBusiness215Application {

	public static void main(String[] args) {
		SpringApplication.run(EBusiness215Application.class, args);
	}

}
