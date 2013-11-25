package com.arjun.spring;


import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class SpringTest
        extends TestCase
{

    public SpringTest( String testName )
    {
        super( testName );
    }

    public static Test suite()
    {
        return new TestSuite( SpringTest.class );
    }


    // Tests
    public void testSetterGetter()
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        MessageHandler alpha_obj = (MessageHandler) context.getBean("helloWorld");

        alpha_obj.setMessage("some random message");
        assertTrue( alpha_obj.getMessage().equals("some random message") );
    }

    public void testConstructor()
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        MessageHandler alpha_obj = (MessageHandler) context.getBean("helloWorld_con");

        assertTrue( alpha_obj.getMessage().equals("I am the constructor message") );
    }

    public void testSetter()
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        MessageHandler alpha_obj = (MessageHandler) context.getBean("helloWorld_set");

        assertTrue( alpha_obj.getMessage().equals("I override the constructor message") );
    }


    public void testPrototype()
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        MessageHandler alpha_obj = (MessageHandler) context.getBean("helloWorld_prototype");
        alpha_obj.setMessage("some random message");

        MessageHandler beta_obj = (MessageHandler) context.getBean("helloWorld_prototype");
        beta_obj.setMessage("I am another message");

        assertTrue( beta_obj.getMessage().equals("I am another message"));
        assertTrue( alpha_obj.getMessage().equals("some random message") );
    }

    public void testSingleton()
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        MessageHandler alpha_obj = (MessageHandler) context.getBean("helloWorld_singleton");
        alpha_obj.setMessage("some random message");

        MessageHandler beta_obj = (MessageHandler) context.getBean("helloWorld_singleton");
        beta_obj.setMessage("I am another message");

        assertTrue( beta_obj.getMessage().equals("I am another message"));
        assertTrue( alpha_obj.getMessage().equals("I am another message") );
    }
}

