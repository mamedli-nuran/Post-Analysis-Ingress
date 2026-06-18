package com.post.ms.post.mapper;

import com.post.ms.post.dto.response.BestWeekDayResponse;
import com.post.ms.post.dto.response.EngagementInfoResponse;
import com.post.ms.post.dto.response.PostInfoResponse;

import java.time.DayOfWeek;
import java.util.Map;

public enum PostMapper {
    POST_MAPPER;

    public EngagementInfoResponse toEngagementResponse(PostInfoResponse postInfoResponse) {
        return EngagementInfoResponse.builder()
                .id(postInfoResponse.id())
                .message(postInfoResponse.message())
                .createdTime(postInfoResponse.createdTime())
                .reactionTotalCount(postInfoResponse.reactionTotalCount())
                .commentTotalCount(postInfoResponse.commentTotalCount())
                .engagement(postInfoResponse.reactionTotalCount() + postInfoResponse.commentTotalCount())
                .build();
    }


    public BestWeekDayResponse toBestWeekDayResponse(Map.Entry<DayOfWeek, Integer> bestDay) {
        return BestWeekDayResponse.builder()
                .day(bestDay.getKey())
                .likes(bestDay.getValue())
                .build();
    }
}
