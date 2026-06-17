package com.post.ms.post.mapper;

import com.post.ms.post.client.external.PostItem;
import com.post.ms.post.dto.response.PostInfoResponse;

import java.util.ArrayList;
import java.util.List;

public enum MetaMapper {
    META_MAPPER;


    public List<PostInfoResponse> toPostResponse(List<PostItem> data) {
        List<PostInfoResponse> list = new ArrayList<>();
        for (PostItem postItem : data) {
            list.add(new PostInfoResponse(postItem.id(), postItem.message(), postItem.createdTime(), postItem.comments().summary().totalCount(), postItem.reactions().summary().totalCount() ));
        }
        return list;
    }

}
