package com.bluepa.backend.post.repository;

import com.bluepa.backend.post.domain.Post;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
  <S extends Post> S save(Post post);
  Optional<Post> findById(int id);
}
