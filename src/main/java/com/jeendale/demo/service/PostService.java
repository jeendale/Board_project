package com.jeendale.demo.service;

import com.jeendale.demo.dto.PostAddRequestDto;
import com.jeendale.demo.dto.PostResponseDto;
import com.jeendale.demo.dto.PostUpdateRequestDto;
import com.jeendale.demo.entity.PostEntity;
import com.jeendale.demo.repository.PostJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
       PostEntity postEntity = getPostEntity(postId);
        return new PostResponseDto(postEntity);
    }
    public List<PostResponseDto> getPosts() {
       return postJpaRepository.findAll().stream()
               .map(PostResponseDto::new).collect(Collectors.toList());
    }

    @Transactional
    public PostResponseDto updatePost(Long postId, PostUpdateRequestDto requestDto) {
        PostEntity postEntity= getPostEntity(postId);

        if(!postEntity.getPassword().equals(requestDto.getPassword())){
            throw new NullPointerException("비밀번호가 일치하지 않습니다.");
        }
        postEntity.update(requestDto);
        return new PostResponseDto(postEntity);
    }

    public void deletePost(Long postId,String password) {
        PostEntity postEntity=getPostEntity(postId);

        if(!postEntity.getPassword().equals(password)){
            throw new NullPointerException("비밀번호가 일치하지 않습니다.");
        }

        postJpaRepository.delete(postEntity);
    }
    private PostEntity getPostEntity(Long postId) {
        return postJpaRepository.findById(postId)
                .orElseThrow(() -> new NullPointerException("해당 게시글을 찾을 수 없습니다."));
    }

}
