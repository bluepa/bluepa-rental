package com.bluepa.backend.post.service;

import static org.mockito.ArgumentMatchers.any;

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
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PostServiceTest {

    @InjectMocks
    PostService postService;

    @Mock
    PostRepository postRepository;

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

        assertThat(post).isEqualTo(findPost);
    }
}
