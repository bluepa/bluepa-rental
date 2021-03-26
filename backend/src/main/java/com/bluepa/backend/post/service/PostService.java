package com.bluepa.backend.post.service;

import com.bluepa.backend.post.domain.Post;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface PostService {

    String write(Post post, String cityName);
    Optional<Post> findOne(String id);
    List<Post> search(String keyword);
}
