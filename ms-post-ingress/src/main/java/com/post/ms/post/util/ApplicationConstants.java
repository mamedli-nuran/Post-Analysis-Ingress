package com.post.ms.post.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ApplicationConstants {
    // todo fix token expired bug
    // FeignException$Unauthorized
    public static final String FIELD_FOR_POST_INFO = "id,message,created_time,reactions.summary(true),comments.summary(true)";
    public static final Integer POST_LIMIT = 20;

    public static final String AUTH_HEADER_NAME = "Authorization";
    public static final String AUTH_HEADER_PREFIX = "Bearer ";
}
