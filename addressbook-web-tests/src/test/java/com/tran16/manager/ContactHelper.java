package com.tran16.manager;

import com.tran16.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactHelper {
    WebDriver wd;

    public ContactHelper(WebDriver wd) {
        //33 min

        this.wd = wd;
    }


    public void submitContactCreation() {
        wd.findElement(By.name("submit")).click();

    }

    public void confirmTheChangeInContact() {
        wd.findElement(By.name("update")).click();

    }

    public void returnToTheHomePage() {
        wd.findElement(By.linkText("home")).click();

    }

    public void fillContactForm(ContactData contactData) {
        wd.findElement(By.name("firstname")).click();
        wd.findElement(By.name("firstname")).clear();
        wd.findElement(By.name("firstname")).sendKeys(contactData.getFirstname());


        wd.findElement(By.name("lastname")).click();
        wd.findElement(By.name("lastname")).clear();
        wd.findElement(By.name("lastname")).sendKeys(contactData.getLastname());


        wd.findElement(By.name("address")).click();
        wd.findElement(By.name("address")).clear();
        wd.findElement(By.name("address")).sendKeys(contactData.getAddress());

        wd.findElement(By.name("nickname")).click();
        wd.findElement(By.name("nickname")).clear();
        wd.findElement(By.name("nickname")).sendKeys(contactData.getNickname());

        wd.findElement(By.name("company")).click();
        wd.findElement(By.name("company")).clear();
        wd.findElement(By.name("company")).sendKeys(contactData.getCompany());

        wd.findElement(By.name("email")).click();
        wd.findElement(By.name("email")).clear();
        wd.findElement(By.name("email")).sendKeys(contactData.getEmail());
    }

    public void initContactCreation() {
        wd.findElement(By.linkText("add new")).click();
    }

    public void initContactModification() {

        wd.findElement(By.xpath("//*[@alt='Edit'][1]")).click();
    }

    public void confirmAlert() {
        wd.switchTo().alert().accept();
    }

    public void contactDeletion() {
        wd.findElement(By.xpath("//*[@value='Delete']")).click();
    }

    public void selectContact() {
        wd.findElement(By.name("selected[]")).click();
    }

    public void createContact() {
        initContactCreation();
        fillContactForm(new ContactData()
                .withFirstname("Irisha")
                .withLastname("Cat")
                .withAddress("Ukraina")
                .withNickname("Risha")
                .withCompany("Tel-Ran")
                .withEmail("Irishechka@gmail.com"));
        submitContactCreation();
        returnToTheHomePage();

    }

    public void selectContactByIndex(int ind) {
        wd.findElements(By.name("selected[]")).get(ind).click();
    }

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }
}
