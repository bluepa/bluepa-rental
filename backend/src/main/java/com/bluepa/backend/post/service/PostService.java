package com.bluepa.backend.post.service;

import com.bluepa.backend.post.domain.Post;
import com.bluepa.backend.post.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class PostService {

  private final PostRepository postRepository;

  public PostService(PostRepository postRepository) {
    this.postRepository = postRepository;
  }

  /**
   * 글쓰기
   */
  public String write(Post post) {
    postRepository.save(post);
    return post.getId();
  }
}
