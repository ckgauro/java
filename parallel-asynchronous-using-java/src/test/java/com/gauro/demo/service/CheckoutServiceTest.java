package com.gauro.demo.service;

import com.gauro.demo.domain.checkout.Cart;
import com.gauro.demo.domain.checkout.CheckoutResponse;
import com.gauro.demo.domain.checkout.CheckoutStatus;
import com.gauro.demo.util.DataSet;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ForkJoinPool;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Chandra
 */
class CheckoutServiceTest {
    PriceValidatorService priceValidatorService=new PriceValidatorService();
    CheckoutService checkoutService=new CheckoutService(priceValidatorService);

    @Test
    void parallelism(){
        //parallelism=no of cores -1
        System.out.println("Parallelism: "+ ForkJoinPool.getCommonPoolParallelism());
    }

    @Test
    void no_of_cores(){
        //Display no of cores
        System.out.println("no of cores:"+Runtime.getRuntime().availableProcessors());
    }

    //This is For success
    @Test
    void checkout_3_items(){
        //given
        //-Djava.util.concurrent.ForkJoinPool.common.parallelism=100
        //  System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "100");

        Cart cart= DataSet.createCart(3);
        System.out.println("Size of the cart :"+cart.getCartItemList().size());

        //when
        CheckoutResponse checkoutResponse=checkoutService.checkout(cart);

        //then
        assertEquals(CheckoutStatus.SUCCESS,checkoutResponse.getCheckoutStatus());

    }
    @Test
    void checkout_6_items(){
        //given
        //-Djava.util.concurrent.ForkJoinPool.common.parallelism=100
        //  System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "100");

        Cart cart= DataSet.createCart(6);
        System.out.println("Size of the cart :"+cart.getCartItemList().size());

        //when
        CheckoutResponse checkoutResponse=checkoutService.checkout(cart);

        //then
        assertEquals(CheckoutStatus.SUCCESS,checkoutResponse.getCheckoutStatus());

    }
    @Test
    void checkout_12_items(){
        //given
        // -Djava.util.concurrent.ForkJoinPool.common.parallelism=100
        // System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism","100");
        Cart cart=DataSet.createCart(12);

        System.out.println("Size of the cart :"+cart.getCartItemList().size());

        //when
        CheckoutResponse checkoutResponse=checkoutService.checkout(cart);

        //then
        assertEquals(CheckoutStatus.FAILURE, checkoutResponse.getCheckoutStatus());
    }

    @Test
    void checkout_modify_parallelism() {
        //given
        // -Djava.util.concurrent.ForkJoinPool.common.parallelism=100
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism","100");
        //when
        Cart cart=DataSet.createCart(105);
        CheckoutResponse checkoutResponse=checkoutService.checkout(cart);

        //then
        assertEquals(CheckoutStatus.FAILURE, checkoutResponse.getCheckoutStatus());

    }

    @Test
    void checkout_25_items(){
        //given

        Cart cart=DataSet.createCart(105);

        //when
        CheckoutResponse checkoutResponse=checkoutService.checkout(cart);
        //then
        assertEquals(CheckoutStatus.FAILURE, checkoutResponse.getCheckoutStatus());
    }



}