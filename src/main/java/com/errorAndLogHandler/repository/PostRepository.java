package com.errorAndLogHandler.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.errorAndLogHandler.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post,Long>{

   List<Post> findByCreatedUserId(Long userId);
   
}
