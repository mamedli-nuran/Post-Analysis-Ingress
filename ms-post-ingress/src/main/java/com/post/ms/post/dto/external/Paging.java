package com.post.ms.post.dto.external;


public record Paging(
        String previous,
        String next,
        Cursors cursors
) {}