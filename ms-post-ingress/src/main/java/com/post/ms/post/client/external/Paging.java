package com.post.ms.post.client.external;


public record Paging(
        String previous,
        String next,
        Cursors cursors
) {}