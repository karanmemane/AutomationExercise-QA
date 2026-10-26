
package com.karan.automation.tests;

// Import Selenium classes for browser automation
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// Import TestNG classes for assertions and test execution
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterWithExistingEmailTest {

    // TestNG uses @Test to identify and execute this test method
    @Test
    public void testRegisterWithExistingEmail() {

        // Create a new Chrome browser session
        WebDriver driver = new ChromeDriver();

        try {
            // Step 1: Open the login page containing the signup form
            driver.get("https://www.automationexercise.com/login");

            // Step 2: Locate the new user name field using XPath
            By newUserName = By.xpath("//*[@id='form']/div/div/div[3]/div/form/input[2]");

            // Enter a name in the signup form
            driver.findElement(newUserName).sendKeys("Xiao Pilat");

            // Step 3: Locate the email field in the signup form
            By emailField = By.xpath(
                "//*[@id='form']/div/div/div[3]/div/form/input[3]"
            );

            // Enter an email address that is already registered
            driver.findElement(emailField).sendKeys("pilat76282@37xiao.com");

            // Step 4: Locate the Signup button using XPath
            By signUpButton = By.xpath(
                "//*[@id='form']/div/div/div[3]/div/form/button"
            );

            // Click Signup to attempt registration with the existing email
            driver.findElement(signUpButton).click();

            // Step 5: Locate the error message displayed by the application
            By actualMessage = By.xpath(
                "//*[@id=\"form\"]/div/div/div[3]/div/form/p"
            );

            // Step 6: Verify that the actual error message matches the expected message
            // The test fails if the messages are different
            Assert.assertEquals(
                driver.findElement(actualMessage).getText(),
                "Email Address already exist!"
            );

        } finally {
            // Step 7: Close the browser, even if the test fails
            driver.quit();
        }
    }
}
