/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cemeterylistingswebtest.test.domain;

import com.cemeterylistingsweb.repository.TestRepository;
import com.cemeterylistingswebtest.test.ConnectionConfigTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author ME
 */
public class metest {
    
    public metest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    //
    
    private static Long id;
    public static ApplicationContext ctx;
    public static TestRepository repo;
    
    
   @Test
     public void hello() {
         System.out.println("here");
         repo = ctx.getBean(TestRepository.class);
         
     }

    @BeforeClass
    public static void setUpClass() throws Exception {
         ctx = new AnnotationConfigApplicationContext(ConnectionConfigTest.class);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}