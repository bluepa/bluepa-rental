package com.bluepa.backend.post.service;

import com.bluepa.backend.post.config.PostIndexNameConfig;
import com.bluepa.backend.post.domain.Post;
import com.bluepa.backend.post.repository.PostRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final PostIndexNameConfig postIndexNameConfig;

    public PostServiceImpl(PostRepository postRepository, PostIndexNameConfig postIndexNameConfig) {
        this.postRepository = postRepository;
        this.postIndexNameConfig = postIndexNameConfig;
    }

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
}
