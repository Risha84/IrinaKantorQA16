package com.tran16;

import com.tran16.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {
    @Test
    public void testContactCreation() {
        initContactCreation();
        fillContactForm(firstname:"", lastname:"", address:"");
        createContact();
        returnToTheHomePage();

    }

    public void createContact() {
        wd.findElement(By.name("submit")).click();
    }

    public void returnToTheHomePage() {

    }

    public void fillContactForm(String firstname, String lastname, String address) {
        wd.findElement(By.name("firstname")).click();
        wd.findElement(By.name("firstname")).clear();
        wd.findElement(By.name("firstname")).sendKeys(firstname);

        wd.findElement(By.name("lastname")).click();
        wd.findElement(By.name("lastname")).clear();
        wd.findElement(By.name("lastname")).sendKeys(lastname);

        wd.findElement(By.name("address")).click();
        wd.findElement(By.name("address")).clear();
        wd.findElement(By.name("address")).sendKeys(address);
    }

    public void initContactCreation() {
        wd.findElement(By.linkText("")).click();
    }

}
