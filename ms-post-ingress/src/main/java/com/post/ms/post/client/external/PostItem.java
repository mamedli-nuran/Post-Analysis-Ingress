package com.post.ms.post.client.external;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PostItem(
        String id,
        String message,
        @JsonProperty("created_time") String createdTime,
        ReactionsInfo reactions,
        CommentsInfo comments
) {}