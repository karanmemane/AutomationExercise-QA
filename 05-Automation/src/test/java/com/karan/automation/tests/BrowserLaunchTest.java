
package com.karan.automation.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.Assert;

public class BrowserLaunchTest {

    @Test
    public void openAutomationExercise() {
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://www.automationexercise.com/");
            System.out.println("Page title: " + driver.getTitle());
            System.out.println("Current URL: " + driver.getCurrentUrl());
            Assert.assertEquals(driver.getTitle(), "Automation Exercise");
            Assert.assertEquals(driver.getCurrentUrl(), "https://www.automationexercise.com/");
        } finally {
            driver.quit();
        }
    }
}
