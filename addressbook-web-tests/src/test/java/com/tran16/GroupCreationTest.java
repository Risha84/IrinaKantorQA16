package com.tran16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GroupCreationTest extends TestBase{

        @Test
        public void testGroupCreation(){
                goToGroupsPage();
                initGroupCreation();
                fillGroupsForm(name:"testGroupName1",);
                submitGroupCreation();
                returnToTheGroupsPage();
        }


}