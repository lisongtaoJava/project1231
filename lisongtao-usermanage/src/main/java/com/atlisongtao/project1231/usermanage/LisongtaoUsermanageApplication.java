package com.atlisongtao.project1231.usermanage;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.atlisongtao.project1231.usermanage.mapper")
public class LisongtaoUsermanageApplication {

	public static void main(String[] args) {
		SpringApplication.run(LisongtaoUsermanageApplication.class, args);
	}

}

