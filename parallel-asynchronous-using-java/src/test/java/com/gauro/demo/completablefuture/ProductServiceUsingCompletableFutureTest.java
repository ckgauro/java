package com.gauro.demo.completablefuture;

import com.gauro.demo.domain.Product;
import com.gauro.demo.service.InventoryService;
import com.gauro.demo.service.ProductInfoService;
import com.gauro.demo.service.ReviewService;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;

import static com.gauro.demo.util.CommonUtil.startTimer;
import static com.gauro.demo.util.CommonUtil.timeTaken;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Chandra
 */
class ProductServiceUsingCompletableFutureTest {
    ProductInfoService pis=new ProductInfoService();
    ReviewService rs=new ReviewService();
    InventoryService is=new InventoryService();
    ProductServiceUsingCompletableFuture pscf=new ProductServiceUsingCompletableFuture(pis,rs,is);

    @Test
    void retrieveProductDetails() {
        //given
        String productId = "ABC123";
      //  startTimer();

        //when
        Product product=pscf.retrieveProductDetails(productId);
        System.out.println("Product:"+ product);

        //then
        assertNotNull(product);
        assertTrue(product.getProductInfo().getProductOptions().size()>0);
        assertNotNull(product.getReview());
       // timeTaken();
    }

    @Test
    void retrieveProductDetails_CF() {
        //given
        String productId = "ABC123";

        //when
        CompletableFuture<Product> cfProduct=pscf.retrieveProductDetails_CF(productId);

        //then
        cfProduct.thenAccept(product -> {
           assertNotNull(product);
           assertTrue(product.getProductInfo().getProductOptions().size()>0);
           assertNotNull(product.getReview());
        }).join();
    }
    @Test
    void retrieveProductDetailsWithInventory() {
        //given
        String  productId = "ABC123";

        Product product=pscf.retrieveProductDetailsWithInventory(productId);
        System.out.println("product: "+product);

        //then
        assertNotNull(product);
        assertTrue(product.getProductInfo().getProductOptions().size() > 0);
        product.getProductInfo().getProductOptions().forEach(productOption -> {
            assertNotNull(productOption.getInventory());
        });
        assertNotNull(product.getReview());
    }
    @Test
    void retrieveProductDetailsWithInventory_approach2() {
        //given
        String productId = "ABC123";
        //when
        Product product = pscf.retrieveProductDetailsWithInventory_approach2(productId);
        System.out.println("product:  " + product);

        //then
        assertNotNull(product);
        assertTrue(product.getProductInfo().getProductOptions().size() > 0);
        product.getProductInfo().getProductOptions().forEach(productOption -> {
            assertNotNull(productOption.getInventory());
        });


        assertNotNull(product.getReview());
    }




}