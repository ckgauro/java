package com.gauro.demo.service;

import com.gauro.demo.domain.Inventory;
import com.gauro.demo.domain.ProductOption;

import java.util.concurrent.CompletableFuture;

import static com.gauro.demo.util.CommonUtil.delay;

/**
 * @author Chandra
 */
public class InventoryService {
    public Inventory addInventroy(ProductOption productOption){
        delay(500);
        return Inventory.builder().count(2).build();
    }
    public CompletableFuture<Inventory> addInventory_CF(ProductOption productOption){
        return CompletableFuture.supplyAsync(()->{
            delay(500);
            return Inventory.builder().count(2).build();
        });
    }
    public Inventory retrieveInventory(ProductOption productOption) {
        delay(500);
        return Inventory.builder()
                .count(2).build();

    }

}
