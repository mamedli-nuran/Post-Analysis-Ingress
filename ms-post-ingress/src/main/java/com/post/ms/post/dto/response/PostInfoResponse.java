package com.post.ms.post.dto.response;

public record PostInfoResponse (
        String id,
        String message,
        String createdTime,
        Integer commentTotalCount,
        Integer reactionTotalCount
){}
