
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

public class SearchProductsAndVerifyCartAfterLogin {

    @Test
    public void searchProductsAndVerifyCartAfterLogin() {

        WebDriver driver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(
                driver, Duration.ofSeconds(15));

        try {

            // 1. Navigate to Automation Exercise
            driver.manage().window().maximize();
            driver.get("https://www.automationexercise.com");

            // 2. Verify homepage
            Assert.assertTrue(
                    driver.getTitle().contains("Automation Exercise"),
                    "Homepage is not displayed");

            System.out.println("Homepage displayed successfully.");

            // 3. Click Products
            driver.findElement(
                    By.xpath("//*[@id='header']/div/div/div/div[2]/div/ul/li[2]/a")
            ).click();

            // 4. Verify All Products page
            WebElement allProductsHeading = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.xpath("//h2[normalize-space()='All Products']")
                    )
            );

            Assert.assertTrue(allProductsHeading.isDisplayed(),
                    "All Products page is not displayed");

            System.out.println("All Products page displayed successfully.");

            // 5. Search for product
            WebElement searchBox = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.id("search_product")
                    )
            );

            searchBox.sendKeys("tshirt");

            driver.findElement(By.id("submit_search")).click();

            // 6. Verify Search Results

// Wait for the search page URL to change or remain on the products page
wait.until(ExpectedConditions.urlContains("products"));

System.out.println("Current URL: " + driver.getCurrentUrl());

// Wait for page heading elements
By headings = By.cssSelector("h2.title");

wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(headings));

// Print actual heading text
for (WebElement heading : driver.findElements(headings)) {

    System.out.println(
            "Actual heading: [" + heading.getText() + "]"
    );
}

// Print search results count
By searchResults = By.cssSelector(
        ".features_items .product-image-wrapper"
);

System.out.println(
        "Product cards found: " +
        driver.findElements(searchResults).size()
);

            // 7. Get the first searched product
            By firstProduct = By.cssSelector(
                    ".features_items .product-image-wrapper"
            );

            WebElement productCard = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            firstProduct
                    )
            );

            // Get product name
            String productName = productCard.findElement(
                    By.cssSelector(".productinfo p")
            ).getText().trim();

            Assert.assertFalse(productName.isEmpty(),
                    "Product name is empty");

            System.out.println("Searched product: " + productName);

            // 8. Add first searched product to cart
            WebElement addToCartButton = productCard.findElement(
                    By.cssSelector("a.add-to-cart")
            );

            // Scroll button into the center of the screen
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].scrollIntoView({block: 'center'});",
                    addToCartButton
            );

            // Wait until button is clickable
            wait.until(
                    ExpectedConditions.elementToBeClickable(
                            addToCartButton
                    )
            );

            // Diagnose any element covering the button
            WebElement elementAtClickPoint = (WebElement)
                    ((JavascriptExecutor) driver).executeScript(
                            "var r = arguments[0].getBoundingClientRect();" +
                            "return document.elementFromPoint(" +
                            "r.left + r.width/2, r.top + r.height/2);",
                            addToCartButton
                    );

            System.out.println(
                    "Element covering button: "
                            + elementAtClickPoint.getTagName()
            );

            // Normal Selenium click
            addToCartButton.click();

            System.out.println("Product added to cart.");

            // 9. Open View Cart from modal
            WebElement viewCartButton = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath(
                                    "//*[@id='cartModal']//a[contains(@href,'view_cart')]"
                            )
                    )
            );

            viewCartButton.click();

            // 10. Verify product in cart before login
            By cartProduct = By.cssSelector(
                    "#cart_info_table tbody tr td.cart_description a"
            );

            WebElement productInCart = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            cartProduct
                    )
            );

            String cartProductName = productInCart.getText().trim();

            // Normalize the product name for comparison
            String normalizedProductName = productName
                    .replaceAll("\\s+", " ")
                    .replaceAll("T-Shirts$", "")
                    .trim();

            String normalizedCartProductName = cartProductName
                    .replaceAll("\\s+", " ")
                    .trim();

            Assert.assertEquals(
                    normalizedCartProductName,
                    normalizedProductName,
                    "Product is not correctly displayed in cart"
            );

            System.out.println(
                    "Product verified in cart before login: "
                            + cartProductName
            );

            // 11. Click Signup / Login
            driver.findElement(
                    By.xpath("//*[@id='header']/div/div/div/div[2]/div/ul/li[4]/a")
            ).click();

            // 12. Enter login credentials
            // Replace placeholders with your test account credentials.
            driver.findElement(By.name("email"))
                    .sendKeys("pilat76282@37xiao.com");

            driver.findElement(By.name("password"))
                    .sendKeys("@3m5jeQKHJpt4F");

            driver.findElement(
                    By.xpath("//*[@id='form']/div/div/div[1]/div/form/button")
            ).click();

            // 13. Verify successful login
            WebElement loggedInUser = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.xpath(
                                    "//a[.//b[normalize-space()='Xiao Pilat']]"
                            )
                    )
            );

            Assert.assertTrue(loggedInUser.isDisplayed(),
                    "Login was unsuccessful");

            System.out.println("Login successful.");

            // 14. Open cart again
            driver.findElement(
                    By.xpath("//a[@href='/view_cart']")
            ).click();

            // 15. Verify product remains in cart after login
            WebElement productAfterLogin = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            cartProduct
                    )
            );

            String productNameAfterLogin =
                    productAfterLogin.getText().trim();

            Assert.assertEquals(
                    productNameAfterLogin.replaceAll("\\s+", " ").trim(),
                    normalizedProductName,
                    "Product is not retained in cart after login"
            );

            System.out.println(
                    "Product successfully verified in cart after login."
            );

            System.out.println(
                    "TEST CASE 20 PASSED SUCCESSFULLY."
            );

        } finally {

            // 16. Close browser
            driver.quit();
        }
    }
}
