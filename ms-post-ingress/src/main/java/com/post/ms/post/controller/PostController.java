package com.post.ms.post.controller;

import com.post.ms.post.dto.response.BestWeekDayResponse;
import com.post.ms.post.dto.response.EngagementInfoResponse;
import com.post.ms.post.dto.response.PostInfoResponse;
import com.post.ms.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping
    public ResponseEntity<List<PostInfoResponse>> getPosts() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(postService.getLimitedPosts());

    }


    @GetMapping("top")
    public ResponseEntity<List<EngagementInfoResponse>> getTopPosts() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(postService.getEngagementPosts());
    }

    @GetMapping("/best-day")
    public ResponseEntity<BestWeekDayResponse> getBestDay() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(postService.getBestDay());
    }


}
