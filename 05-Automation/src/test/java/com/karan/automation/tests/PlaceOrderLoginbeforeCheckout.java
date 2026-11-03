
package com.karan.automation.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaceOrderLoginbeforeCheckout {

    @Test
    public void placeOrderLoginBeforeCheckout() {

        System.out.println("Test Case 16: Place Order - Login before Checkout");

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(
                driver, Duration.ofSeconds(30)
        );

        try {

            // 1. Launch browser
            driver.manage().window().maximize();
            driver.get("https://www.automationexercise.com/");

            // 2. Verify homepage
            Assert.assertTrue(
                    driver.getTitle().contains("Automation Exercise"),
                    "Homepage is not displayed."
            );

            System.out.println("Homepage displayed successfully.");

            // 3. Click Signup / Login
            By login = By.xpath("//a[contains(text(),'Signup / Login')]");

            wait.until(
                    ExpectedConditions.elementToBeClickable(login)
            ).click();

            // 4. Verify login page
            Assert.assertTrue(
                    driver.getCurrentUrl().contains("/login"),
                    "Login page is not displayed."
            );

            System.out.println("Successfully navigated to login page.");

            // 5. Enter login credentials
            By email = By.name("email");
            By password = By.name("password");

            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(email)
            ).sendKeys("pilat76282@37xiao.com");

            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(password)
            ).sendKeys("@3m5jeQKHJpt4F");

            By loginButton = By.xpath(
                    "//button[@data-qa='login-button']"
            );

            wait.until(
                    ExpectedConditions.elementToBeClickable(loginButton)
            ).click();

            // 6. Verify logged-in username
            By loginAsUser = By.xpath(
                    "//a[contains(.,'Logged in as')]/b"
            );

            WebElement loggedInUser = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(loginAsUser)
            );

            Assert.assertEquals(
                    loggedInUser.getText(),
                    "Xiao Pilat",
                    "Logged-in username does not match."
            );

            System.out.println("User logged in successfully.");

            // 7. Navigate to Products
            By products = By.xpath("//a[@href='/products']");

            wait.until(
                    ExpectedConditions.elementToBeClickable(products)
            ).click();

            // 8. Hover over first product
            By productCard = By.xpath(
                    "(//div[@class='product-image-wrapper'])[1]"
            );

            WebElement firstProduct = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(productCard)
            );

            Actions actions = new Actions(driver);
            actions.moveToElement(firstProduct).perform();

            // 9. Locate Add to Cart button
            By addToCart = By.xpath(
                    "(//a[contains(@class,'add-to-cart')])[1]"
            );

            WebElement addToCartButton = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(addToCart)
            );

            // Scroll button into view
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].scrollIntoView({block: 'center'});",
                    addToCartButton
            );

            // 10. Check advertisement iframe visibility
            By advertisement = By.xpath(
                    "//iframe[@title='Advertisement']"
            );

            long visibleAds = driver.findElements(advertisement)
                    .stream()
                    .filter(WebElement::isDisplayed)
                    .count();

            System.out.println(
                    "Visible advertisement iframes: " + visibleAds
            );

            // 11. Check which element is receiving the click
            String elementAtPoint = (String)
                    ((JavascriptExecutor) driver).executeScript(
                            "var r = arguments[0].getBoundingClientRect();" +
                            "return document.elementFromPoint(" +
                            "r.left + r.width / 2, " +
                            "r.top + r.height / 2).outerHTML;",
                            addToCartButton
                    );

            System.out.println(
                    "Element receiving click: " + elementAtPoint
            );

            // 12. Click Add to Cart normally
            wait.until(
                    ExpectedConditions.elementToBeClickable(addToCart)
            ).click();

            System.out.println("Product added to cart.");

            // 13. Click View Cart
            By viewCart = By.xpath("//a[@href='/view_cart']");

            wait.until(
                    ExpectedConditions.elementToBeClickable(viewCart)
            ).click();

            // 14. Verify cart page
            Assert.assertTrue(
                    driver.getCurrentUrl().contains("view_cart"),
                    "Cart page is not displayed."
            );

            System.out.println("Cart page displayed successfully.");

            // 15. Proceed to Checkout
            By proceedToCheckout = By.xpath(
                    "//a[contains(text(),'Proceed To Checkout')]"
            );

            wait.until(
                    ExpectedConditions.elementToBeClickable(proceedToCheckout)
            ).click();

            // 16. Verify address and order review
            By addressDetails = By.xpath(
                    "//h2[contains(text(),'Address Details')]"
            );

            By reviewOrder = By.xpath(
                    "//h2[contains(text(),'Review Your Order')]"
            );

            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(addressDetails)
            );

            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(reviewOrder)
            );

            System.out.println(
                    "Address details and order review displayed."
            );

            // 17. Enter order comment
            By comment = By.name("message");

            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(comment)
            ).sendKeys("Please process my order.");

            // 18. Click Place Order
            By placeOrder = By.xpath(
                    "//a[contains(text(),'Place Order')]"
            );

            wait.until(
                    ExpectedConditions.elementToBeClickable(placeOrder)
            ).click();

            // 19. Enter payment details
            By nameOnCard = By.name("name_on_card");
            By cardNumber = By.name("card_number");
            By cvc = By.name("cvc");
            By expiryMonth = By.name("expiry_month");
            By expiryYear = By.name("expiry_year");

            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(nameOnCard)
            ).sendKeys("Xiao Pilat");

            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(cardNumber)
            ).sendKeys("4111111111111111");

            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(cvc)
            ).sendKeys("123");

            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(expiryMonth)
            ).sendKeys("12");

            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(expiryYear)
            ).sendKeys("2030");

            // 20. Pay and Confirm Order
            By payAndConfirmOrder = By.id("submit");

            wait.until(
                    ExpectedConditions.elementToBeClickable(payAndConfirmOrder)
            ).click();

            // 21. Verify order confirmation
            By orderPlaced = By.xpath(
                    "//*[contains(text(),'Congratulations! Your order has been confirmed!')]"
            );

            WebElement confirmationMessage = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(orderPlaced)
            );

            Assert.assertTrue(
                    confirmationMessage.isDisplayed(),
                    "Order confirmation message is not displayed."
            );

            System.out.println("Order placed successfully.");

            // 22. Delete Account
            By deleteAccount = By.xpath(
                    "//a[contains(text(),'Delete Account')]"
            );

            wait.until(
                    ExpectedConditions.elementToBeClickable(deleteAccount)
            ).click();

            // 23. Verify account deletion
            By accountDeleted = By.xpath(
                    "//b[contains(text(),'Account Deleted!')]"
            );

            WebElement deletionMessage = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(accountDeleted)
            );

            Assert.assertTrue(
                    deletionMessage.isDisplayed(),
                    "Account deletion confirmation is not displayed."
            );

            System.out.println("Account deleted successfully.");

            // 24. Click Continue
            By continueButton = By.xpath(
                    "//a[@data-qa='continue-button']"
            );

            wait.until(
                    ExpectedConditions.elementToBeClickable(continueButton)
            ).click();

            System.out.println("Test Case 16 completed successfully.");

        } finally {

            // Close browser
            driver.quit();
        }
    }
}
