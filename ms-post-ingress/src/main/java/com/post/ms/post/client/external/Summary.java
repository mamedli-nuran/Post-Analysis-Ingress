package com.post.ms.post.client.external;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Summary(
        @JsonProperty("total_count") int totalCount
) {}