/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mstar.testng;

import org.testng.annotations.*;

/**
 *
 * @author asun
 */
public class testngExample1 {
    
    @BeforeClass
    public void setUp(){
        System.out.println("Before start the test case!");
    }
    
    @Test(groups = {"first"})
    public void firstMethod(){
        System.out.println("Running the first method!");
    }
    
    @Test(groups = {"second"})
    public void secondMethod(){
        System.out.println("Running the second method!");
    }
    
    public static void main(String[] args) {
        new testngExample1();
    }
}
