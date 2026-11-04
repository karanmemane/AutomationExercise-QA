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

public class ViewAndCartBrandProducts {

    @Test
    public void viewAndCartBrandProducts() {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        try {

            // Step 1: Launch browser and open homepage
            driver.get("https://www.automationexercise.com/");

            wait.until(ExpectedConditions.titleIs("Automation Exercise"));

            Assert.assertEquals(driver.getTitle(), "Automation Exercise");

            System.out.println("Homepage displayed successfully.");

            // Step 2: Navigate to Products page
            By productLink = By.xpath(
                    "//*[@id='header']/div/div/div/div[2]/div/ul/li[2]/a");

            wait.until(ExpectedConditions.elementToBeClickable(productLink)).click();

            wait.until(ExpectedConditions.urlContains("/products"));

            System.out.println("Products page displayed successfully.");

            // Step 3: Verify Brands heading is visible
            By brandHeading = By.xpath(
        "//div[contains(@class,'brands_products')]/h2");

            String actualBrandHeading = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(brandHeading))
                    .getText()
                    .trim();

            Assert.assertEquals(actualBrandHeading, "BRANDS");

            System.out.println("Brands displayed successfully.");

            // Step 4: Click Polo brand
            By poloBrand = By.cssSelector("a[href='/brand_products/Polo']");

            wait.until(ExpectedConditions.elementToBeClickable(poloBrand)).click();

            System.out.println("Polo brand clicked successfully.");

            // Step 5: Verify Polo brand page
            By poloBrandHeading = By.xpath(
                    "//h2[contains(@class,'title') and contains(.,'Polo')]");

            String actualPoloHeading = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(poloBrandHeading))
                    .getText()
                    .replaceAll("\\s+", " ")
                    .trim();

            Assert.assertEquals(
                actualPoloHeading.toUpperCase(),
                "BRAND - POLO PRODUCTS"
            );

            // Verify Polo products are displayed
            By poloProducts = By.cssSelector(".features_items .product-image-wrapper");

            wait.until(ExpectedConditions.visibilityOfElementLocated(poloProducts));

            Assert.assertTrue(
                    driver.findElements(poloProducts).size() > 0,
                    "Polo products are not displayed.");

            System.out.println("Polo brand products displayed successfully.");


            System.out.println("Test Case 19 completed successfully.");

        } finally {

            // Step 8: Close browser
            driver.quit();
        }
    }
}