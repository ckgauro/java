package com.gauro.demo.domain;

import lombok.*;

import java.util.List;

/**
 * @author Chandra
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ProductInfo {
    private String productId;
    private List<ProductOption> productOptions;
}
