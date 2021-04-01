package com.bluepa.backend.post.dto;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.elasticsearch.core.geo.GeoJsonPoint;

@Getter
@Builder
public class SearchRequest {

    String keyword;
    GeoJsonPoint location;
    String cityName;
}
