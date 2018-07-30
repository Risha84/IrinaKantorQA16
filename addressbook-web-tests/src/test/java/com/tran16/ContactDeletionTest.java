package com.tran16;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase {

    @Test
    public void contactDeletionTest() {
        if(!app.isContactPresent()){
            app.createContact();
        }
        int before = app.getContactCount();
        app.selectContact();
        app.contactDeletion();
        app.confirmAlert();
        int after = app.getContactCount();
        Assert.assertEquals(after, before - 1);
    }

}