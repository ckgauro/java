package com.gauro.demo.executor;

import com.gauro.demo.domain.Product;
import com.gauro.demo.domain.ProductInfo;
import com.gauro.demo.domain.Review;
import com.gauro.demo.service.ProductInfoService;
import com.gauro.demo.service.ReviewService;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static com.gauro.demo.util.CommonUtil.stopWatch;
import static com.gauro.demo.util.LoggerUtil.log;

/**
 * @author Chandra
 */
public class ProductServiceUsingExecutor {
    static ExecutorService executorService= Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    private final ProductInfoService productInfoService;
    private final ReviewService reviewService;

    public ProductServiceUsingExecutor(ProductInfoService productInfoService, ReviewService reviewService) {
        this.productInfoService = productInfoService;
        this.reviewService = reviewService;
    }

    public Product retrieveProductDetails(String productId) throws ExecutionException, InterruptedException {
        stopWatch.start();
        Future<ProductInfo> productInfoFuture=executorService.submit(()->productInfoService.retrieveProductInfo(productId));
        Future<Review> reviewFuture=executorService.submit(()->reviewService.retrieveReviews(productId));
        ProductInfo productInfo=productInfoFuture.get();
        //ProductInfo productInfo = productInfoFuture.get(2, TimeUnit.SECONDS);
        Review review=reviewFuture.get();
        //Review review = reviewFuture.get(2, TimeUnit.SECONDS);

        stopWatch.stop();
        log("Total Time Taken: "+stopWatch.getTime());

        return new Product(productId,productInfo,review);


    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ProductInfoService productInfoService=new ProductInfoService();
        ReviewService reviewService=new ReviewService();
        ProductServiceUsingExecutor productServiceUsingExecutor=new ProductServiceUsingExecutor(productInfoService,reviewService);
        String productId="ABC123";
        Product product=productServiceUsingExecutor.retrieveProductDetails(productId);
        log("Product is"+product);
        executorService.shutdown();

    }
}
