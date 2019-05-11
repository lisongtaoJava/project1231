package com.atlisongtao.project1231.manage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
//通过使用@MapperScan可以指定要扫描的Mapper类的包的路径
@MapperScan(basePackages = "com.atlisongtao.project1231.manage.mapper")
public class LisongtaoManageServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LisongtaoManageServiceApplication.class, args);
    }

}

