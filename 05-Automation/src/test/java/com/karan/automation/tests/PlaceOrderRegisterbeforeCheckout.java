
package com.karan.automation.tests;

import java.time.Duration;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaceOrderRegisterbeforeCheckout {

    @Test
    public void testPlaceOrderRegisterBeforeCheckout() {

        // Step 1: Launch Chrome browser
        WebDriver driver = new ChromeDriver();

        // Create explicit wait
        WebDriverWait wait = new WebDriverWait(
            driver, Duration.ofSeconds(20)
        );

        // Generate a unique email for every execution
        String email = "karan"
                + UUID.randomUUID().toString().substring(0, 8)
                + "@example.com";

        String password = "SecurePassword123";

        try {

            // Step 2: Maximize browser window
            driver.manage().window().maximize();

            // Step 3: Navigate to the application
            driver.get("https://www.automationexercise.com/");

            // Step 4: Verify home page
            By homePageLogo = By.xpath("//div[@class='logo pull-left']");

            Assert.assertTrue(
                wait.until(
                    ExpectedConditions.visibilityOfElementLocated(homePageLogo)
                ).isDisplayed(),
                "Home page is not displayed"
            );

            // Step 5: Click Signup / Login
            By signupLoginButton = By.xpath(
                "//a[contains(text(),'Signup / Login')]"
            );

            wait.until(
                ExpectedConditions.elementToBeClickable(signupLoginButton)
            ).click();

            // Step 6: Enter name and email
            By nameField = By.xpath(
                "//form[@action='/signup']//input[@name='name']"
            );

            By emailField = By.xpath(
                "//form[@action='/signup']//input[@name='email']"
            );

            wait.until(
                ExpectedConditions.visibilityOfElementLocated(nameField)
            ).sendKeys("John Doe");

            wait.until(
                ExpectedConditions.visibilityOfElementLocated(emailField)
            ).sendKeys(email);

            // Step 7: Click Signup
            By signupButton = By.xpath(
                "//form[@action='/signup']//button[@type='submit']"
            );

            wait.until(
                ExpectedConditions.elementToBeClickable(signupButton)
            ).click();

            // Step 8: Verify Account Information page
            By accountInformation = By.xpath(
                "//b[contains(text(),'Enter Account Information')]"
            );

            Assert.assertTrue(
                wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                        accountInformation
                    )
                ).isDisplayed(),
                "Account Information page was not displayed"
            );

            // Step 9: Fill account information
            driver.findElement(By.id("id_gender1")).click();

            driver.findElement(By.id("password")).sendKeys(password);

            // Select date of birth
            Select day = new Select(driver.findElement(By.id("days")));
            day.selectByValue("4");

            Select month = new Select(driver.findElement(By.id("months")));
            month.selectByValue("2");

            Select year = new Select(driver.findElement(By.id("years")));
            year.selectByValue("2000");

            // Select newsletter checkbox
            // Select Newsletter checkbox
WebElement newsletter = wait.until(
    ExpectedConditions.presenceOfElementLocated(
        By.id("newsletter")
    )
);

// JavaScript fallback because the advertisement blocks normal clicking
if (!newsletter.isSelected()) {
    ((JavascriptExecutor) driver).executeScript(
        "arguments[0].click();",
        newsletter
    );
}

// Verify checkbox is selected
Assert.assertTrue(
    newsletter.isSelected(),
    "Newsletter checkbox should be selected"
);

            // Select special offers checkbox
            WebElement offers = driver.findElement(By.id("optin"));

            if (!offers.isSelected()) {
                offers.click();
            }

            // Enter address details
            driver.findElement(By.id("first_name")).sendKeys("John");
            driver.findElement(By.id("last_name")).sendKeys("Doe");
            driver.findElement(By.id("company")).sendKeys("Example Inc.");
            driver.findElement(By.id("address1"))
                .sendKeys("123 Main Street");
            driver.findElement(By.id("address2")).sendKeys("Apt 4B");

            // Select country
            Select country = new Select(
                driver.findElement(By.id("country"))
            );
            country.selectByVisibleText("India");

            driver.findElement(By.id("state")).sendKeys("Maharashtra");
            driver.findElement(By.id("city")).sendKeys("Pune");
            driver.findElement(By.id("zipcode")).sendKeys("411047");
            driver.findElement(By.id("mobile_number"))
                .sendKeys("9112345678");

            // Step 10: Click Create Account
            By createAccountButton = By.xpath(
                "//button[contains(text(),'Create Account')]"
            );

            wait.until(
                ExpectedConditions.elementToBeClickable(createAccountButton)
            ).click();

            // Step 11: Verify Account Created message
            By accountCreatedMessage = By.xpath(
                "//b[contains(text(),'Account Created!')]"
            );

            Assert.assertTrue(
                wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                        accountCreatedMessage
                    )
                ).isDisplayed(),
                "Account creation failed"
            );

            // Step 12: Click Continue
            By continueButton = By.xpath(
                "//a[contains(text(),'Continue')]"
            );

            wait.until(
                ExpectedConditions.elementToBeClickable(continueButton)
            ).click();

            // Step 13: Verify Logged in as username
            // Step: Verify logged-in username
        // Step: Verify logged-in username
By loggedInUser = By.xpath(
    "//a[contains(.,'Logged in as')]/b"
);

