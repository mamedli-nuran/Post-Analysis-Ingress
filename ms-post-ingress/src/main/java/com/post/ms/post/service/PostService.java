package com.post.ms.post.service;

import com.post.ms.post.dto.response.EngagementInfoResponse;
import com.post.ms.post.dto.response.PostInfoResponse;

import java.util.List;

public interface PostService {
    List<PostInfoResponse> getLimitedPosts();
    List<EngagementInfoResponse> getEngagementPosts();
}
