package com.arjun.spring.cache;

/**
 * Created with IntelliJ IDEA.
 * User: arjun
 * Date: 25/11/13
 * Time: 00:15
 * To change this template use File | Settings | File Templates.
 */

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

public class Product {
    @CacheEvict(value = "prod", allEntries = true)
    public void setProduct(int productId) {
        System.out.println("execute setProduct method..");
    }

    @Cacheable("prod")
    public String getProduct(int productId) {
        System.out.println("execute getProduct method..");
        if (productId == 1) {
            return "Product A";
        } else {
            return "Product B";
        }
    }
}