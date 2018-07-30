package com.tran16;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactModificationTest extends TestBase {
    @Test
    public void testContactModification(){
        if(!app.isContactPresent()){
            app.createContact();
                    }
        int before = app.getContactCount();
        app.selectContact();
        app.initContactModification();
        app.fillContactForm(new ContactData()
                .withFirstname("Alex")
                .withLastname("Popov")
                .withAddress("Israel")
                .withEmail("Voronovich@gmail.com")
                .withCompany("Ideal")
                .withNickname("Sashynchik"));
        app.confirmTheChangeInContact();
        app.returnToTheHomePage();
        int after = app.getContactCount();
        Assert.assertEquals(after, before);

    }

}
