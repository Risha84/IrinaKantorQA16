package com.tran16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase{

    public SessionHelper(WebDriver wd) {
        super(wd);
    }

    public void openSite(String url) {
        wd.get(url);
    }

    public void login(String userName, String password) {
       // wd.findElement(By.name("user")).click();
       // wd.findElement(By.cssSelector("[name='user']")).click();
        wd.findElement(By.xpath("//*[@name='user']")).click();
        wd.findElement(By.xpath("//*[@name='user']")).clear();
        wd.findElement(By.xpath("//*[@name='user']")).sendKeys(userName);

        wd.findElement(By.xpath("//*[@name='pass']")).click();
        wd.findElement(By.cssSelector("[name='pass']")).clear();
        wd.findElement(By.name("pass")).sendKeys(password);

       // wd.findElement(By.xpath("//*[@value='Login']")).click();
        wd.findElement(By.cssSelector("[value='Login']")).click();
            }
}
