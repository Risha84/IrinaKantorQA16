package com.tran16.manager;

import com.tran16.tests.MyListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    SessionHelper sessionHelper;
    GroupHelper groupHelper;
    ContactHelper contactHelper;
    private EventFiringWebDriver wd;
    private String browser;

    public ApplicationManager(String browser) {

        this.browser = browser;
    }

    public void start() {
        if (browser.equals(BrowserType.CHROME)) {
            wd = new EventFiringWebDriver(new ChromeDriver());
        } else if (browser.equals(BrowserType.FIREFOX)) {
            wd = new EventFiringWebDriver(new FirefoxDriver());
        } else if (browser.equals(BrowserType.EDGE)) {
            wd = new EventFiringWebDriver(new EdgeDriver());
        }
        wd.register(new MyListener());
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
