package com.bluepa.backend.post.repository;

import com.bluepa.backend.post.domain.Post;
import com.bluepa.backend.post.dto.FilterRequest;
import com.bluepa.backend.post.dto.SearchRequest;
import org.springframework.data.elasticsearch.core.geo.GeoJsonPoint;

import java.util.List;

public interface PostRepository {

    List<Post> searchPost(SearchRequest searchRequest, FilterRequest filter);
}
