package com.gauro.demo.service;

import com.gauro.demo.domain.Product;
import com.gauro.demo.domain.ProductInfo;
import com.gauro.demo.domain.Review;

import static com.gauro.demo.util.CommonUtil.stopWatch;
import static com.gauro.demo.util.LoggerUtil.log;

/**
 * @author Chandra
 */
public class ProductService {
    private final ProductInfoService productInfoService;
    private final ReviewService reviewService;

    public ProductService(ProductInfoService productInfoService, ReviewService reviewService) {
        this.productInfoService = productInfoService;
        this.reviewService = reviewService;
    }
    public Product retrieveProductDetails(String productId){
        stopWatch.start();
        ProductInfo productInfo=productInfoService.retrieveProductInfo(productId);  //blocking call
        Review review=reviewService.retrieveReviews(productId); // blocking call;

        stopWatch.stop();
        log("Total Time Taken:"+stopWatch.getTime());
        return new Product(productId,productInfo,review);
    }

    public static void main(String[] args) {
        ProductInfoService productInfoService=new ProductInfoService();
        ReviewService reviewService=new ReviewService();
        ProductService productService=new ProductService(productInfoService,reviewService);
        String productId="ABC123";
        Product product=productService.retrieveProductDetails(productId);
        log("Product is "+product);
    }
}
