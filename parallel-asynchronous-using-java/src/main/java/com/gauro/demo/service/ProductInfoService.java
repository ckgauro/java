package com.gauro.demo.service;

import com.gauro.demo.domain.ProductInfo;
import com.gauro.demo.domain.ProductOption;

import java.util.List;

import static com.gauro.demo.util.CommonUtil.delay;

/**
 * @author Chandra
 */
public class ProductInfoService {
    public ProductInfo retrieveProductInfo(String productId){
        delay(1000);
        List<ProductOption> productOptions=List.of(new ProductOption(1, "64GB", "Black", 699.99),
                new ProductOption(2, "128GB", "Black", 749.99),
                new ProductOption(3, "128GB", "Black", 749.99),
                new ProductOption(4, "128GB", "Black", 749.99),
                new ProductOption(5, "128GB", "Black", 749.99));
        return ProductInfo.builder()
                .productOptions(productOptions)
                .productId(productId)
                .build();
    }
}
