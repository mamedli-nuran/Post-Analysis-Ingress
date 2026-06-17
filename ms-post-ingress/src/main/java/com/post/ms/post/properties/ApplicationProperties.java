package com.post.ms.post.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix = "meta.api")
public record ApplicationProperties (
        String baseUrl,
        String accessToken
){
}
