
package com.karan.automation.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ViewCategoryProducts {

    @Test
    public void viewCategoryProducts() {

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

            // Step 3: Verify Categories heading is visible
            By categoryHeading = By.xpath(
                    "//div[contains(@class,'category-products')]/h2");

            String actualCategoryHeading = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(categoryHeading))
                    .getText()
                    .trim();

            Assert.assertEquals(actualCategoryHeading, "CATEGORY");

            System.out.println("Categories sidebar displayed successfully.");

            // Step 4: Click Women category
            By womenSection = By.xpath(
                    "//*[@id='accordian']/div[1]/div[1]/h4/a");

            wait.until(ExpectedConditions.elementToBeClickable(womenSection)).click();

            System.out.println("Women category clicked successfully.");

            // Step 5: Click Dress subcategory
            By dressSection = By.xpath(
                    "//*[@id='Women']/div/ul/li[1]/a");

            wait.until(ExpectedConditions.elementToBeClickable(dressSection)).click();

            System.out.println("Dress subcategory clicked successfully.");

            // Step 6: Verify Women Dress category page
            By dressPageHeading = By.xpath(
                    "//h2[contains(.,'Women') and contains(.,'Dress')]");

            String actualDressHeading = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(dressPageHeading))
                    .getText()
                    .replaceAll("\\s+", " ")
                    .trim();

            Assert.assertEquals(actualDressHeading, "WOMEN - Dress PRODUCTS");

            System.out.println("Women Dress category page displayed successfully.");

            System.out.println("Test Case 18 completed successfully.");

        } finally {

            // Close browser
            driver.quit();
        }
    }
}
