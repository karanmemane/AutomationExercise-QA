
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

public class SearchProductTest {

    @Test
    public void searchProduct() {

        // Step 1: Launch Chrome and maximize the browser window
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Step 2: Create an explicit wait of 20 seconds
        WebDriverWait wait = new WebDriverWait(
            driver, Duration.ofSeconds(20)
        );

        try {
            // Step 3: Open the All Products page
            driver.get("https://www.automationexercise.com/products");

            // Step 4: Locate the All Products heading
            By productsHeading = By.xpath(
                "/html/body/section[2]/div/div/div[2]/div/h2"
            );

            // Wait until the heading is visible
            WebElement heading = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                    productsHeading
                )
            );

            // Verify that the All Products page is displayed
            Assert.assertEquals(
                heading.getText().trim(),
                "ALL PRODUCTS",
                "All Products heading is incorrect"
            );

            // Step 5: Locate the product search box
            By searchBox = By.id("search_product");

            // Wait until the search box is visible
            WebElement searchInput = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                    searchBox
                )
            );

            // Enter the product name to search for
            searchInput.sendKeys("Blue Top");

            // Step 6: Locate the Search button
            By searchButton = By.id("submit_search");

            // Wait until the Search button is clickable, then click it
            wait.until(
                ExpectedConditions.elementToBeClickable(searchButton)
            ).click();

            // Step 7: Locate the Searched Products heading
            By searchedProductHeading = By.xpath(
                "//section[2]//div[contains(@class,'features_items')]/h2"
            );

            // Wait until the search results heading is visible
            WebElement searchedHeading = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                    searchedProductHeading
                )
            );

            // Verify that the searched products section is displayed
            Assert.assertEquals(
                searchedHeading.getText().trim(),
                "SEARCHED PRODUCTS",
                "Searched Products heading is incorrect"
            );

            // Step 8: Locate the Blue Top product name in the results
            By blueTopProduct = By.xpath(
                "//div[contains(@class,'productinfo')]//p[normalize-space()='Blue Top']"
            );

            // Wait until the Blue Top product name is visible
            WebElement product = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                    blueTopProduct
                )
            );

            // Verify that the search results contain Blue Top
            Assert.assertEquals(
                product.getText().trim(),
                "Blue Top",
                "Blue Top product was not found in the search results"
            );

            // Print success only if all assertions pass
            System.out.println("Product search test passed!");

        } finally {
            // Step 9: Always close the browser after the test
            driver.quit();
        }
    }
}
