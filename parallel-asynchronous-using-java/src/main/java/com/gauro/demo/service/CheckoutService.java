package com.gauro.demo.service;

import com.gauro.demo.domain.checkout.Cart;
import com.gauro.demo.domain.checkout.CartItem;
import com.gauro.demo.domain.checkout.CheckoutResponse;
import com.gauro.demo.domain.checkout.CheckoutStatus;

import java.util.List;
import java.util.stream.Collectors;

import static com.gauro.demo.util.CommonUtil.*;
import static com.gauro.demo.util.LoggerUtil.log;
import static java.util.stream.Collectors.summingDouble;

/**
 * @author Chandra
 */
public class CheckoutService {
    private PriceValidatorService priceValidatorService;

    public CheckoutService(PriceValidatorService priceValidatorService) {
        this.priceValidatorService = priceValidatorService;
    }

    public CheckoutResponse checkout(Cart cart) {
        startTimer();
        List<CartItem> priceValidationList = cart.getCartItemList()
                .parallelStream()
                .map(cartItem -> {
                    cartItem.setExpired(priceValidatorService.isCartItemInvalid(cartItem));
                    return cartItem;
                }).filter(CartItem::isExpired).collect(Collectors.toList());
        timeTaken();
        stopWatchReset();
        if (priceValidationList.size() > 0) {
            log("Checkout Error");
            return new CheckoutResponse(CheckoutStatus.FAILURE, priceValidationList);
        }

        //double finalRate=calculateFinalPrice(cart);
        double finalRate = calculateFinalPrice_reduce(cart);
        log("Checkout Complete and the final rate is " + finalRate);

        return new CheckoutResponse(CheckoutStatus.SUCCESS,finalRate);

    }
    private double calcuateFinalPrice(Cart cart){
        return cart.getCartItemList()
                .parallelStream()
                .map(cartItem -> cartItem.getQuantity()*cartItem.getRate())
                .collect(summingDouble(Double::doubleValue));
        //.mapToDouble(Double::doubleValue)
        //.sum();
         }

    private double calculateFinalPrice_reduce(Cart cart) {
        return cart.getCartItemList()
                .parallelStream()
                .map(cartItem -> cartItem.getQuantity() * cartItem.getRate())
                .reduce(0.0, Double::sum);
    }


}

