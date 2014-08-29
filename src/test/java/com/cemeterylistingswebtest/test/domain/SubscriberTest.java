/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cemeterylistingswebtest.test.domain;

import com.cemeterylistingsweb.domain.Subscriber;
import com.cemeterylistingsweb.domain.UserRole;
import com.cemeterylistingsweb.repository.SubscriberRepository;
import com.cemeterylistingsweb.repository.UserRoleRepository;
import com.cemeterylistingswebtest.test.ConnectionConfigTest;
import java.util.Date;
import junit.framework.Assert;
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
 * @author Kurvin Hendricks
 */
public class SubscriberTest {
    
    public SubscriberTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    private static Long id;
    public static ApplicationContext ctx;
    public static SubscriberRepository repo;
    public static UserRoleRepository userRepo;
    
    
    
     @Test
     public void create() {
         System.out.println("here");
         
         repo = ctx.getBean(SubscriberRepository.class);
         userRepo = ctx.getBean(UserRoleRepository.class);
         
         Date date = new Date();
         UserRole user = new UserRole.Builder()
                 .setLevel(1)
                 .build();
         
         userRepo.save(user);
         
            Subscriber newSub = new Subscriber.Builder()
                    .setEmail("manfredOsulivan@horseRaddish.com")
                    .setFirstName("Manfred")
                    .setSurname("Osulivan")
                    .setPwd("jesus")
                    .setUsername("ManiFredOssy")
                    .setUserRoleID(user)
                    .build();
            
         
         repo.save(newSub);
         id = newSub.getMemberID();
     }
     
     @Test(dependsOnMethods="create")
     public void read(){
         repo = ctx.getBean(SubscriberRepository.class);
         
         Assert.assertNotNull(repo.findOne(id).getMemberID());
     }
     
     @Test(dependsOnMethods="read")
     public void update(){
         repo = ctx.getBean(SubscriberRepository.class);
         
         Subscriber oldSub = repo.findOne(id);
         Subscriber update = new Subscriber.Builder()
                 .setEmail(oldSub.getEmail())
                 .setFirstName(oldSub.getFirstName())
                 .setPwd("drowning")
                 .setMemberID(oldSub.getMemberID())
                 .setUserRoleID(oldSub.getUserRoleID())
                 .setUsername(oldSub.getUsername())
                 .build();
         
        //repo.delete(id);
        repo.save(update);
                 
     }
     
     @Test(dependsOnMethods="update")
     public void delete(){
         repo = ctx.getBean(SubscriberRepository.class);
         
         Subscriber oldSub = repo.findOne(id);
         repo.delete(id);
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