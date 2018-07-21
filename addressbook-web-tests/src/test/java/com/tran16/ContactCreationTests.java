package com.tran16;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {
    @Test
    public void testContactCreation() {
        initContactCreation();
        fillContactForm(new ContactData()
                .withFirstname("Risha")
                .withLastname("Cat")
                .withAddress("Ukraina"));
        createContact();

    }

}
