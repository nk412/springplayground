package com.arjun.spring.cache;

/**
 * Created with IntelliJ IDEA.
 * User: arjun
 * Date: 25/11/13
 * Time: 00:15
 * To change this template use File | Settings | File Templates.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;


public class MathFunction {

    private static final Logger logger = LoggerFactory.getLogger(MathFunction.class);
    private int n;

    MathFunction(){
        n=1;
    }

    //checks whether an int is prime or not.
    boolean isPrime(int n) {
        for(int i=2;i<n;i++) {
            if(n%i==0)
                return false;
        }
        return true;
    }

    @CacheEvict(value = "func", allEntries = true)
    public void setN(int newn) {

        logger.info("Setting n to "+newn);
        n=newn;
    }


    @Cacheable("func")
    public Integer calculateF(int x, final MathFunction callback) {

        /*
        Taken from GPC2012, Problem I (last)
        Recursive solution is extremely computationally intensive for n>40.
        http://www.mayank-j.com/domains/myTermino.com/data/gpc/Past%20Questions/Problems-Set-GPC-2012.pdf

        if (x>1) and prime  : f(x) = f(x-1)+f(x-2)+7
        if (x>1) and !prime : f(x) = f(x-1)-f(x-2)+4
        if (x<0)            : f(x+1)+f(x+2)-4
        f(0)=12, f(1)=6
        */

        logger.debug("Method called to calculateF(x) ["+x+"]");

        if (x==0)
            return 12;
        if (x==1)
            return 6;

        if (x<0)
            return callback.calculateF(x+1,callback)+callback.calculateF(x+2,callback)-n;
        if (x>1 && isPrime(x))
            return callback.calculateF(x-1,callback)+callback.calculateF(x-2,callback)+7;
        else
            return callback.calculateF(x-1,callback)-callback.calculateF(x-2,callback)+n;
    }
}