package com.post.ms.post.configuration;


import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientConfig {

    @Value("${meta.api.access-token}")
    private String accessToken;

    @Bean
    public RequestInterceptor feignAuthInterceptor() {
        return new RequestInterceptor() {
            @Override
            public void apply(RequestTemplate template) {
                template.header("Authorization", "Bearer " + accessToken);
            }
        };
    }
}