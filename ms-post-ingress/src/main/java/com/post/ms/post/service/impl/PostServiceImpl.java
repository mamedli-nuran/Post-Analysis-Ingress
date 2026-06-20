package com.post.ms.post.service.impl;

import com.post.ms.post.client.external.MetaFeedResponse;
import com.post.ms.post.dto.response.BestWeekDayResponse;
import com.post.ms.post.dto.response.EngagementInfoResponse;
import com.post.ms.post.dto.response.PostInfoResponse;
import com.post.ms.post.client.MetaFeignClient;
import com.post.ms.post.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.post.ms.post.mapper.MetaMapper.META_MAPPER;
import static com.post.ms.post.mapper.PostMapper.POST_MAPPER;
import static com.post.ms.post.util.ApplicationConstants.*;
import static com.post.ms.post.util.MockPostsGenerator.POSTS_GENERATOR;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final MetaFeignClient metaFeignClient;

    @Override
    public List<PostInfoResponse> getLimitedPosts() {
        final MetaFeedResponse feed;
        try {
            feed = metaFeignClient.getFeed(FIELD_FOR_POST_INFO, POST_LIMIT);
        } catch (Exception e) {
            log.error(META_API_NOT_AVAILABLE);
            log.error(e.getMessage());
            return POSTS_GENERATOR.getMockPosts();
        }

        return META_MAPPER.toPostResponse(feed.data());

    }

    @Override
    public List<EngagementInfoResponse> getEngagementPosts() {
        List<PostInfoResponse> posts = getLimitedPosts().stream()
                .sorted(Comparator.comparingInt(this::calculateEngagement).reversed())
                .limit(3)
                .toList();

        return posts.stream()
                .map(POST_MAPPER::toEngagementResponse)
                .toList();
    }

    @Override
    public BestWeekDayResponse getBestDay() {
        Map<DayOfWeek, Integer> likesByDay = getLikesByDay(getLimitedPosts());

        Map.Entry<DayOfWeek, Integer> bestDayData = likesByDay.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .orElseThrow();

        return POST_MAPPER.toBestWeekDayResponse(bestDayData);
    }

    private int calculateEngagement(PostInfoResponse post) {
        return post.commentTotalCount() + post.reactionTotalCount();
    }

    private Map<DayOfWeek, Integer> getLikesByDay(List<PostInfoResponse> posts) {

        return posts.stream()
                .collect(Collectors.groupingBy(
                        post -> post.createdTime().getDayOfWeek(),
                        Collectors.summingInt(PostInfoResponse::reactionTotalCount)
                ));
    }

}
