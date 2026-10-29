
package com.karan.automation.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class VerifyProductQuantityInCartTest {

    @Test
    public void verifyProductQuantityInCart() {

        // Step 1: Launch the Chrome browser
        ChromeDriver driver = new ChromeDriver();

        // Wait up to 20 seconds for web elements
        WebDriverWait wait = new WebDriverWait(
            driver, Duration.ofSeconds(20)
        );

        try {
            // Step 2: Maximize the browser window
            driver.manage().window().maximize();

            // Step 3: Navigate to the Automation Exercise home page
            driver.get("https://www.automationexercise.com/");

            By viewProductButton = By.xpath("/html/body/section[2]/div/div/div[2]/div[1]/div[3]/div/div[2]/ul/li/a");
            wait.until(
                ExpectedConditions.elementToBeClickable(
                    viewProductButton
                )
            ).click();

            // Step 4: Locate the quantity input field
            By quantityField = By.id("quantity");

            // Step 5: Wait for the quantity field and enter 4
            WebElement quantityInput = wait.until(
                ExpectedConditions.visibilityOfElementLocated(quantityField)
            );

            quantityInput.clear();
            quantityInput.sendKeys("4");
        } finally { 
            // Close the browser after the test finishes
            driver.quit();
        }
    }
}
 