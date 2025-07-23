package com.errorAndLogHandler.service;

import java.util.List;

import com.errorAndLogHandler.dto.PostDTO;

public interface PostService {

    void createPost(PostDTO postDTO);

    List<PostDTO> getAllPost();
} 
