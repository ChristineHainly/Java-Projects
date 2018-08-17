/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplelogin;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Christine
 */
public class SimpleLoginTest {
    
    @Before
    public void setUp() {
        System.out.println("*********************************************");
        System.out.println("* SimpleLoginTest: setUp() method");
    }
    
    @After
    public void tearDown() {
        System.out.println("* SimpleLoginTest: tearDown() method");
    }

    /**
     * Tests that SimpleLogin is writing to log.txt
     */
    @Test
    public void testWriteNewEntry() throws FileNotFoundException, IOException {
        System.out.println("* TEST 1:");
        System.out.println("* SimpleLoginTest: testWriteNewEntry() method");
        String x = "Pass/Fail";
        String username = "username1";
        SimpleLogin instance = new SimpleLogin();
        instance.writeNewEntry(x, username);
    }
    
    /**
     * Test of main method, of class SimpleLogin.
     */
    @Test
    public void testMain() {
        System.out.println("* TEST 2:");
        System.out.println("* SimpleLoginTest: testMain() method");
        String[] args = null;
        SimpleLogin.main(args);
    }
    
    /**
     * Test of initialize method, of class SimpleLogin.
     */
    @Test
    public void testInitialize() {
        System.out.println("* TEST 3:");
        System.out.println("* SimpleLoginTest: testInitialize() method");
        SimpleLogin instance = new SimpleLogin();
        instance.initialize();
    }
    
    /**
     * Tests that SimpleLogin authenticates correctly
     */
    @Test
    public void testAuthenticate() throws AWTException {
        System.out.println("* TEST 4:");
        System.out.println("* SimpleLoginTest: testAuthenticate() method");
        
        String username = "TestUser";
        String password = "TestPassword";
        
        SimpleLogin instance = new SimpleLogin();
        instance.Authenticate(username, password);
    }    
    
}
