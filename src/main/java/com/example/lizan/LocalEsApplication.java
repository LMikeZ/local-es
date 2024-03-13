package com.example.lizan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(scanBasePackages = {"com.example.lizan"},exclude = HibernateJpaAutoConfiguration.class)
@MapperScan(basePackages =  "com.example.lizan")
public class LocalEsApplication {

    public static void main(String[] args) {
        SpringApplication.run(LocalEsApplication.class, args);
    }

}
