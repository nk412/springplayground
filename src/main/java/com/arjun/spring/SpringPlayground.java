package com.arjun.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringPlayground {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

        MessageHandler alpha_obj = (MessageHandler) context.getBean("helloWorld");
//        alpha_obj.setMessage("I am the one");
        System.out.println(alpha_obj.getMessage());

        MessageHandler beta_obj = (MessageHandler) context.getBean("helloWorld");
        System.out.println(beta_obj.getMessage());

    }
}

