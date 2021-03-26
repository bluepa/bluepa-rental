package com.bluepa.backend.post.repository;

import com.bluepa.backend.post.domain.Post;

import java.util.List;
import java.util.Optional;

import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface JpaPostRepository extends ElasticsearchRepository<Post, String>, PostRepository {

    Optional<Post> findById(String id);
}
