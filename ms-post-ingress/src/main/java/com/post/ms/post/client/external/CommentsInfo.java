package com.post.ms.post.client.external;

import java.util.List;

public record CommentsInfo(
        List<Object> data, // Список самих комментариев (в вашем примере пустой)
        Summary summary
) {}