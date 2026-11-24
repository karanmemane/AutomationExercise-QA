
package com.karan.automation.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Login form locators
    private By loginHeading =
        By.xpath("//h2[normalize-space()='Login to your account']");

    private By emailField =
        By.cssSelector("[data-qa='login-email']");

    private By passwordField =
        By.cssSelector("[data-qa='login-password']");

    private By loginButton =
        By.cssSelector("[data-qa='login-button']");

    private By loginErrorMessage =
        By.xpath("//p[normalize-space()='Your email or password is incorrect!']");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Verify Login heading
    public boolean isLoginHeadingVisible() {
        try {
            return wait.until(
                ExpectedConditions.visibilityOfElementLocated(loginHeading)
            ).isDisplayed();

        } catch (TimeoutException e) {
            return false;
        }
    }

    // Enter existing user's email
    public void enterLoginEmail(String email) {
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(emailField)
        ).sendKeys(email);
    }

    // Enter existing user's password
    public void enterLoginPassword(String password) {
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(passwordField)
        ).sendKeys(password);
    }

    // Click Login button
    public void clickLoginButton() {
        wait.until(
            ExpectedConditions.elementToBeClickable(loginButton)
        ).click();
    }

    // Verify invalid login error
    public boolean isLoginErrorVisible() {
        try {
            return wait.until(
                ExpectedConditions.visibilityOfElementLocated(loginErrorMessage)
            ).isDisplayed();

        } catch (TimeoutException e) {
            return false;
        }
    }
}
