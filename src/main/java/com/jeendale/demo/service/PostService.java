package com.jeendale.demo.service;

import com.jeendale.demo.dto.PostAddRequestDto;
import com.jeendale.demo.dto.PostResponseDto;
import com.jeendale.demo.entity.PostEntity;
import com.jeendale.demo.repository.PostJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostJpaRepository postJpaRepository;
    public PostResponseDto addPost(PostAddRequestDto requestDto) {
        //Dto->entity
        PostEntity postEntity =new PostEntity(requestDto);
        PostEntity savePost = postJpaRepository.save(postEntity);
        return new PostResponseDto(savePost);
    }

    public PostResponseDto getPost(Long postId) {
       PostEntity postEntity = postJpaRepository.findById(postId)
               .orElseThrow(()->new NullPointerException("해당 게시글을 찾을 수 없습니다."));
        return new PostResponseDto(postEntity);
    }

    public List<PostResponseDto> getPosts() {
       return postJpaRepository.findAll().stream()
               .map(PostResponseDto::new).collect(Collectors.toList());
    }
}
