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
        Post post = Post.builder()
            .title("test Title")
            .author("test Author")
            .content("test Content")
            .location(GeoJsonPoint.of(100, 100))
            .build();

        String saveId = postService.write(post);

        Post findPost = postService.findOne(saveId).get();

        assertThat(post.getId()).isEqualTo(findPost.getId());
        assertThat(post.getTitle()).isEqualTo(findPost.getTitle());
        assertThat(post.getAuthor()).isEqualTo(findPost.getAuthor());
        assertThat(post.getContent()).isEqualTo(findPost.getContent());
        assertThat(post.getLocation()).isEqualTo(findPost.getLocation());
    }
}
