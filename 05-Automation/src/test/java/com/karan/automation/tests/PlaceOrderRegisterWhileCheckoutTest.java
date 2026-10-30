
package com.karan.automation.tests;

import java.time.Duration;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaceOrderRegisterWhileCheckoutTest {

    @Test
    public void placeOrderRegisterWhileCheckout() {

        // Step 1: Launch the Chrome browser
        ChromeDriver driver = new ChromeDriver();

        // Create an explicit wait with a maximum timeout of 20 seconds
        WebDriverWait wait = new WebDriverWait(
            driver, Duration.ofSeconds(20)
        );

        // Generate a unique email address for every test execution
        String email = "karan"
                + UUID.randomUUID().toString().substring(0, 8)
                + "@example.com";

        String password = "Test@12345";

        try {

            // Step 2: Maximize the browser window
            driver.manage().window().maximize();

            // Step 3: Navigate to the Automation Exercise home page
            driver.get("https://www.automationexercise.com/");

            // Step 4: Verify that the home page is displayed
            By homePageLogo = By.xpath("//div[@class='logo pull-left']");

            Assert.assertTrue(
                wait.until(
                    ExpectedConditions.visibilityOfElementLocated(homePageLogo)
                ).isDisplayed(),
                "Home page is not displayed"
            );

            // Step 5: Add the first product to the cart
            By addCartButton = By.xpath(
                "(//a[contains(@class,'add-to-cart')])[1]"
            );

            WebElement addProduct = wait.until(
                ExpectedConditions.presenceOfElementLocated(addCartButton)
            );

            // Scroll the product button into the visible area
            ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript(
                    "arguments[0].scrollIntoView({block:'center'});",
                    addProduct
                );

            // Wait until the Add to Cart button is clickable
            wait.until(
                ExpectedConditions.elementToBeClickable(addProduct)
            ).click();

            // Step 6: Click Continue Shopping in the confirmation modal
            By continueShopping = By.xpath(
                "//*[@id='cartModal']//button[contains(text(),'Continue Shopping')]"
            );

            wait.until(
                ExpectedConditions.elementToBeClickable(continueShopping)
            ).click();

            // Step 7: Navigate to the Cart page
            By cartNavigation = By.xpath(
                "//a[@href='/view_cart']"
            );

            wait.until(
                ExpectedConditions.elementToBeClickable(cartNavigation)
            ).click();

            // Step 8: Verify that the cart page is displayed
            Assert.assertTrue(
                driver.getCurrentUrl().contains("/view_cart"),
                "Cart page was not opened"
            );

            // Step 9: Verify that a product is present in the cart
            By cartProduct = By.xpath(
                "//*[@id='cart_info_table']//tr[contains(@id,'product-')]"
            );

            Assert.assertTrue(
                wait.until(
                    ExpectedConditions.visibilityOfElementLocated(cartProduct)
                ).isDisplayed(),
                "Product is not displayed in the cart"
            );

            // Step 10: Click Proceed To Checkout
            By proceedCheckout = By.xpath(
                "//a[contains(text(),'Proceed To Checkout')]"
            );

            wait.until(
                ExpectedConditions.elementToBeClickable(proceedCheckout)
            ).click();

            // Step 11: Verify that the checkout modal is displayed
            By checkoutModal = By.id("checkoutModal");

            Assert.assertTrue(
                wait.until(
                    ExpectedConditions.visibilityOfElementLocated(checkoutModal)
                ).isDisplayed(),
                "Checkout modal was not displayed"
            );

            // Step 12: Click Register / Login inside the checkout modal
            By registerLogin = By.xpath(
                "//div[@class='modal-body']//a[contains(normalize-space(), 'Register / Login')]"
            );

            wait.until(
                ExpectedConditions.elementToBeClickable(registerLogin)
            ).click();

            // Step 13: Verify that the Signup / Login page is displayed
            wait.until(ExpectedConditions.urlContains("/login"));

            Assert.assertTrue(
                driver.getCurrentUrl().contains("/login"),
                "Signup / Login page was not displayed"
            );

            // Step 14: Enter the new user's name and email address
            By signupName = By.xpath(
                "//form[@action='/signup']//input[@name='name']"
            );

            By signupEmail = By.xpath(
                "//form[@action='/signup']//input[@name='email']"
            );

            wait.until(
                ExpectedConditions.visibilityOfElementLocated(signupName)
            ).sendKeys("Karan Test");

            wait.until(
                ExpectedConditions.visibilityOfElementLocated(signupEmail)
            ).sendKeys(email);

            // Step 15: Click the Signup button
            By signupButton = By.xpath(
                "//form[@action='/signup']//button[@type='submit']"
            );

            wait.until(
                ExpectedConditions.elementToBeClickable(signupButton)
            ).click();

            // Step 16: Verify that the Account Information page is displayed
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

            // Step 17: Fill the account information
            wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                    By.id("password")
                )
            ).sendKeys(password);

            driver.findElement(By.id("first_name")).sendKeys("Karan");
            driver.findElement(By.id("last_name")).sendKeys("Test");
            driver.findElement(By.id("address1"))
                .sendKeys("Flat 190, XYZ Street");

            // Select India from the country dropdown
            Select countryDropdown = new Select(
                driver.findElement(By.id("country"))
            );
            countryDropdown.selectByVisibleText("India");

            driver.findElement(By.id("state")).sendKeys("Maharashtra");
            driver.findElement(By.id("city")).sendKeys("Pune");
            driver.findElement(By.id("zipcode")).sendKeys("411047");
            driver.findElement(By.id("mobile_number")).sendKeys("9112345678");

            // Step 18: Click Create Account
            By createAccountButton = By.xpath(
                "//button[contains(text(),'Create Account')]"
            );

            wait.until(
                ExpectedConditions.elementToBeClickable(createAccountButton)
            ).click();

            // Step 19: Verify Account Created message
            By accountCreatedMessage = By.xpath(
                "//b[contains(text(),'Account Created!')]"
            );

            Assert.assertTrue(
                wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                        accountCreatedMessage
                    )
                ).isDisplayed(),
                "Account was not created successfully"
            );

            // Step 20: Click Continue after account creation
            By continueButton = By.xpath(
                "//a[contains(text(),'Continue')]"
            );

            wait.until(
                ExpectedConditions.elementToBeClickable(continueButton)
            ).click();

            // Step 21: Verify that the user is logged in
            By loggedInMessage = By.xpath(
                "//a[contains(.,'Logged in as')]"
            );

            Assert.assertTrue(
                wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                        loggedInMessage
                    )
                ).getText().contains("Karan Test"),
                "User is not logged in"
            );

            // Step 22: Navigate back to the Cart page
            wait.until(
                ExpectedConditions.elementToBeClickable(cartNavigation)
            ).click();

            // Step 23: Click Proceed To Checkout again
            wait.until(
                ExpectedConditions.elementToBeClickable(proceedCheckout)
            ).click();

            // Step 24: Verify the delivery address section
            By deliveryAddress = By.id("address_delivery");

            Assert.assertTrue(
                wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                        deliveryAddress
                    )
                ).isDisplayed(),
                "Delivery address is not displayed"
            );

            // Step 25: Verify the order review section
            By orderReview = By.id("cart_info");

            Assert.assertTrue(
                wait.until(
                    ExpectedConditions.visibilityOfElementLocated(orderReview)
                ).isDisplayed(),
                "Order review is not displayed"
            );

            // Step 26: Enter a comment in the order description field
            By orderComment = By.name("message");

            wait.until(
                ExpectedConditions.visibilityOfElementLocated(orderComment)
            ).sendKeys("Please deliver the order carefully.");

            // Step 27: Click Place Order
            By placeOrder = By.xpath(
                "//a[contains(text(),'Place Order')]"
            );

            wait.until(
                ExpectedConditions.elementToBeClickable(placeOrder)
            ).click();

            // Step 28: Enter payment details
            wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                    By.name("name_on_card")
                )
            ).sendKeys("Karan Test");

            driver.findElement(By.name("card_number"))
                .sendKeys("4111111111111111");

            driver.findElement(By.name("cvc")).sendKeys("123");
            driver.findElement(By.name("expiry_month")).sendKeys("12");
            driver.findElement(By.name("expiry_year")).sendKeys("2030");

            // Step 29: Click Pay and Confirm Order
            By payButton = By.id("submit");

            wait.until(
                ExpectedConditions.elementToBeClickable(payButton)
            ).click();

            // Step 30: Verify successful order confirmation
            By orderConfirmation = By.xpath(
                "//*[contains(text(),'Congratulations! Your order has been confirmed!')]"
            );

            Assert.assertTrue(
                wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                        orderConfirmation
                    )
                ).isDisplayed(),
                "Order confirmation message was not displayed"
            );

            // Step 31: Click Delete Account
            By deleteAccount = By.xpath(
                "//a[contains(text(),'Delete Account')]"
            );

            wait.until(
                ExpectedConditions.elementToBeClickable(deleteAccount)
            ).click();

            // Step 32: Verify Account Deleted message
            By accountDeletedMessage = By.xpath(
                "//b[contains(text(),'Account Deleted!')]"
            );

            Assert.assertTrue(
                wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                        accountDeletedMessage
                    )
                ).isDisplayed(),
                "Account deletion was not successful"
            );

            // Step 33: Click Continue after account deletion
            wait.until(
                ExpectedConditions.elementToBeClickable(continueButton)
            ).click();

        } finally {

            // Step 34: Close the browser after test execution
            // This executes even if the test fails
            driver.quit();
        }
    }
}
