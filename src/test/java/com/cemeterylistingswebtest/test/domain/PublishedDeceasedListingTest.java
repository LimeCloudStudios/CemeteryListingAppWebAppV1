/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cemeterylistingswebtest.test.domain;

import com.cemeterylistingsweb.domain.PublishedDeceasedListing;
import com.cemeterylistingsweb.repository.PublishedDeceasedListingRepository;
import com.cemeterylistingswebtest.test.ConnectionConfigTest;
import junit.framework.Assert;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author ME
 */
public class PublishedDeceasedListingTest {
    
    public PublishedDeceasedListingTest() {
    }
    
    private static Long id;
    public static ApplicationContext ctx;
    public static PublishedDeceasedListingRepository repo;

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void create() {
         System.out.println("here");
         repo = ctx.getBean(PublishedDeceasedListingRepository.class);
         /*
            String firstName;
            String surname;
            String maidenName;
            String gender;
            String dateOfBirth;
            String dateOfDeath;
            String graveInscription;
            String graveNumber;
            String imageOfBurialSite; // will need to be done in binary or saved in a online directory 
            String lastKnownContactName;
            String lastKnownContactNumber;
            Long cemeteryID;
            //can't have a member approved, since it requires approval, and once it has been approved the data is moved over to the main table
            Long memberSubmitID;
            @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
            @JoinColumn(name="Other_names")
            List<PersonOtherNames> names;
         */
         PublishedDeceasedListing newListing = new PublishedDeceasedListing.Builder()
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
                 //memberApprovedID
                 //member submitted id
                 //names
                 
                 .build();
         
         repo.save(newListing);
         id = newListing.getPublishedListingID();
     }
     
     @Test(dependsOnMethods="create")
     public void read(){
         repo = ctx.getBean(PublishedDeceasedListingRepository.class);
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
         repo = ctx.getBean(PublishedDeceasedListingRepository.class);
         PublishedDeceasedListing oldListing = repo.findOne(id);
         
         PublishedDeceasedListing updateListing = new PublishedDeceasedListing.Builder()
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
         repo.delete(oldListing.getPublishedListingID());
         
         id = updateListing.getPublishedListingID();
         
     }
     @Test(dependsOnMethods="update")
     public void readUpdated(){
         repo = ctx.getBean(PublishedDeceasedListingRepository.class);
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
         repo = ctx.getBean(PublishedDeceasedListingRepository.class);
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
