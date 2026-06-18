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

    public static final String GLOBAL_ERROR_MESSAGE = "Unexcepted error occurred by Nuran team";
    public static final String META_API_NOT_AVAILABLE = "Meta API is not available";
}
