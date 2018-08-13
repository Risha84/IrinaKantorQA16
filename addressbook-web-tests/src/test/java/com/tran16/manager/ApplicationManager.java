package com.tran16.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    SessionHelper sessionHelper;
    GroupHelper groupHelper;
    ContactHelper contactHelper;
    private WebDriver wd;

    public void start() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        sessionHelper = new SessionHelper(wd);
        sessionHelper.openSite("http://localhost/addressbook/");
        windowMax();
        sessionHelper.login("admin", "secret");
        groupHelper = new GroupHelper(wd);
        contactHelper = new ContactHelper(wd);

    }

    public void windowMax() {
        wd.manage().window().maximize();
    }

    public void stop() {
        wd.quit();
    }


    public boolean isElementsPresent(By locator) {
        return wd.findElements(locator).size() > 0;

    }


    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public SessionHelper getSessionHelper() {
        return sessionHelper;
    }

    public ContactHelper getContactHelper() {
        return contactHelper;
    }

}
