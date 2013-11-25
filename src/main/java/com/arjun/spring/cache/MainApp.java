package com.arjun.spring.cache;

/**
 * Created with IntelliJ IDEA.
 * User: arjun
 * Date: 25/11/13
 * Time: 00:16
 * To change this template use File | Settings | File Templates.
 */

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String... args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext(
                "CacheBeans.xml");
        Product product = (Product) context.getBean("product");

        // calling getProduct method first time.
        System.out.println(product.getProduct(1));

        // calling getProduct method second time. This time, method will not
        // execute.
        System.out.println(product.getProduct(1));

        // calling setProduct method to evict the cache value
        product.setProduct(1);

        // calling getProduct method third time. This time, method will execute
        // again.
        System.out.println(product.getProduct(1));
    }
}