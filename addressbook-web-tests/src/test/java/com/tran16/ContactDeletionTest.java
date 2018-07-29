package com.tran16;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase {

    @Test
    public void contactDeletionTest() {
        if(!isContactPresent()){
            createContact();
        }
        int before = getContactCount();
        selectContact();
        contactDeletion();
        confirmAlert();
        int after = getContactCount();
        Assert.assertEquals(after, before - 1);
    }

}