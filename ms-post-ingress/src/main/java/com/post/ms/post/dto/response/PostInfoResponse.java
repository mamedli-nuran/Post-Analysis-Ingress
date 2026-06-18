package com.post.ms.post.dto.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public record PostInfoResponse (
        String id,
        String message,
        String createdTime,
        Integer commentTotalCount,
        Integer reactionTotalCount
){}
