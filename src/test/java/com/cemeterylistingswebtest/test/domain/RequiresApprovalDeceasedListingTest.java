/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cemeterylistingswebtest.test.domain;

import com.cemeterylistingsweb.domain.RequiresApprovalDeceasedListing;
import com.cemeterylistingsweb.repository.RequiresApprovalDeceasedListingRepository;
import com.cemeterylistingswebtest.test.ConnectionConfigTest;
import static com.cemeterylistingswebtest.test.domain.PersonOtherNamesTest.ctx;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
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
public class RequiresApprovalDeceasedListingTest {
    
    public RequiresApprovalDeceasedListingTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    private static Long id;
    public static ApplicationContext ctx;
    public static RequiresApprovalDeceasedListingRepository repo;
    
     @Test
     public void create() {
          System.out.println("here");
         repo = ctx.getBean(RequiresApprovalDeceasedListingRepository.class);
         
         RequiresApprovalDeceasedListing newListing = new RequiresApprovalDeceasedListing.Builder()
                 .setFirstName("Hendrika")
                 .setSurname("Fourie")
                 .setMaidenName("Gerber")
                 .setGender("Female")
                 .setDateOfBirth("08/06/1969")
                 .setDateOfDeath("14/02/2005")
                 .setGraveInscription("Hippiest person eva")
                 .setGraveNumber("2456")
                 .setImageOfBurialSite("/images/001.jpg")
                 .setLastKnownContactName("Berry")
                 .setLastKnownContactNumber("0725576482")
                 //cemetery id
                 //member submitted id
                 //names
                 
                 .build();
         
         repo.save(newListing);
         id = newListing.getRequiresApprovalDeceasedListingID();
     }
     
     @Test(dependsOnMethods="create")
     public void read(){
         repo = ctx.getBean(RequiresApprovalDeceasedListingRepository.class);
         Assert.assertEquals(repo.findOne(id).getFirstName(), "Hendrika");
         Assert.assertEquals(repo.findOne(id).getSurname()  , "Fourie" );
         Assert.assertEquals(repo.findOne(id).getMaidenName()  , "Gerber" );
         Assert.assertEquals(repo.findOne(id).getGender()  , "Female" );
         Assert.assertEquals(repo.findOne(id).getDateOfBirth()  , "08/06/1969" );
         Assert.assertEquals(repo.findOne(id).getDateOfDeath()  , "14/02/2005" );
         Assert.assertEquals(repo.findOne(id).getGraveInscription()  , "Hippiest person eva" );
         Assert.assertEquals(repo.findOne(id).getGraveNumber()  , "2456" );
         Assert.assertEquals(repo.findOne(id).getImageOfBurialSite()  , "/images/001.jpg" );
         Assert.assertEquals(repo.findOne(id).getLastKnownContactName()  ,"Berry"  );
         Assert.assertEquals(repo.findOne(id).getLastKnownContactNumber()  , "0725576482" );
     }
     
     @Test(dependsOnMethods="read")
     public void update(){
         repo = ctx.getBean(RequiresApprovalDeceasedListingRepository.class);
         
         RequiresApprovalDeceasedListing oldListing = repo.findOne(id);
         
         RequiresApprovalDeceasedListing updateListing = new RequiresApprovalDeceasedListing.Builder()
                 .setFirstName(oldListing.getFirstName())
                 .setSurname("Smith")
                 .setMaidenName(oldListing.getMaidenName())
                 .setGender(oldListing.getGender())
                 .setDateOfBirth(oldListing.getDateOfBirth())
                 .setDateOfDeath(oldListing.getDateOfDeath())
                 .setGraveInscription(oldListing.getGraveInscription())
                 .setGraveNumber(oldListing.getGraveNumber())
                 .setImageOfBurialSite(oldListing.getImageOfBurialSite())
                 .setLastKnownContactName(oldListing.getLastKnownContactName())
                 .setLastKnownContactNumber(oldListing.getLastKnownContactNumber())
                 .build();
         
         repo.save(updateListing);
         repo.delete(repo.findOne(id));
         
         id = updateListing.getRequiresApprovalDeceasedListingID();
     }
     @Test(dependsOnMethods="update")
     public void readUpdated(){
         repo = ctx.getBean(RequiresApprovalDeceasedListingRepository.class);
         Assert.assertEquals(repo.findOne(id).getFirstName(), "Hendrika");
         Assert.assertEquals(repo.findOne(id).getSurname()  , "Smith" );
         Assert.assertEquals(repo.findOne(id).getMaidenName()  , "Gerber" );
         Assert.assertEquals(repo.findOne(id).getGender()  , "Female" );
         Assert.assertEquals(repo.findOne(id).getDateOfBirth()  , "08/06/1969" );
         Assert.assertEquals(repo.findOne(id).getDateOfDeath()  , "14/02/2005" );
         Assert.assertEquals(repo.findOne(id).getGraveInscription()  , "Hippiest person eva" );
         Assert.assertEquals(repo.findOne(id).getGraveNumber()  , "2456" );
         Assert.assertEquals(repo.findOne(id).getImageOfBurialSite()  , "/images/001.jpg" );
         Assert.assertEquals(repo.findOne(id).getLastKnownContactName()  ,"Berry"  );
         Assert.assertEquals(repo.findOne(id).getLastKnownContactNumber()  , "0725576482" );
     }
     @Test(dependsOnMethods="readUpdated")
     public void delete(){
         repo = ctx.getBean(RequiresApprovalDeceasedListingRepository.class);
         repo.delete(repo.findOne(id));
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
