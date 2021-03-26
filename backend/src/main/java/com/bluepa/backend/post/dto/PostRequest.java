package com.bluepa.backend.post.dto;

import com.bluepa.backend.post.domain.Post;
import lombok.Getter;
import org.springframework.data.elasticsearch.core.geo.GeoJsonPoint;

@Getter
public class PostRequest {

    String title;
    String author;
    String content;
    GeoJsonPoint location;
    String cityName;

    public Post getPost() {
        return Post.builder()
                .title(title)
                .author(author)
                .content(content)
                .location(location)
                .build();
    }
}
