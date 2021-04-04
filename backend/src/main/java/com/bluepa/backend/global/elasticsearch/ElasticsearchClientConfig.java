package com.bluepa.backend.global.elasticsearch;

import lombok.RequiredArgsConstructor;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;

@Configuration
@RequiredArgsConstructor
public class ElasticsearchClientConfig extends AbstractElasticsearchConfiguration {

    private final ElasticsearchProperties properties;

    @Override
    @Bean
    public RestHighLevelClient elasticsearchClient() {

        String host = properties.getHost();

        final ClientConfiguration clientConfiguration = ClientConfiguration.builder()
            .connectedTo(host)
            .build();

        return RestClients.create(clientConfiguration).rest();
    }
}
