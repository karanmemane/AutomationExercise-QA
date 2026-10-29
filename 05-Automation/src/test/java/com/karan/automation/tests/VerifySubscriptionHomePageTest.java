package com.karan.automation.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifySubscriptionHomePageTest {

    @Test
    public void verifySubscriptionHomePage() {

        // Step 1: Launch Chrome and maximize the browser window
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Step 2: Create an explicit wait of 20 seconds
        WebDriverWait wait = new WebDriverWait(
            driver, Duration.ofSeconds(20)
        );

        try {
            // Step 3: Open the home page
            driver.get("https://www.automationexercise.com/");

            // Step 4: Locate the subscription section
            By subscriptionSection = By.xpath("//*[@id=\"footer\"]/div[1]/div/div/div[2]/div/h2");

            // Wait until the subscription section is visible
            WebElement subscriptionElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                    subscriptionSection
                )
            );

            // Verify that the subscription section is displayed
            Assert.assertTrue(
                subscriptionElement.isDisplayed(),
                "Subscription section is not displayed"
            );

        } finally {
            // Close the browser
            driver.quit();
        }
    }
}