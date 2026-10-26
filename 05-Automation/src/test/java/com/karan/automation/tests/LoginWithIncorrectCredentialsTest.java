
package com.karan.automation.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginWithIncorrectCredentialsTest {

    @Test
    public void testLoginWithIncorrectCredentials() {

        WebDriver driver = new ChromeDriver();

        try {
            // Step 1: Open the login page
            driver.get("https://www.automationexercise.com/login");

            // Step 2: Verify the page title and URL
            Assert.assertEquals(
                driver.getTitle(), "Automation Exercise - Signup / Login"
            );

            Assert.assertEquals(
                driver.getCurrentUrl(),
                "https://www.automationexercise.com/login"
            );

            // Step 3: Verify the login heading
            By heading = By.xpath(
                "//*[@id='form']/div/div/div[1]/div/h2"
            );

            Assert.assertTrue(
                driver.findElement(heading).isDisplayed(),
                "Login heading is not displayed"
            );

            // Step 4: Enter an incorrect email
            By emailField = By.xpath(
                "//*[@id='form']/div/div/div[1]/div/form/input[2]"
            );

            driver.findElement(emailField)
                  .sendKeys("incorrect_email@example.com");

            // Step 5: Enter an incorrect password
            By passwordField = By.xpath(
                "//*[@id='form']/div/div/div[1]/div/form/input[3]"
            );

            driver.findElement(passwordField)
                  .sendKeys("incorrect_password");

            // Step 6: Click the Login button
            By loginButton = By.xpath(
                "//*[@id='form']/div/div/div[1]/div/form/button"
            );

            driver.findElement(loginButton).click();

            // Step 7: Verify the error message
            By errorMessage = By.xpath(
                "//*[@id='form']/div/div/div[1]/div/form/p"
            );

            WebElement error = driver.findElement(errorMessage);

            Assert.assertTrue(
                error.isDisplayed(),
                "Login error message is not displayed"
            );

            Assert.assertEquals(
                error.getText().trim(),
                "Your email or password is incorrect!",
                "Unexpected login error message"
            );

            System.out.println("Login error: " + error.getText());

        } finally {
            // Step 8: Close the browser
            driver.quit();
        }
    }
}
