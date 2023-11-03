package com.snqg.point.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductSearchCriteria {
    private Boolean discounted;
    private String productName;
    private String category;
}
