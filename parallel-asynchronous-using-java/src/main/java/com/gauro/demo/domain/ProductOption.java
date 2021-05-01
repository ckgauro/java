package com.gauro.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Chandra
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductOption {
    private Integer productionOptionId;
    private String size;
    private String color;
    private double price;
    private Inventory inventory;

    public ProductOption(Integer productionOptionId, String size, String color, double price) {
        this.productionOptionId = productionOptionId;
        this.size = size;
        this.color = color;
        this.price = price;
    }
}