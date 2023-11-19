package com.jeendale.demo.controller;

import com.jeendale.demo.dto.PostAddRequestDto;
import com.jeendale.demo.dto.PostResponseDto;
import com.jeendale.demo.service.PostService;
import com.jeendale.demo.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/posts")
public class PostController {
    private final PostService postService;
    @PostMapping
    public PostResponseDto addPost(@RequestBody PostAddRequestDto requestDto){
        PostResponseDto responseDto = postService.addPost(requestDto);
        return responseDto;
    }


}
