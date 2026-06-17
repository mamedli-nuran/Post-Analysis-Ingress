package com.post.ms.post.configuration;


import com.post.ms.post.properties.ApplicationProperties;
import feign.RequestInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.post.ms.post.util.ApplicationConstants.AUTH_HEADER_NAME;
import static com.post.ms.post.util.ApplicationConstants.AUTH_HEADER_PREFIX;

@Configuration
@RequiredArgsConstructor
public class FeignClientConfig {
    private final ApplicationProperties applicationProperties;

    @Bean
    public RequestInterceptor feignAuthInterceptor() {
        return template ->
                template.header(
                        AUTH_HEADER_NAME,
                        AUTH_HEADER_PREFIX + applicationProperties.accessToken());
    }
}