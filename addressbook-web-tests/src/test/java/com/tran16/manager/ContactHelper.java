package com.tran16.manager;

import com.tran16.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {


    public ContactHelper(WebDriver wd) {


        super(wd);
    }


    public void submitContactCreation() throws InterruptedException {
        wd.findElement(By.name("submit")).click();
        Thread.sleep(2000);

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
        wd.findElement(By.xpath("//*[@href='edit.php']")).click();
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

    public void createContact() throws InterruptedException {
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

    public void isOnContactPage() {
        if (!isElementPresent(By.xpath("//table[@id='maintable']")))
        {
            click(By.xpath("//a[contains(text(),'home')]"));
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


    public List<ContactData> getContactsList() {
        List<ContactData> contacts = new ArrayList<>();

        List<WebElement> rows = wd.findElements(By.name("entry"));
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            int id = Integer.parseInt(cells.get(0).findElement(By.name("selected[]")).getAttribute("value"));
            String lastName = cells.get(1).getText();
            String firstName = cells.get(2).getText();
            contacts.add(new ContactData().withId(id).withLastname(lastName).withFirstname(firstName));
        }
        return  contacts;
    }
}

