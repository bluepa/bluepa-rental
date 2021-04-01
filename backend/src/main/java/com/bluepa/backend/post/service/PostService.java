package com.bluepa.backend.post.service;

import com.bluepa.backend.post.domain.Post;
import com.bluepa.backend.post.dto.FilterRequest;
import com.bluepa.backend.post.dto.SearchRequest;
import org.springframework.data.elasticsearch.core.geo.GeoJsonPoint;

import java.util.List;
import java.util.Optional;

public interface PostService {

    String write(Post post, String cityName);
    Optional<Post> findOne(String id);
    List<Post> search(SearchRequest searchRequest, FilterRequest filterRequest);
}
