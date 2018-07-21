package com.tran16;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase {

    @Test
    public void contactDeletionTest() {
        int before = wd.findElements(By.name("selected[]")).size();
        selectContact();
        deleteContact();
        confirmAlert();
        int after = wd.findElements(By.name("selected[]")).size();
        Assert.assertEquals(after, before - 1);
    }

}