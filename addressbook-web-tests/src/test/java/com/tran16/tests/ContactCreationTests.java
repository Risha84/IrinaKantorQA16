package com.tran16.tests;

import com.tran16.model.ContactData;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {
    @Test
    public void testContactCreation() {
              app.getContactHelper().initContactCreation();
        app.getContactHelper().fillContactForm(new ContactData()
                .withFirstname("Irisha")
                .withLastname("Cat")
                .withAddress("Ukraina")
                .withNickname("Risha")
                .withCompany("Tel-Ran")
                .withEmail("Irishechka@gmail.com"));
        app.getContactHelper().submitContactCreation();
        app.getContactHelper().returnToTheHomePage();

    }

}
