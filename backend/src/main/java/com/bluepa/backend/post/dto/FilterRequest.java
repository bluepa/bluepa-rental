package com.bluepa.backend.post.dto;

import com.bluepa.backend.post.util.DateRange;
import com.bluepa.backend.post.util.PriceRange;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FilterRequest {

    DateRange dateRange;
    PriceRange priceRange;
}
