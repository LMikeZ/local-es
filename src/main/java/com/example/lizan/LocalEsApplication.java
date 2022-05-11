package com.example.lizan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.example.lizan" })
public class LocalEsApplication {

    public static void main(String[] args) {
        SpringApplication.run(LocalEsApplication.class, args);
    }

}
