package com.errorAndLogHandler.component.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.errorAndLogHandler.dto.PostDTO;
import com.errorAndLogHandler.entity.Post;

@Component
public class PostMapper {
    
    public PostDTO toDto(Post post){
        PostDTO dto = new PostDTO(post.getTitle(),post.getBody());
        return dto;
    }

    public Post toDto(PostDTO postDTO){
        Post post = new Post(postDTO.getTitle(),postDTO.getBody());
        return post;
    }

    public List<PostDTO> toDtoList(List<Post> posts) {
        return posts.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
