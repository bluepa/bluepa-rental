package com.bluepa.backend.post.dto;

import lombok.Getter;
import org.springframework.data.elasticsearch.core.geo.GeoJsonPoint;

@Getter
public class SearchRequest {

    String keyword;
    GeoJsonPoint location;
}
