
package com.karan.automation.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BrowserLaunchTest {

    @Test
    public void openAutomationExercise() {
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://www.automationexercise.com/");
            System.out.println("Page title: " + driver.getTitle());
        } finally {
            driver.quit();
        }
    }
}
