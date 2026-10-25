
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

public class ProductsPageTest {

    @Test
    public void verifyProductsPage() {

        WebDriver driver = new ChromeDriver();

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(20));

        try {
            // Open the Products page directly
            driver.get("https://www.automationexercise.com/products");

            // Wait until the Products page URL is loaded
            wait.until(
                    ExpectedConditions.urlContains("/products")
            );

            // Locate the All Products heading
            By productsHeading =
                    By.xpath("/html/body/section[2]/div/div/div[2]/div/h2");

            WebElement heading = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            productsHeading
                    )
            );

            // Verify the page URL
            Assert.assertTrue(
                    driver.getCurrentUrl().contains("/products"),
                    "Products page URL was not loaded correctly."
            );

            // Verify the heading without case sensitivity
            Assert.assertEquals(
                    heading.getText().trim().toUpperCase(),
                    "ALL PRODUCTS",
                    "Products heading does not match."
            );

            System.out.println(
                    "Page title: " + driver.getTitle()
            );

            System.out.println(
                    "Page URL: " + driver.getCurrentUrl()
            );

            System.out.println(
                    "Products heading: " + heading.getText()
            );

        } finally {
            // Always close the browser
            driver.quit();
        }
    }
}
