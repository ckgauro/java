package com.gauro.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Chandra
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Inventory {
    private int count;
}
