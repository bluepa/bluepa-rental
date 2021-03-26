package com.bluepa.backend.post.service;

import static org.mockito.ArgumentMatchers.any;

import com.bluepa.backend.post.config.PostIndexNameConfig;
import com.bluepa.backend.post.domain.Post;
import com.bluepa.backend.post.repository.JpaPostRepository;

import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.elasticsearch.core.geo.GeoJsonPoint;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PostServiceTest {

    @InjectMocks
    PostServiceImpl postService;

    @Mock
    JpaPostRepository postRepository;

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
        when(postRepository.save(any())).thenReturn(post);
        when(postRepository.findById(post.getId())).thenReturn(Optional.of(post));

        String saveId = postService.write(post, "iksan");
        Post findPost = postService.findOne(saveId).get();

        verify(postRepository).save(any());
        verify(postRepository).findById(post.getId());
        verify(postIndexNameConfig).setCityName("iksan");

        assertThat(post).isEqualTo(findPost);
    }

    @Test
    void 검색() {
        when(postRepository.searchPost("test Title", GeoJsonPoint.of(123, 123))).thenReturn(List.of(post));

        List<Post> posts = postRepository.searchPost("test Title", GeoJsonPoint.of(123, 123));

        verify(postRepository).searchPost("test Title", GeoJsonPoint.of(123, 123));

        assertThat(post).isEqualTo(posts.get(0));
    }
}
