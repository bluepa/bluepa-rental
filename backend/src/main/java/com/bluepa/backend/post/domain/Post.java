package com.bluepa.backend.post.domain;

import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.core.geo.GeoJsonPoint;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "post")
public class Post {
    
    @Id
    private String id;
    @CreatedDate
    @Field(type = FieldType.Date, format = DateFormat.basic_date)
    private Instant createdDate;
    private GeoJsonPoint location;
    @Field(type = FieldType.Text, store = true)
    private String title;
    @Field(type = FieldType.Keyword, store = true)
    private String author;
    @Field(type = FieldType.Text, store = true)
    private String content;
}
