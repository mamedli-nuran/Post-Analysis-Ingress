package com.post.ms.post.dto.response;


import lombok.Builder;

@Builder
public record PostInfoResponse (
        String id,
        String message,
        String createdTime,
        Integer commentTotalCount,
        Integer reactionTotalCount,
        Integer engagement
){}
