
package com.karan.automation.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class AddProductsToCartTest {

    @Test
    public void addProductsToCart() {

        // Initialize the Chrome browser
        ChromeDriver driver = new ChromeDriver();

        // Create an explicit wait to wait up to 20 seconds
        // for required web elements or conditions
        WebDriverWait wait = new WebDriverWait(
            driver, Duration.ofSeconds(20)
        );

        try {
            // Step 1: Maximize the browser window
            driver.manage().window().maximize();

            // Step 2: Navigate to the Automation Exercise home page
            driver.get("https://www.automationexercise.com/");

            // Step 3: Locate the Add to Cart button for the first product
            // The XPath selects the first matching Add to Cart link
            By addCartButton = By.xpath(
                "(//a[contains(@class,'add-to-cart')])[1]"
            );

            // Step 4: Wait until the first product's button is present
            // in the DOM and store the element
            WebElement firstProductButton = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                    addCartButton
                )
            );

            // Step 5: Scroll the page until the button is centered
            // This helps bring the button into the visible area
            ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript(
                    "arguments[0].scrollIntoView({block: 'center'});",
                    firstProductButton
                );

            // Step 6: Wait until the button is clickable, then click it
            wait.until(
                ExpectedConditions.elementToBeClickable(
                    firstProductButton
                )
            ).click();

            // Step 7: Locate the Continue Shopping button
            // inside the cart confirmation modal
            By continueShoppingButton = By.xpath(
                "//*[@id='cartModal']//button[contains(text(),'Continue Shopping')]"
            );

            // Step 8: Wait until Continue Shopping is clickable,
            // then click it to close the modal and continue shopping
            wait.until(
                ExpectedConditions.elementToBeClickable(
                    continueShoppingButton
                )
            ).click();

            // Next steps:
            // 1. Add the second product to the cart
            // 2. Open the cart page
            // 3. Verify both products and their prices, quantities,
            //    and total prices

        } finally {
            // Step 9: Close the browser after the test finishes,
            // even if an exception occurs during execution
            driver.quit();
        }
    }
}
