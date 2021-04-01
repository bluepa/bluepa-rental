package com.bluepa.backend.post.service;

import com.bluepa.backend.post.config.PostIndexNameConfig;
import com.bluepa.backend.post.domain.Post;
import com.bluepa.backend.post.dto.FilterRequest;
import com.bluepa.backend.post.dto.SearchRequest;
import com.bluepa.backend.post.repository.JpaPostRepository;

import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.data.elasticsearch.core.geo.GeoJsonPoint;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final JpaPostRepository postRepository;
    private final PostIndexNameConfig postIndexNameConfig;

    /**
     * 글쓰기
     *
     * @param post 글 제목, 글 작성자, 글 내용을 포함하고 있는 객체
     * @param cityName 글이 올라온 지역. 반드시 lowercase여야만 함
     * @return ElasticSearch에 색인된 글의 ID
     */
    public String write(Post post, String cityName) {
        postIndexNameConfig.setCityName(cityName);
        postRepository.save(post);
        return post.getId();
    }

    /**
     * 글 조회
     */
    public Optional<Post> findOne(String id){
        return postRepository.findById(id);
    }

    /**
     * 글 검색
     *
     * @param searchRequest 검색 dto
     * @param filterRequest 필터 dto
     * @return post 리스트
     */
    public List<Post> search(SearchRequest searchRequest, FilterRequest filterRequest) {
        return postRepository.searchPost(searchRequest, filterRequest);
    }
}
