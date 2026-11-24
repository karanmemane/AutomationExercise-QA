
package com.karan.automation.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By signupLoginButton = By.linkText("Signup / Login");
    private By signupButton = By.cssSelector("[data-qa='signup-button']");
    private By newUserSignupHeading = By.xpath("//h2[normalize-space()='New User Signup!']");
    private By accountInformationHeading = By.xpath("//b[normalize-space()='Enter Account Information']");
    private By titleMr = By.id("id_gender1");
    private By titleMrs = By.id("id_gender2");
    private By createAccountButton = By.cssSelector("[data-qa='create-account']");
    private By accountCreatedHeading = By.cssSelector("[data-qa='account-created']");
    private By continueButton = By.linkText("Continue");
    private By deleteAccountButton = By.xpath("//a[contains(., 'Delete Account')]");
    private By accountDeletedHeading = By.xpath("//h2[@data-qa='account-deleted']");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Step 1 and 2: Open website
    public void openHomePage() {
        driver.get("https://automationexercise.com/");
    }

    // Step 3: Verify home page
    public boolean isHomePageVisible() {
        return driver.getTitle().contains("Automation Exercise");
    }

    // Step 4: Click Signup / Login
    public void clickSignupLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(signupLoginButton)).click();
    }

    // Step 5: Verify New User Signup
    public boolean isNewUserSignupVisible() {
        try {
            return wait.until(
                ExpectedConditions.visibilityOfElementLocated(newUserSignupHeading)
            ).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    // Step 6: Enter name and email
    public void registerUserName(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("name")))
            .sendKeys(name);
    }

    public void registerUserEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.cssSelector("[data-qa='signup-email']")
        )).sendKeys(email);
    }

    // Step 7: Click Signup
    public void clickSignupButton() {
        wait.until(ExpectedConditions.elementToBeClickable(signupButton)).click();
    }

    // Step 8: Verify Account Information
    public boolean isAccountInformationVisible() {
        try {
            return wait.until(
                ExpectedConditions.visibilityOfElementLocated(accountInformationHeading)
            ).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    // Step 9: Fill account information
    public void selectTitleMr() {
        wait.until(ExpectedConditions.elementToBeClickable(titleMr)).click();
    }

    public void selectTitleMrs() {
        wait.until(ExpectedConditions.elementToBeClickable(titleMrs)).click();
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")))
            .sendKeys(password);
    }

    public void selectDay(String day) {
        Select select = new Select(
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("days")))
        );
        select.selectByValue(day);
    }

    public void selectMonth(String month) {
        Select select = new Select(
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("months")))
        );
        select.selectByValue(month);
    }

    public void selectYear(String year) {
        Select select = new Select(
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("years")))
        );
        select.selectByValue(year);
    }

    // Step 10 and 11: Select checkboxes
    public void selectNewsletter() {
        clickCheckbox(By.id("newsletter"));
    }

    public void selectSpecialOffers() {
        clickCheckbox(By.id("optin"));
    }

    // Step 12: Fill address information
    public void enterFirstName(String firstName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("first_name")))
            .sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("last_name")))
            .sendKeys(lastName);
    }

    public void enterCompany(String company) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("company")))
            .sendKeys(company);
    }

    public void enterAddress(String address) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("address1")))
            .sendKeys(address);
    }

    public void enterAddress2(String address2) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("address2")))
            .sendKeys(address2);
    }

    public void selectCountry(String country) {
        Select select = new Select(
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("country")))
        );
        select.selectByVisibleText(country);
    }

    public void enterState(String state) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("state")))
            .sendKeys(state);
    }

    public void enterCity(String city) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("city")))
            .sendKeys(city);
    }

    public void enterZipcode(String zipcode) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("zipcode")))
            .sendKeys(zipcode);
    }

    public void enterMobileNumber(String mobileNumber) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mobile_number")))
            .sendKeys(mobileNumber);
    }

    // Step 13: Create account
    public void clickCreateAccountButton() {

        WebElement button = wait.until(
            ExpectedConditions.presenceOfElementLocated(createAccountButton)
        );

        ((JavascriptExecutor) driver).executeScript(
            "arguments[0].scrollIntoView({block: 'center'});",
            button
        );

        try {
            wait.until(ExpectedConditions.elementToBeClickable(createAccountButton)).click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();",
                button
            );
        }
    }

    // Step 14: Verify account created
    public boolean isAccountCreated() {
        try {
            WebElement heading = wait.until(
                ExpectedConditions.visibilityOfElementLocated(accountCreatedHeading)
            );
            return heading.isDisplayed();

        } catch (TimeoutException e) {
            System.out.println("Account created heading was not displayed.");
            System.out.println("Current URL: " + driver.getCurrentUrl());
            System.out.println("Page content:");
            System.out.println(getPageText());
            return false;
        }
    }

    // Step 15: Click Continue
    public void clickContinueButton() {
        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
    }

    // Step 16: Verify logged-in username
    public boolean isLoggedInAsUser(String username) {

        By loggedInUser = By.xpath(
            "//a[contains(normalize-space(.), 'Logged in as') and .//b[normalize-space()='" 
            + username + "']]"
        );

        try {
            return wait.until(
                ExpectedConditions.visibilityOfElementLocated(loggedInUser)
            ).isDisplayed();

        } catch (TimeoutException e) {
            System.out.println("Logged-in username was not displayed.");
            System.out.println("Current URL: " + driver.getCurrentUrl());
            System.out.println("Page content:");
            System.out.println(getPageText());
            return false;
        }
    }

    // Step 17: Click Delete Account
    public void clickDeleteAccount() {
        wait.until(
            ExpectedConditions.elementToBeClickable(deleteAccountButton)
        ).click();
    }

    // Step 18: Verify account deleted
    public boolean isAccountDeleted() {

        try {
            WebElement heading = wait.until(
                ExpectedConditions.visibilityOfElementLocated(accountDeletedHeading)
            );

            return heading.isDisplayed();

        } catch (TimeoutException e) {
            System.out.println("Account deleted heading was not displayed.");
            System.out.println("Current URL: " + driver.getCurrentUrl());
            System.out.println("Page content:");
            System.out.println(getPageText());
            return false;
        }
    }

    // Reusable helper: Click checkboxes
    private void clickCheckbox(By locator) {

        WebElement checkbox = wait.until(
            ExpectedConditions.presenceOfElementLocated(locator)
        );

        ((JavascriptExecutor) driver).executeScript(
            "arguments[0].scrollIntoView({block: 'center'});",
            checkbox
        );

        if (!checkbox.isSelected()) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(locator)).click();

            } catch (ElementClickInterceptedException e) {
                ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].click();",
                    checkbox
                );
            }
        }
    }

    // Diagnostic: Get visible page text
    public String getPageText() {
    return wait.until(
        ExpectedConditions.visibilityOfElementLocated(By.tagName("body"))
    ).getText();
}
}
