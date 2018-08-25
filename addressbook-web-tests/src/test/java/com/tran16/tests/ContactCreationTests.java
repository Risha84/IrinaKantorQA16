package com.tran16.tests;

import com.tran16.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ContactCreationTests extends TestBase {
    @Test
    public void testContactCreation() throws InterruptedException {
       app.getContactHelper().isOnContactPage();
        List<ContactData> before = app.getContactHelper().getContactsList();
              app.getContactHelper().initContactCreation();

        app.getContactHelper().fillContactForm(new ContactData()
                .withFirstname("Irisha")
                .withLastname("Cat")
                .withAddress("Ukraina")
                .withNickname("Risha")
                .withCompany("Tel-Ran")
                .withEmail("Irishechka@gmail.com"));
        app.getContactHelper().submitContactCreation();
        List<ContactData> after = app.getContactHelper().getContactsList();
        Assert.assertEquals(after.size(),before.size()+1);
        app.getContactHelper().returnToTheHomePage();

    }

}
