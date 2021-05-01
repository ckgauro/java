package com.gauro.demo.service;

import com.gauro.demo.domain.checkout.CartItem;

import static com.gauro.demo.util.CommonUtil.delay;

/**
 * @author Chandra
 */
public class PriceValidatorService {
    public boolean isCartItemInvalid(CartItem cartItem){
        int cardId=cartItem.getItemId();
        delay(500);
        if(cardId==7 || cardId==9 || cardId==11){
            return true;
        }
        return false;
    }
}
