package com.jeendale.demo.controller;

import com.jeendale.demo.dto.PostAddRequestDto;
import com.jeendale.demo.dto.PostResponseDto;
import com.jeendale.demo.dto.PostUpdateRequestDto;
import com.jeendale.demo.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/posts")
public class PostController {
    private final PostService postService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PostResponseDto addPost(@RequestBody PostAddRequestDto requestDto){
        PostResponseDto responseDto = postService.addPost(requestDto);
        return responseDto;
    }
    @GetMapping("/{postId}")
    public PostResponseDto getPost(
            @PathVariable Long postId
    ){
        return postService.getPost(postId);
    }
    @GetMapping
    public List<PostResponseDto> getPosts(){
        return postService.getPosts();
    }

    @PatchMapping("/{postId}")
    public PostResponseDto updatePost(
            @PathVariable Long postId,
            @RequestBody PostUpdateRequestDto requestDto
    ){
        return postService.updatePost(postId,requestDto);
    }

}
