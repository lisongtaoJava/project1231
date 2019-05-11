package com.atlisongtao.project1231.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
/*
@ComponentScan注解就是定义扫描路径从中找出标识了需要装配的类自动装配到spring的bean容器中。

@ComponetScan,
@Controller,@Service,@repository,@Componet
观察源码就会发现这些注解都有一个共同注解，@ComponetScan。
@ComponetScan默认就会装配标识了@Controller,@Service,@repository,@Componet的注解的类到spring容器中
 */
@ComponentScan(basePackages = "com.atlisongtao.project1231")
public class LisongtaoOrderWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(LisongtaoOrderWebApplication.class, args);
	}

}

