
package com.karan.automation.tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RemoveProductsFromCart {

    @Test
    public void testRemoveProductsFromCart() {

        WebDriver driver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(
                driver, Duration.ofSeconds(20));

        try {

            // Step 1: Open homepage
            driver.get("https://www.automationexercise.com/");

            wait.until(ExpectedConditions.titleIs("Automation Exercise"));

            Assert.assertEquals(
                    driver.getTitle(), "Automation Exercise");

            System.out.println("Homepage displayed successfully.");

            // Step 2: Navigate to Products page
            By productLink = By.xpath(
                    "//*[@id='header']/div/div/div/div[2]/div/ul/li[2]/a");

            wait.until(
                    ExpectedConditions.elementToBeClickable(productLink))
                    .click();

            wait.until(ExpectedConditions.urlContains("/products"));

            System.out.println("Products page displayed successfully.");

            // Step 3: Add first product
            By addToCartButton1 = By.cssSelector(
                "a.add-to-cart[data-product-id='1']");

            clickAddToCart(driver, wait, addToCartButton1);

            System.out.println("First product added to cart.");

            // Step 4: Continue shopping
            By continueShoppingButton = By.xpath(
                    "//*[@id='cartModal']//button[contains(text(),'Continue Shopping')]");

            wait.until(
                    ExpectedConditions.elementToBeClickable(
                            continueShoppingButton))
                    .click();

            System.out.println("Continue Shopping clicked.");

            // Step 5: Add second product
            By addToCartButton2 = By.cssSelector(
                    "a.add-to-cart[data-product-id='2']");

            clickAddToCart(driver, wait, addToCartButton2);

            System.out.println("Second product added to cart.");

            // Step 6: Open cart
            By viewCartButton = By.xpath(
                    "//*[@id='cartModal']//a[contains(@href,'/view_cart')]");

            wait.until(
                    ExpectedConditions.elementToBeClickable(viewCartButton))
                    .click();

            wait.until(ExpectedConditions.urlContains("/view_cart"));

            System.out.println("Cart page displayed successfully.");

            // Step 7: Inspect cart rows
            By cartRows = By.cssSelector(
                    "#cart_info_table tbody tr");

            wait.until(ExpectedConditions.numberOfElementsToBe(
                    cartRows, 2));

            List<WebElement> rows = driver.findElements(cartRows);

            System.out.println("Product rows found: " + rows.size());

            for (WebElement row : rows) {
                System.out.println("Cart row ID: " + row.getAttribute("id"));
                System.out.println("Product details: " +
                        row.getText().replace("\n", " | "));
            }

            Assert.assertEquals(
                    rows.size(), 2,
                    "Expected two products in the cart.");

            // Step 8: Remove the second product row
            WebElement secondRow = rows.get(1);

            By removeButton = By.cssSelector(
                    "a.cart_quantity_delete");

            secondRow.findElement(removeButton).click();

            // Step 9: Wait until only one row remains
            wait.until(ExpectedConditions.numberOfElementsToBe(
                    cartRows, 1));

            List<WebElement> remainingRows =
                    driver.findElements(cartRows);

            Assert.assertEquals(
                    remainingRows.size(), 1,
                    "Second product was not removed.");

            System.out.println("Second product removed successfully.");

            // Step 10: Verify first product remains
            Assert.assertTrue(
                    remainingRows.get(0).isDisplayed(),
                    "First product should remain in the cart.");

            System.out.println("First product remains in the cart.");
            System.out.println("Test Case 17 completed successfully.");

        } finally {

            driver.quit();
        }
    }

    // Reusable method to add products to cart
    private void clickAddToCart(
            WebDriver driver,
            WebDriverWait wait,
            By locator) {

        WebElement button = wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator));

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block: 'center'});",
                button);

        String elementAtPoint = (String)
                ((JavascriptExecutor) driver).executeScript(
                        "var r = arguments[0].getBoundingClientRect();" +
                        "return document.elementFromPoint(" +
                        "r.left + r.width / 2, " +
                        "r.top + r.height / 2).outerHTML;",
                        button);

        System.out.println(
                "Element receiving click: " + elementAtPoint);

        wait.until(
                ExpectedConditions.elementToBeClickable(locator))
                .click();
    }
}
