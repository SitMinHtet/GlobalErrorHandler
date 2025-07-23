package com.errorAndLogHandler.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.errorAndLogHandler.dto.PostDTO;
import com.errorAndLogHandler.service.PostService;

@RestController
@RequestMapping("/api/")
public class PostController {
    
    @Autowired
    private PostService postService;

    @PostMapping("posts")
    public void createPost(@RequestBody PostDTO postDTO){
        postService.createPost(postDTO);
    }

    @GetMapping("posts")
    public ResponseEntity<?> getAllPost() {
        return ResponseEntity.ok(postService.getAllPost());
    }
}
