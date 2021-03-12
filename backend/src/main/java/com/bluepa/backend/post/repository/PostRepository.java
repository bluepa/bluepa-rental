package com.bluepa.backend.post.repository;

import com.bluepa.backend.post.domain.Post;
import java.util.Optional;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface PostRepository extends ElasticsearchRepository<Post, String> {
  Optional<Post> findById(String id);
}
