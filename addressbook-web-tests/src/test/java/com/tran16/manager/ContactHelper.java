package com.tran16.manager;

import com.tran16.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactHelper extends HelperBase {


    public ContactHelper(WebDriver wd) {


        super(wd);
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
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("address"), contactData.getAddress());
        type(By.name("nickname"), contactData.getNickname());
        type(By.name("company"), contactData.getCompany());
        type(By.name("email"), contactData.getEmail());
    }

    public void initContactCreation() {
        wd.findElement(By.linkText("add new")).click();
    }

    public void initContactModification() {

        wd.findElement(By.xpath("//*[@alt='Edit'][1]")).click();
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

    public void isOnContactsPage() {
        if (!isContactPresent(By.id("maintable"))) {
            click(By.xpath("//a[@href='./'"));
        }
    }

    public void selectContactByIndex(int ind) {
        wd.findElements(By.name("selected[]")).get(ind).click();
    }

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public boolean isContactPresent() {
        return isElementPresent(By.name("selected[]"));
    }

}
