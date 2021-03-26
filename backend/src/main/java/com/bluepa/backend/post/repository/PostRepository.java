package com.bluepa.backend.post.repository;

import com.bluepa.backend.post.domain.Post;
import org.springframework.data.elasticsearch.core.geo.GeoJsonPoint;

import java.util.List;

public interface PostRepository {

    List<Post> searchPost(String keyword, GeoJsonPoint location);
}
