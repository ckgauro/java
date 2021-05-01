package com.gauro.demo.domain;

import lombok.*;

/**
 * @author Chandra
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    @NonNull
    private String productId;

    @NonNull
    private ProductInfo productInfo;
    @NonNull
    private Review review;
}
