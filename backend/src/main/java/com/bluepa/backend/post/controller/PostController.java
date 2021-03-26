package com.bluepa.backend.post.controller;

import com.bluepa.backend.post.domain.Post;
import com.bluepa.backend.post.dto.PostRequest;
import com.bluepa.backend.post.dto.SearchRequest;
import com.bluepa.backend.post.service.PostService;
import java.net.URI;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("/api/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/{postId}")
    public Post read(@PathVariable String postId) {
        return postService.findOne(postId).get();
    }

    @PostMapping("/write")
    public ResponseEntity<?> write(@RequestBody PostRequest postRequest) {
        String cityName = postRequest.getCityName();
        Post post = postRequest.getPost();

        String postId = postService.write(post, cityName);
        return ResponseEntity.created(URI.create("/api/post/" + postId)).build();
    }

    @PostMapping("/search")
    public List<Post> search(@RequestBody SearchRequest searchRequest) {
        return postService.search(searchRequest.getKeyword(), searchRequest.getLocation());
    }
}
