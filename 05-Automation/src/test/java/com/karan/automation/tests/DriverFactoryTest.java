package com.karan.automation.tests;

import org.testng.annotations.Test;
import org.testng.Assert;


public class DriverFactoryTest extends BaseTest {

    @Test
    public void launchBrowser() {

        driver.get("https://automationexercise.com/");
        

        System.out.println("Page Title: " + driver.getTitle());

        Assert.assertTrue(driver.getTitle().contains("Automation Exercise"),
                "Website title does not match!");
    }
}