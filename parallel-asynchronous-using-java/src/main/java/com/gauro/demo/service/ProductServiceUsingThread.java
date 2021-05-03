package com.gauro.demo.service;

import com.gauro.demo.domain.Product;
import com.gauro.demo.domain.ProductInfo;
import com.gauro.demo.domain.Review;
import lombok.Data;

import static com.gauro.demo.util.CommonUtil.stopWatch;
import static com.gauro.demo.util.LoggerUtil.log;

/**
 * @author Chandra
 */
public class ProductServiceUsingThread {
    private final ProductInfoService productInfoService;
    private final ReviewService reviewService;

    public ProductServiceUsingThread(ProductInfoService productInfoService, ReviewService reviewService) {
        this.productInfoService = productInfoService;
        this.reviewService = reviewService;
    }
    public Product retrieveProductDetails(String productId) throws InterruptedException {
        stopWatch.start();
        ProductInfoRunnable productInfoRunnable=new ProductInfoRunnable(productId);
        ReviewRunnable reviewRunnable=new ReviewRunnable(productId);

        Thread productInfoThread=new Thread(productInfoRunnable);
        Thread reviewThread=new Thread(reviewRunnable);

        productInfoThread.start();
        reviewThread.start();

        productInfoThread.join();
        reviewThread.join();


        ProductInfo productInfo=productInfoRunnable.getProductInfo();  //blocking call
        Review review=reviewRunnable.getReview(); // blocking call;

        stopWatch.stop();
        log("Total Time Taken:"+stopWatch.getTime());
        return new Product(productId,productInfo,review);
    }

    public static void main(String[] args) throws InterruptedException {
        ProductInfoService productInfoService=new ProductInfoService();
        ReviewService reviewService=new ReviewService();
        ProductServiceUsingThread productService=new ProductServiceUsingThread(productInfoService,reviewService);
        String productId="ABC123";
        Product product=productService.retrieveProductDetails(productId);
        log("Product is "+product);
    }
    private class ProductInfoRunnable implements Runnable{
        private String productId;
        private ProductInfo productInfo;

        public ProductInfoRunnable(String productId) {
            this.productId=productId;
        }

        public ProductInfo getProductInfo() {
            return productInfo;
        }
        @Override
        public void run() {
            productInfo=productInfoService.retrieveProductInfo(productId);
        }
    }


    private class ReviewRunnable implements Runnable {
        private String productId;
        private Review review;
        public ReviewRunnable(String productId) {
            this.productId=productId;
        }

        public Review getReview() {
            return review;
        }

        @Override
        public void run() {
            review=reviewService.retrieveReviews(productId);
        }
    }
}

