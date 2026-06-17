package com.post.ms.post;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsPostIngressApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsPostIngressApplication.class, args);
    }

}
