package com.tran16.tests;

import com.tran16.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactModificationTest extends TestBase {
    @Test
    public void testContactModification() throws InterruptedException {
        if(!app.getContactHelper().isContactPresent()){
            app.getContactHelper().createContact();
                    }
        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().selectContact();
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactData()
                .withFirstname("Alex")
                .withLastname("Popov")
                .withAddress("Israel")
                .withEmail("Voronovich@gmail.com")
                .withCompany("Ideal")
                .withNickname("Sashynchik"));
        app.getContactHelper().confirmTheChangeInContact();
        app.getContactHelper().returnToTheHomePage();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before);

    }

}
