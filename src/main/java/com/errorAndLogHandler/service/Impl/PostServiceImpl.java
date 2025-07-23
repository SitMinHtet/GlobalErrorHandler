package com.errorAndLogHandler.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.errorAndLogHandler.component.mappers.PostMapper;
import com.errorAndLogHandler.dto.PostDTO;
import com.errorAndLogHandler.entity.Post;
import com.errorAndLogHandler.entity.User;
import com.errorAndLogHandler.exception.commonException.NotFoundException;
import com.errorAndLogHandler.repository.PostRepository;
import com.errorAndLogHandler.repository.UserRepository;
import com.errorAndLogHandler.service.PostService;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostMapper postMapper;

    @Override
    public void createPost(PostDTO postDTO) {
        User currentUser = getCurrentUser();
        if (currentUser == null) {
            throw new NotFoundException("User not found");
        }
        Post post = postMapper.toDto(postDTO);
        post.setCreatedUserId(currentUser.getId());
        postRepository.save(post);
    }

    @Override
    public List<PostDTO> getAllPost() {
        User currentUser = getCurrentUser();
        if (currentUser == null) {
            throw new NotFoundException("User not found");
        }
        Long userId = currentUser.getId();
        List<Post> postList = postRepository.findByCreatedUserId(userId);
        List<PostDTO> postDTOList = postMapper.toDtoList(postList);
        return postDTOList;
    }

    public User getCurrentUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByUsername(username);
    }

    
}
