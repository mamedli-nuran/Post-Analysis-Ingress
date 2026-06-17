package com.post.ms.post.client.external;

import java.util.List;

public record MetaFeedResponse(
        List<PostItem> data,
        Paging paging
) {}
