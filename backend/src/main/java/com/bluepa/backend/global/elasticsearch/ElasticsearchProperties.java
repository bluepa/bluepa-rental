package com.bluepa.backend.global.elasticsearch;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "spring.elasticsearch")
@Getter
@Setter
public class ElasticsearchProperties {

    private String host;
}
