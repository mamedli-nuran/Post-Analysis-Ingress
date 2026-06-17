package com.post.ms.post.client.external;

import java.util.List;

public record ReactionsInfo(
        List<Object> data,
        Paging paging,
        Summary summary
) {}
