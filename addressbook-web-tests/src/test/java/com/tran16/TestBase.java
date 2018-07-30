package com.tran16;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    public static ApplicationManager app = new ApplicationManager();

    @BeforeSuite
    public void setUp() {
        app.start();

    }

    @AfterSuite
    public void tearDown() {
        app.stop();
    }


}