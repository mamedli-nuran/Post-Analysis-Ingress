package com.post.ms.post.dto.response;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.time.OffsetDateTime;

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public record PostInfoResponse (
        String id,
        String message,

        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ")
        @JsonProperty("created_time")
        OffsetDateTime createdTime,

        Integer commentTotalCount,
        Integer reactionTotalCount
){}
