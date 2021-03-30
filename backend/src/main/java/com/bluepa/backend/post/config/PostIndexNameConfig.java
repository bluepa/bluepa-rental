package com.bluepa.backend.post.config;

import lombok.Getter;
import lombok.Setter;
import lombok.Synchronized;
import org.springframework.stereotype.Component;

@Component
@Getter(onMethod_ = {@Synchronized})
@Setter(onMethod_ = {@Synchronized})
public class PostIndexNameConfig {

    private String cityName = "";
}
