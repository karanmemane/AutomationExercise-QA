
package com.karan.automation.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Account page locators
    private By accountCreatedHeading =
        By.cssSelector("[data-qa='account-created']");

    private By continueButton =
        By.linkText("Continue");

    private By deleteAccountButton =
        By.xpath("//a[contains(., 'Delete Account')]");

    private By accountDeletedHeading =
        By.cssSelector("[data-qa='account-deleted']");

    // Constructor
    public AccountPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Verify account created
    public boolean isAccountCreated() {
        try {
            return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                    accountCreatedHeading
                )
            ).isDisplayed();

        } catch (TimeoutException e) {
            return false;
        }
    }

    // Click Continue
    public void clickContinueButton() {
        wait.until(
            ExpectedConditions.elementToBeClickable(continueButton)
        ).click();
    }

    // Verify logged-in username
    public boolean isLoggedInAsUser(String username) {

        By loggedInUser = By.xpath(
            "//a[contains(normalize-space(.), 'Logged in as') " +
            "and .//b[normalize-space()='" + username + "']]"
        );

        try {
            return wait.until(
                ExpectedConditions.visibilityOfElementLocated(loggedInUser)
            ).isDisplayed();

        } catch (TimeoutException e) {
            return false;
        }
    }

    // Click Delete Account
    public void clickDeleteAccount() {
        wait.until(
            ExpectedConditions.elementToBeClickable(deleteAccountButton)
        ).click();
    }

    // Verify account deleted
    public boolean isAccountDeleted() {
        try {
            return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                    accountDeletedHeading
                )
            ).isDisplayed();

        } catch (TimeoutException e) {
            return false;
        }
    }
}
