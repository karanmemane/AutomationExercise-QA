
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

public class VerifySubscriptionCartPageTest {

    @Test
    public void verifySubscriptionCartPage() {

        WebDriver driver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(
            driver, Duration.ofSeconds(20)
        );

        try {
            // Step 1: Open the home page
            driver.manage().window().maximize();
            driver.get("https://www.automationexercise.com/");

            // Step 2: Verify that the home page is visible
            Assert.assertTrue(
                driver.getTitle().contains("Automation Exercise"),
                "Home page is not displayed"
            );

            // Step 3: Click the Cart button
            By cartLink = By.xpath("//a[normalize-space()='Cart']");

            wait.until(
                ExpectedConditions.elementToBeClickable(cartLink)
            ).click();

            // Step 4: Verify that the Cart page opens
            wait.until(
                ExpectedConditions.urlContains("view_cart")
            );

            Assert.assertTrue(
                driver.getCurrentUrl().contains("view_cart"),
                "Cart page did not open"
            );

            // Step 5: Locate the Subscription heading
            By subscriptionHeading = By.xpath(
                "//*[@id='footer']//h2[normalize-space()='Subscription']"
            );

            WebElement heading = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                    subscriptionHeading
                )
            );

            // Step 6: Verify the Subscription heading
            Assert.assertTrue(
                heading.isDisplayed(),
                "Subscription heading is not visible"
            );

            // Step 7: Enter the email address
            WebElement emailInput = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                    By.id("susbscribe_email")
                )
            );

            emailInput.sendKeys("karan.test@example.com");

            // Step 8: Click the subscription arrow
            wait.until(
                ExpectedConditions.elementToBeClickable(
                    By.id("subscribe")
                )
            ).click();

            // Step 9: Verify the success message
            WebElement successMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                    By.xpath(
                        "//*[contains(text(),'You have been successfully subscribed!')]"
                    )
                )
            );

            Assert.assertEquals(
                successMessage.getText().trim(),
                "You have been successfully subscribed!",
                "Subscription success message is incorrect"
            );

            System.out.println(
                "Cart page subscription test passed!"
            );

        } finally {
            // Always close the browser
            driver.quit();
        }
    }
}
