package com.post.ms.post.service.impl;

import com.post.ms.post.client.external.MetaFeedResponse;
import com.post.ms.post.dto.response.PostInfoResponse;
import com.post.ms.post.client.MetaFeignClient;
import com.post.ms.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.post.ms.post.mapper.MetaMapper.META_MAPPER;
import static com.post.ms.post.util.ApplicationConstants.FIELD_FOR_POST_INFO;
import static com.post.ms.post.util.ApplicationConstants.POST_LIMIT;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final MetaFeignClient metaFeignClient;

    @Override
    public List<PostInfoResponse> getPosts() {
        MetaFeedResponse feed = metaFeignClient.getFeed(FIELD_FOR_POST_INFO, POST_LIMIT);
        return META_MAPPER.toPostResponse(feed.data());
    }
}
