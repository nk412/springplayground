package com.arjun.spring.cache;

/**
 * Created with IntelliJ IDEA.
 * User: arjun
 * Date: 25/11/13
 * Time: 00:16
 * To change this template use File | Settings | File Templates.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    private static final Logger logger = LoggerFactory.getLogger(MathFunction.class);

    public static void main(String... args) {

        logger.debug("Started");

        int value=42;

        AbstractApplicationContext context = new ClassPathXmlApplicationContext(
                "CacheBeans.xml");

        MathFunction f1 = (MathFunction) context.getBean("function_bean");

        // N <- 1. F(42)=-36
        f1.setN(1);

        long start_time=System.nanoTime();
        System.out.println("F("+value+") = "+f1.calculateF(value,f1));
        double time_taken=(System.nanoTime()-start_time)/1000000;
        System.out.println("Time taken: "+time_taken+" ms");

        start_time=System.nanoTime();
        System.out.println("F("+value+") = "+f1.calculateF(value,f1));
        time_taken=(System.nanoTime()-start_time)/1000000;
        System.out.println("Time taken: "+time_taken+" ms");

        // N <- 2. F(42)=-34
        f1.setN(2);
        start_time=System.nanoTime();
        System.out.println("F("+value+") = "+f1.calculateF(value,f1));
        time_taken=(System.nanoTime()-start_time)/1000000;
        System.out.println("Time taken: "+time_taken+" ms");

        start_time=System.nanoTime();
        for (int y=0;y<300;y++){
            System.out.println(y+":"+f1.calculateF(y,f1));
        }
        time_taken=(System.nanoTime()-start_time)/1000000;
        System.out.println("Time taken: "+time_taken+" ms");

    }
}