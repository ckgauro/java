package com.gauro.demo.service;

import com.gauro.demo.domain.Review;

import static com.gauro.demo.util.CommonUtil.delay;

/**
 * @author Chandra
 */
public class ReviewService {
    public Review retrieveReviews(String productId){
        delay(1000);
        return new Review(200,4.5);
    }
}
