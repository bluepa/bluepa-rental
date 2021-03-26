package com.bluepa.backend.post.repository;

import com.bluepa.backend.post.domain.Post;
import org.springframework.data.elasticsearch.core.geo.GeoJsonPoint;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostRepositoryImpl implements PostRepository {

    public List<Post> searchPost(String keyword, GeoJsonPoint location) {
        return null;
    }
}
