package com.bluepa.backend.post.repository;

import com.bluepa.backend.post.domain.Post;
import com.bluepa.backend.post.dto.FilterRequest;
import com.bluepa.backend.post.dto.SearchRequest;
import com.bluepa.backend.post.util.DateRange;
import com.bluepa.backend.post.util.PriceRange;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.elasticsearch.common.unit.DistanceUnit;
import org.elasticsearch.index.query.GeoDistanceQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.geo.GeoJsonPoint;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PostRepositoryImpl implements PostRepository {

    private final ElasticsearchOperations elasticsearchOperations;

    public List<Post> searchPost(SearchRequest searchRequest, FilterRequest filterRequest) {
        final int DISTANCE = 5;

        String keyword = searchRequest.getKeyword();
        GeoJsonPoint location = searchRequest.getLocation();
        String cityName = searchRequest.getCityName();
        String route = String.format("post-%s", cityName);

        DateRange dateRange = filterRequest.getDateRange();
        PriceRange priceRange = filterRequest.getPriceRange();

        QueryStringQueryBuilder stringQuery = QueryBuilders.queryStringQuery(keyword);

        GeoDistanceQueryBuilder geoQuery = QueryBuilders.geoDistanceQuery("location")
                .point(location.getX(), location.getY()).distance(DISTANCE, DistanceUnit.KILOMETERS);

        QueryBuilder dateFilters = QueryBuilders
                .rangeQuery("createdDate")
                .from(dateRange.getStartDate())
                .to(dateRange.getEndDate());

        QueryBuilder priceFilters = QueryBuilders
                .rangeQuery("price")
                .from(priceRange.getStartPrice())
                .to(priceRange.getEndPrice());

        Query query = new NativeSearchQueryBuilder()
                .withQuery(stringQuery)
                .withQuery(geoQuery)
                .withFilter(dateFilters)
                .withFilter(priceFilters)
                .withRoute(route)
                .build();

        SearchHits<Post> searchHits = elasticsearchOperations
                .search(query, Post.class);

        return searchHits.stream().map(SearchHit::getContent).collect(Collectors.toList());
    }
}
