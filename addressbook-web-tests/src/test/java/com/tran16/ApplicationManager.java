package com.tran16;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    SessionHelper sessionHelper;
    GroupHelper groupHelper;
    private WebDriver wd;

    public void start() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        sessionHelper = new SessionHelper(wd);
        sessionHelper.openSite("http://localhost/addressbook/");
        windowMax();
        sessionHelper.login("admin","secret");
        groupHelper = new GroupHelper(wd);
    }

    public void click(By locator){
        wd.findElement(locator).click();
    }

    public void windowMax() {
        wd.manage().window().maximize();
    }

    public void stop() {
        wd.quit();
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



    public boolean isElementsPresent(By locator){
return wd.findElements(locator).size()>0;

    }
    public boolean isElementPresent(By locator) {
        try {
            wd.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isContactPresent(){
        return isElementPresent(By.name("selected[]"));
    }

    public void createContact(){
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

    public void selectContactByIndex(int ind){
        wd.findElements(By.name("selected[]")).get(ind).click();
    }

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public boolean areEltsPresent(By locator) {
        return wd.findElements(locator).size()>0;
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public SessionHelper getSessionHelper() {
        return sessionHelper;
    }
}
