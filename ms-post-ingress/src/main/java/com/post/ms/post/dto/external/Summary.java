package com.post.ms.post.dto.external;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Summary(
        @JsonProperty("total_count") int totalCount
) {}