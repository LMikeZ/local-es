package com.example.lizan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example.lizan"})
@MapperScan(basePackages =  "com.example.lizan.repository.mapper")
public class LocalEsApplication {

    public static void main(String[] args) {
        SpringApplication.run(LocalEsApplication.class, args);
    }

}
