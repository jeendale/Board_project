package com.jeendale.demo.entity;

import com.jeendale.demo.dto.PostAddRequestDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name="post")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostEntity extends TimeEntity{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,length = 20)
    private String title;
    @Column(nullable = false,length = 20)
    private String author;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false,length = 500)
    private String content;

    public PostEntity(PostAddRequestDto requestDto) {
        this.title=requestDto.getTitle();
        this.author=requestDto.getAuthor();
        this.password= requestDto.getPassword();;
        this.content= requestDto.getContent();
    }
}
