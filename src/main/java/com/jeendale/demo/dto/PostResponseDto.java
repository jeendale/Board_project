package com.jeendale.demo.dto;

import com.jeendale.demo.entity.PostEntity;
import lombok.Getter;

import java.time.LocalDateTime;

public record PostResponseDto (
    Long id,
    String title,
    String author,
    String content,
    LocalDateTime createdAt
    ) {
    public PostResponseDto(PostEntity savePost) {
        this(
                savePost.getId(),
                savePost.getTitle(),
                savePost.getAuthor(),
                savePost.getContent(),
                savePost.getCreatedAt()
        );
    }
}
