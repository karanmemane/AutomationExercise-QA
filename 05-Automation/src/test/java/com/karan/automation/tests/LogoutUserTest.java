
package com.karan.automation.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutUserTest {

    @Test
    public void testLogoutUser() {

        // Open the browser
        WebDriver driver = new ChromeDriver();

        try {
            // Step 1: Open the login page
            driver.get("https://www.automationexercise.com/login");

            // Step 2: Enter your registered email
            By emailField = By.xpath(
                "//*[@id='form']/div/div/div[1]/div/form/input[2]"
            );
            driver.findElement(emailField).sendKeys("pilat76282@37xiao.com");

            // Step 3: Enter your registered password
            By passwordField = By.xpath(
                "//*[@id='form']/div/div/div[1]/div/form/input[3]"
            );
            driver.findElement(passwordField).sendKeys("@3m5jeQKHJpt4F");

            // Step 4: Click Login
            By loginButton = By.xpath(
                "//*[@id='form']/div/div/div[1]/div/form/button"
            );
            driver.findElement(loginButton).click();

            // Step 5: Verify the user logged in
            By loggedInText = By.xpath(
                "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a"
            );

            Assert.assertTrue(
                driver.findElement(loggedInText).isDisplayed(),
                "User login was unsuccessful"
            );

            // Step 6: Click Logout
            By logoutButton = By.xpath(
                "//*[@id='header']/div/div/div/div[2]/div/ul/li[4]/a"
            );
            driver.findElement(logoutButton).click();

            // Step 7: Verify the login page appears
            By loginPageHeading = By.xpath(
                "//*[@id='form']/div/div/div[1]/div/h2"
            );

            Assert.assertTrue(
                driver.findElement(loginPageHeading).isDisplayed(),
                "Login page heading is not displayed after logout"
            );

            System.out.println("Logout test passed!");

        } finally {
            // Always close the browser
            driver.quit();
        }
    }
}
