package com.tran16;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactModificationTest extends TestBase {
    @Test
    public void testContactModification(){
        if(!isContactPresent()){
            createContact();
                    }
        int before = getContactCount();
        selectContact();
        initContactModification();
        fillContactForm(new ContactData()
                .withFirstname("Alex")
                .withLastname("Popov")
                .withAddress("Israel")
                .withEmail("Voronovich@gmail.com")
                .withCompany("Ideal")
                .withNickname("Sashynchik"));
        confirmTheChangeInContact();
        returnToTheHomePage();
        int after = getContactCount();
        Assert.assertEquals(after, before);

    }

}
