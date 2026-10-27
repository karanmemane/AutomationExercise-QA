
package com.karan.automation.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyProductDetailsTest {

    @Test
    public void verifyProductDetails() {

        // Step 1: Launch Chrome and set an explicit wait of 20 seconds
        WebDriver driver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(
            driver, Duration.ofSeconds(20)
        );

        try {
            // Step 2: Open the All Products page
            driver.get("https://www.automationexercise.com/products");

            // Step 3: Locate and verify the All Products heading
            By productsHeading = By.xpath(
                "//section[2]//div[contains(@class,'features_items')]/h2"
            );

            WebElement heading = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                    productsHeading
                )
            );

            Assert.assertEquals(
                heading.getText().trim(),
                "ALL PRODUCTS",
                "All Products heading is incorrect"
            );

            // Step 4: Locate the first product's View Product link
            By viewProductButton = By.cssSelector(
                "a[href='/product_details/1']"
            );

            // Wait until the link is visible
            WebElement viewProduct = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                    viewProductButton
                )
            );

            // Scroll the link into the center of the viewport
            ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block: 'center'});",
                viewProduct
            );

            // Wait until Selenium considers the link clickable, then click
            wait.until(
                ExpectedConditions.elementToBeClickable(
                    viewProductButton
                )
            ).click();

            // Step 5: Locate and verify the product name
            By productName = By.xpath(
                "//div[contains(@class,'product-information')]/h2"
            );

            WebElement name = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                    productName
                )
            );

            Assert.assertEquals(
                name.getText().trim(),
                "Blue Top",
                "Product name is incorrect"
            );

            // Step 6: Verify the product category
            By productCategory = By.xpath(
                "//div[contains(@class,'product-information')]/p[1]"
            );

            WebElement category = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                    productCategory
                )
            );

            Assert.assertEquals(
                category.getText().trim(),
                "Category: Women > Tops",
                "Product category is incorrect"
            );

            // Step 7: Verify the product price
            By productPrice = By.xpath(
                "//div[contains(@class,'product-information')]/span/span"
            );

            WebElement price = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                    productPrice
                )
            );

            Assert.assertEquals(
                price.getText().trim(),
                "Rs. 500",
                "Product price is incorrect"
            );

            // Step 8: Verify product availability
            By productAvailability = By.xpath(
                "//div[contains(@class,'product-information')]/p[2]"
            );

            WebElement availability = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                    productAvailability
                )
            );

            Assert.assertTrue(
                availability.getText().contains("Availability:"),
                "Availability information is missing"
            );

            Assert.assertTrue(
                availability.getText().contains("In Stock"),
                "Product is not shown as in stock"
            );

            // Step 9: Verify the product condition
            By productCondition = By.xpath(
                "//div[contains(@class,'product-information')]/p[3]"
            );

            WebElement condition = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                    productCondition
                )
            );

            Assert.assertTrue(
                condition.getText().contains("Condition:"),
                "Product condition information is missing"
            );

            Assert.assertTrue(
                condition.getText().contains("New"),
                "Product condition is not shown as New"
            );

            // Step 10: Verify the product brand
            By productBrand = By.xpath(
                "//div[contains(@class,'product-information')]/p[4]"
            );

            WebElement brand = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                    productBrand
                )
            );

            Assert.assertTrue(
                brand.getText().contains("Brand:"),
                "Product brand information is missing"
            );

            Assert.assertTrue(
                brand.getText().contains("Polo"),
                "Product brand is not shown as Polo"
            );

            // Print success only when all assertions pass
            System.out.println(
                "Product details verification passed!"
            );

        } finally {
            // Step 11: Close the browser even if the test fails
            driver.quit();
        }
    }
}
