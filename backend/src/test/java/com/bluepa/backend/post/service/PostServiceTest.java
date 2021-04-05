package com.bluepa.backend.post.service;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

import com.bluepa.backend.post.config.PostIndexNameConfig;
import com.bluepa.backend.post.domain.Post;
import com.bluepa.backend.post.dto.SearchRequest;
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
        given(postRepository.save(any())).willReturn(post);
        given(postRepository.findById(post.getId())).willReturn(Optional.of(post));

        String saveId = postService.write(post, "iksan");
        Post findPost = postService.findOne(saveId).get();

        then(postRepository).should().save(any());
        then(postRepository).should().findById(post.getId());
        then(postIndexNameConfig).should().setCityName("iksan");
        assertThat(post).isEqualTo(findPost);
    }

    @Test
    void 검색() {
        SearchRequest searchRequest = SearchRequest.builder()
                .keyword("test Title")
                .cityName("iksan")
                .location(GeoJsonPoint.of(123, 123))
                .build();
        given(postRepository.searchPost(searchRequest, null)).willReturn(List.of(post));

        List<Post> posts = postService.search(searchRequest, null);

        then(postRepository).should().searchPost(searchRequest, null);
        assertThat(post).isEqualTo(posts.get(0));
    }
}
