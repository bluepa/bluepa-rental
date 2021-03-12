package com.bluepa.backend.post.service;

import com.bluepa.backend.post.domain.Post;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.geo.GeoJsonPoint;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
class PostServiceTest {

    @Autowired PostService postService;

    @Test
    void write() {
        Post post = new Post();
        post.setTitle("test Title");
        post.setAuthor("test Author");
        post.setContent("set Content");
        post.setLocation(GeoJsonPoint.of(100, 100));

        String saveId = postService.write(post);

        Post findPost = postService.findOne(saveId).get();
        assertThat(post).isEqualTo(findPost);
    }
}
