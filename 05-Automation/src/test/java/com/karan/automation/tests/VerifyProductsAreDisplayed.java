package com.karan.automation.tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyProductsAreDisplayed {

    @Test
    public void verifyProductsAreDisplayed() {

        // Step 1: Open the Chrome browser
        ChromeDriver driver = new ChromeDriver();

        try {
            // Step 2: Open the Products page
            driver.get("https://www.automationexercise.com/products");

            // Step 3: Wait up to 10 seconds for product cards to become visible
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Step 4: Find product cards using their HTML class name
            By productCards = By.className("product-image-wrapper");

            // Step 5: Get all visible product cards and store them in a list
            List<WebElement> products = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(productCards)
            );

            // Step 6: Check that at least one product card exists
            Assert.assertTrue(products.size() > 0, "No products were displayed.");

            // Step 7: Print the number of products found
            System.out.println("Products displayed: " + products.size());

        } finally {
            // Step 8: Close the browser, even if the test fails
            driver.quit();
        }
    }
}