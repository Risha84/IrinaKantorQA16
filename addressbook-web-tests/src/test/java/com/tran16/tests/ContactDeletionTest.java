package com.tran16.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase {

    @Test
    public void contactDeletionTest() {
        if(!app.getContactHelper().isContactPresent()){
            app.getContactHelper().createContact();
        }
        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().selectContact();
        app.getContactHelper().contactDeletion();
        app.getContactHelper().confirmAlert();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before - 1);
    }

}