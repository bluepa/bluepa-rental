package com.bluepa.backend.post.service;

import static org.mockito.ArgumentMatchers.any;

import com.bluepa.backend.post.config.PostIndexNameConfig;
import com.bluepa.backend.post.domain.Post;
import com.bluepa.backend.post.repository.PostRepository;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.elasticsearch.core.geo.GeoJsonPoint;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class PostServiceTest {

    @InjectMocks
    PostService postService;

    @Mock
    PostRepository postRepository;

    @Mock
    PostIndexNameConfig postIndexNameConfig;

    Post post;

    @BeforeEach
    void init() {
        post = Post.builder()
            .id("axizd")
            .title("test Title")
            .author("test Author")
            .content("set Content")
            .location(GeoJsonPoint.of(100, 100))
            .build();
    }

    @Test
    void 글쓰기() {
        given(postRepository.save(any())).willReturn(post);
        given(postRepository.findById(post.getId())).willReturn(Optional.of(post));

        String saveId = postService.write(post, "iksan");
        Post findPost = postService.findOne(saveId).get();

        then(postRepository).should().save(any());
        then(postRepository).should().findById(post.getId());
        assertThat(post).isEqualTo(findPost);
    }
}
