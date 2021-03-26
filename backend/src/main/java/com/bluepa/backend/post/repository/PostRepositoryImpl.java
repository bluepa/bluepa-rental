package com.bluepa.backend.post.repository;

import com.bluepa.backend.post.domain.Post;
import java.util.ArrayList;
import org.elasticsearch.common.unit.DistanceUnit;
import org.elasticsearch.index.query.GeoDistanceQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.geo.GeoJsonPoint;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostRepositoryImpl implements PostRepository {

    private final ElasticsearchOperations elasticsearchOperations;

    public PostRepositoryImpl(ElasticsearchOperations elasticsearchOperations) {
        this.elasticsearchOperations = elasticsearchOperations;
    }

    public List<Post> searchPost(String keyword, GeoJsonPoint location) {
        int DISTANCE = 5;
        QueryStringQueryBuilder stringQuery = QueryBuilders.queryStringQuery(keyword);

        GeoDistanceQueryBuilder geoQuery = QueryBuilders.geoDistanceQuery("location")
                .point(location.getX(), location.getY()).distance(DISTANCE, DistanceUnit.KILOMETERS);

        Query query = new NativeSearchQueryBuilder()
                .withQuery(stringQuery)
                .withQuery(geoQuery)
                .build();

        SearchHits<Post> searchHits = elasticsearchOperations
                .search(query, Post.class);

        List<Post> posts = new ArrayList<>();

        searchHits.forEach(item -> posts.add(item.getContent()));
        return posts;
    }
}
