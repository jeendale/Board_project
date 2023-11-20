package com.jeendale.demo.repository;

import com.jeendale.demo.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostJpaRepository extends JpaRepository<PostEntity,Long> {
}
