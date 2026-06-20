package com.post.ms.post.mapper;

import com.post.ms.post.client.external.PostItem;
import com.post.ms.post.dto.response.PostInfoResponse;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public enum MetaMapper {
    META_MAPPER;


    final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssZ");

    public List<PostInfoResponse> toPostResponse(List<PostItem> data) {
        List<PostInfoResponse> list = new ArrayList<>();
        for (PostItem postItem : data) {
            list.add(
                    PostInfoResponse.builder()
                            .id(postItem.id())
                            .message(postItem.message())
                            .createdTime(OffsetDateTime.parse(postItem.createdTime(), formatter))
                            .reactionTotalCount(postItem.reactions().summary().totalCount())
                            .commentTotalCount(postItem.comments().summary().totalCount())
                            .build()
            );
        }
        return list;
    }

}
