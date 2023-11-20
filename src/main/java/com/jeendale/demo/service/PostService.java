package com.jeendale.demo.service;

import com.jeendale.demo.dto.PostAddRequestDto;
import com.jeendale.demo.dto.PostResponseDto;
import com.jeendale.demo.entity.PostEntity;
import com.jeendale.demo.repository.PostJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
