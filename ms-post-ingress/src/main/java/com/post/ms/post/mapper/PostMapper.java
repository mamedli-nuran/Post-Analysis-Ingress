package com.post.ms.post.mapper;

import com.post.ms.post.dto.response.EngagementInfoResponse;
import com.post.ms.post.dto.response.PostInfoResponse;

public enum PostMapper {
    POST_MAPPER;

    public EngagementInfoResponse toEngagementResponse(PostInfoResponse postInfoResponse) {
        return EngagementInfoResponse.builder()
                .id(postInfoResponse.id())
                .message(postInfoResponse.message())
                .createdTime(postInfoResponse.createdTime())
                .reactionTotalCount(postInfoResponse.reactionTotalCount())
                .commentTotalCount(postInfoResponse.commentTotalCount())
                .engagement(postInfoResponse.reactionTotalCount() +  postInfoResponse.commentTotalCount())
                .build();
    }
}
