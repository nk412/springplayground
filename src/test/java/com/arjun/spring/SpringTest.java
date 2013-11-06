package com.arjun.spring;


import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
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
    public void testSetter()
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        MessageHandler alpha_obj = (MessageHandler) context.getBean("helloWorld");

        alpha_obj.setMessage("some random message");
        assertTrue( alpha_obj.getMessage().equals("some random message") );
    }

    public void testK(){
        assertTrue(true);
    }
}

