package com.post.ms.post.service.impl;

import com.post.ms.post.client.external.MetaFeedResponse;
import com.post.ms.post.dto.response.PostInfoResponse;
import com.post.ms.post.client.MetaFeignClient;
import com.post.ms.post.service.PostService;
import com.post.ms.post.util.MockPostsGenerator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

import static com.post.ms.post.mapper.MetaMapper.META_MAPPER;
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
            log.warn(META_API_NOT_AVAILABLE);
            return POSTS_GENERATOR.getMockPosts();
        }

        return META_MAPPER.toPostResponse(feed.data());

    }

    @Override
    public List<PostInfoResponse> getEngagementPosts() {

        // todo добавить поле где показывается engagement для каждого поста
        return getLimitedPosts().stream()
                .sorted(Comparator.comparingInt(this::calculateEngagement)
                                .reversed())
                .limit(3)
                .toList();
    }


    private int calculateEngagement(PostInfoResponse post) {
        return post.commentTotalCount() + post.reactionTotalCount();
    }


}
