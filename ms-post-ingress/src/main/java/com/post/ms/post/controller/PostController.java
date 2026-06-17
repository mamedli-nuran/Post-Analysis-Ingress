package com.post.ms.post.controller;

import com.post.ms.post.feign.MetaFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PostController {
    private final MetaFeignClient metaFeignClient;

    String fields = "id,message,created_time,reactions.summary(true),comments.summary(true)";
    int limit = 20;

    @GetMapping("/posts")
    public ResponseEntity<?> getPosts() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(metaFeignClient.getFeed(fields,  limit));

    }

}
