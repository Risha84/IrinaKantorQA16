package com.tran16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GroupDeletionTest extends TestBase {

    @Test
    public void test1() {
        goToGroupsPage();
        selectGroup();
        groupDeletion();
        returnToGroupsPage();
    }
}

