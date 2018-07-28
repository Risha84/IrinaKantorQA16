package com.tran16;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver wd;

    @BeforeMethod
    public void setUp() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        openSite();
        windowMax();
        login();
    }

    public void windowMax() {
        wd.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        wd.quit();
    }

    public void openSite() {
        wd.get("http://localhost/addressbook/");
    }

    public void goToGroupsPage() {
        // wd.findElement(By.linkText("groups")).click();
       //wd.findElement(By.xpath(//*[@href='group.php'])).click();
               wd.findElement(By.cssSelector("[href='group.php']")).click();
    }

    public void login() {
        wd.findElement(By.name("user")).click();
        wd.findElement(By.name("user")).clear();
        wd.findElement(By.name("user")).sendKeys("admin");

        wd.findElement(By.name("pass")).click();
        wd.findElement(By.name("pass")).clear();
        wd.findElement(By.name("pass")).sendKeys("secret");

        wd.findElement(By.xpath("//*[@value='Login']")).click();
    }


    public void submitGroupCreation() {
        wd.findElement(By.name("submit")).click();
    }

    public void fillGroupsForm(GroupData groupData) {
        wd.findElement(By.name("group_name")).click();
        wd.findElement(By.name("group_name")).clear();
        wd.findElement(By.name("group_name")).sendKeys(groupData.getName());

        wd.findElement(By.name("group_header")).click();

        wd.findElement(By.name("group_header")).clear();
        wd.findElement(By.name("group_header")).sendKeys(groupData.getHeader());

        wd.findElement(By.name("group_footer")).click();
        wd.findElement(By.name("group_footer")).clear();
        wd.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
    }

    public void initGroupCreation() {

        //   wd.findElement(By.name("new")).click();
        wd.findElement(By.xpath("//*@value='New group'][2]")).click();
        //[value='New group']
    }


    public void groupDeletion() {
        wd.findElement(By.name("delete")).click();
    }

    public void selectGroup() {
        wd.findElement(By.name("selected[]")).click();
    }

    public void selectGroupByIndex(int ind) {
        wd.findElements(By.name("selected[]")).get(ind).click();
    }


    public void createContact() {
        wd.findElement(By.name("submit")).click();
    }

    public void returnToTheGroupsPage() {
        wd.findElement(By.linkText("group page")).click();
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
    }

    public void initContactCreation() {
        wd.findElement(By.linkText("add new")).click();
    }

    public void submitGroupModification() {
        wd.findElement(By.name("update")).click();
    }

    public void initGroupModification() {

        wd.findElement(By.cssSelector("//*[@name='edit'][1]")).click();
    }

    public void confirmAlert() {
        wd.switchTo().alert().accept();
    }

    public void deleteContact() {
        wd.findElement(By.xpath("//*[@value='Delete']")).click();
    }

    public void selectContact() {
        wd.findElement(By.name("selected[]")).click();
    }

    public int getGroupsCount() {
        return wd.findElements(By.cssSelector("span group")).size();
    }

    public boolean isElementPresent(By locator) {
        try {
            wd.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public boolean isElementsPresent(By locator){
return wd.findElements(locator).size()>0;

    }
public boolean isGroupPresent(){
        return isElementPresent(By.name("selected[]"));
}
public void createGroup(){
    initGroupCreation();
    fillGroupsForm(new GroupData()
            .withName("testGroupName1")
            .withHeader("testGroupHeader1")
            .withFooter("testGroupFooter1"));
    submitGroupCreation();
    returnToTheGroupsPage();
}
    public boolean isContactPresent(){
        return isElementPresent(By.name("selected[]"));
    }
    public void createContactField(){
        initContactCreation();
    fillContactForm(new ContactData()
                .withFirstname("Irisha")
                .withLastname("Cat")
                .withAddress("Ukraina")
                .withNickname("Risha")
                .withCompany("Tel-Ran")
                .withEmail("Irishechka@gmail.com"));
        createContact();
        returnToTheHomePage();

}
}