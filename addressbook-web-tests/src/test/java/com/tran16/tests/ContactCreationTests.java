package com.tran16.tests;

import com.tran16.manager.TestBase;
import com.tran16.model.ContactData;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {
    @Test
    public void testContactCreation() {
              app.initContactCreation();
        app.fillContactForm(new ContactData()
                .withFirstname("Irisha")
                .withLastname("Cat")
                .withAddress("Ukraina")
                .withNickname("Risha")
                .withCompany("Tel-Ran")
                .withEmail("Irishechka@gmail.com"));
        app.submitContactCreation();
        app.returnToTheHomePage();

    }

}