WebElement user = wait.until(
    ExpectedConditions.visibilityOfElementLocated(loggedInUser)
);

Assert.assertEquals(user.getText(), "John Doe");

            // Step 14: Add first product to cart
            By addToCartButton = By.xpath(
    "(/html/body/section[2]/div/div/div[2]/div[1]/div[2]/div/div[1]/div[2]/div/a)"
            );

            WebElement addProduct = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                    addToCartButton
                )
            );

            // Scroll product button into view
            ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                addProduct
            );

            wait.until(
                ExpectedConditions.elementToBeClickable(addProduct)
            ).click();

            // Step 15: Click Continue Shopping
            By continueShopping = By.xpath(
                "//*[@id='cartModal']//button[contains(text(),'Continue Shopping')]"
            );

            wait.until(
                ExpectedConditions.elementToBeClickable(continueShopping)
            ).click();

            // Step 16: Click Cart
            By cartButton = By.xpath(
                "//a[@href='/view_cart']"
            );

            wait.until(
                ExpectedConditions.elementToBeClickable(cartButton)
            ).click();

            // Step 17: Verify Cart page
            Assert.assertTrue(
                driver.getCurrentUrl().contains("/view_cart"),
                "Cart page was not displayed"
            );

            // Verify product is present in cart
            By cartProduct = By.xpath(
                "//*[@id='cart_info_table']//tr[contains(@id,'product-')]"
            );

            Assert.assertTrue(
                wait.until(
                    ExpectedConditions.visibilityOfElementLocated(cartProduct)
                ).isDisplayed(),
                "Product is not present in cart"
            );

            // Step 18: Click Proceed To Checkout
            By checkoutButton = By.xpath(
                "//a[contains(text(),'Proceed To Checkout')]"
            );

            wait.until(
                ExpectedConditions.elementToBeClickable(checkoutButton)
            ).click();

            // Step 19: Verify Delivery Address
            By deliveryAddress = By.id("address_delivery");

            Assert.assertTrue(
                wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                        deliveryAddress
                    )
                ).isDisplayed(),
                "Delivery address is not displayed"
            );

            // Step 20: Verify Review Your Order
            By orderReview = By.id("cart_info");

            Assert.assertTrue(
                wait.until(
                    ExpectedConditions.visibilityOfElementLocated(orderReview)
                ).isDisplayed(),
                "Order review is not displayed"
            );

            // Step 21: Enter order comment
            By commentBox = By.name("message");

            wait.until(
                ExpectedConditions.visibilityOfElementLocated(commentBox)
            ).sendKeys("Please deliver the order carefully.");

            // Step 22: Click Place Order
            By placeOrderButton = By.xpath(
                "//a[contains(text(),'Place Order')]"
            );

            wait.until(
                ExpectedConditions.elementToBeClickable(placeOrderButton)
            ).click();

            // Step 23: Enter payment details
            wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                    By.name("name_on_card")
                )
            ).sendKeys("John Doe");

            driver.findElement(By.name("card_number"))
                .sendKeys("4111111111111111");

            driver.findElement(By.name("cvc")).sendKeys("123");
            driver.findElement(By.name("expiry_month")).sendKeys("12");
            driver.findElement(By.name("expiry_year")).sendKeys("2030");

            // Step 24: Click Pay and Confirm Order
            By payAndConfirmOrderButton = By.id("submit");

            wait.until(
                ExpectedConditions.elementToBeClickable(
                    payAndConfirmOrderButton
                )
            ).click();

            // Step 25: Verify order confirmation message
            By orderPlacedMessage = By.xpath(
                "//*[contains(text(),'Congratulations! Your order has been confirmed!')]"
            );

            Assert.assertTrue(
                wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                        orderPlacedMessage
                    )
                ).isDisplayed(),
                "Order placement failed"
            );

            // Step 26: Click Delete Account
            By deleteAccountButton = By.xpath(
                "//a[contains(text(),'Delete Account')]"
            );

            wait.until(
                ExpectedConditions.elementToBeClickable(deleteAccountButton)
            ).click();

            // Step 27: Verify Account Deleted message
            By accountDeletedMessage = By.xpath(
                "//b[contains(text(),'Account Deleted!')]"
            );

            Assert.assertTrue(
                wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                        accountDeletedMessage
                    )
                ).isDisplayed(),
                "Account deletion failed"
            );

            // Step 28: Click Continue after account deletion
            By continueAfterDeleteButton21= By.xpath(
                "//a[contains(text(),'Continue')]"
            );

            wait.until(
                ExpectedConditions.elementToBeClickable(
                    continueAfterDeleteButton21
                )
            ).click();

        // Wait briefly for the page to respond
            wait.until(ExpectedConditions.or(
                ExpectedConditions.urlContains("delete_account"),
                ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(normalize-space(.),'Account Deleted!')]")
            )
            ));

// Print the current page details
System.out.println("URL after Delete Account: " + driver.getCurrentUrl());
System.out.println("Page text after Delete Account:");
System.out.println(driver.findElement(By.tagName("body")).getText());

            By continueAfterDeleteButton211= By.xpath(
                "//a[contains(text(),'Continue')]"
            );

            wait.until(
                ExpectedConditions.elementToBeClickable(
                    continueAfterDeleteButton211
                )
            ).click();

        } finally {

            // Close browser even if the test fails
            driver.quit();
        }
    }
}
