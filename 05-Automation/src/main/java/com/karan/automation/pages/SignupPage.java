
package com.karan.automation.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Signup form locators
    private By signupButton = By.cssSelector("[data-qa='signup-button']");
    private By newUserSignupHeading =
        By.xpath("//h2[normalize-space()='New User Signup!']");
    private By accountInformationHeading =
        By.xpath("//b[normalize-space()='Enter Account Information']");

    // Personal information locators
    private By titleMr = By.id("id_gender1");
    private By titleMrs = By.id("id_gender2");
    private By passwordField = By.id("password");
    private By dayDropdown = By.id("days");
    private By monthDropdown = By.id("months");
    private By yearDropdown = By.id("years");

    // Preferences locators
    private By newsletterCheckbox = By.id("newsletter");
    private By specialOffersCheckbox = By.id("optin");

    // Address information locators
    private By firstNameField = By.id("first_name");
    private By lastNameField = By.id("last_name");
    private By companyField = By.id("company");
    private By addressField = By.id("address1");
    private By address2Field = By.id("address2");
    private By countryDropdown = By.id("country");
    private By stateField = By.id("state");
    private By cityField = By.id("city");
    private By zipcodeField = By.id("zipcode");
    private By mobileNumberField = By.id("mobile_number");

    // Account submission locator
    private By createAccountButton =
        By.cssSelector("[data-qa='create-account']");

    // Constructor
    public SignupPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // Verify New User Signup heading
    public boolean isNewUserSignupVisible() {
        try {
            return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                    newUserSignupHeading
                )
            ).isDisplayed();

        } catch (TimeoutException e) {
            return false;
        }
    }

    // Enter registration name
    public void registerUserName(String name) {
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.name("name"))
        ).sendKeys(name);
    }

    // Enter registration email
    public void registerUserEmail(String email) {
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("[data-qa='signup-email']")
            )
        ).sendKeys(email);
    }

    // Click Signup button
    public void clickSignupButton() {

        WebElement button = wait.until(
            ExpectedConditions.presenceOfElementLocated(signupButton)
        );

        ((JavascriptExecutor) driver).executeScript(
            "arguments[0].scrollIntoView({block: 'center'});",
            button
        );

        try {
            wait.until(
                ExpectedConditions.elementToBeClickable(signupButton)
            ).click();

        } catch (ElementClickInterceptedException e) {

            System.out.println(
                "Signup button click intercepted. Trying JavaScript click."
            );

            ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();",
                button
            );
        }
    }

    // Verify Account Information heading
    public boolean isAccountInformationVisible() {
        try {
            return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                    accountInformationHeading
                )
            ).isDisplayed();

        } catch (TimeoutException e) {
            return false;
        }
    }

    // Select title: Mr
    public void selectTitleMr() {
        wait.until(
            ExpectedConditions.elementToBeClickable(titleMr)
        ).click();
    }

    // Select title: Mrs
    public void selectTitleMrs() {
        wait.until(
            ExpectedConditions.elementToBeClickable(titleMrs)
        ).click();
    }

    // Enter password
    public void enterPassword(String password) {
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(passwordField)
        ).sendKeys(password);
    }

    // Select birth day
    public void selectDay(String day) {
        Select select = new Select(
            wait.until(
                ExpectedConditions.visibilityOfElementLocated(dayDropdown)
            )
        );
        select.selectByValue(day);
    }

    // Select birth month
    public void selectMonth(String month) {
        Select select = new Select(
            wait.until(
                ExpectedConditions.visibilityOfElementLocated(monthDropdown)
            )
        );
        select.selectByValue(month);
    }

    // Select birth year
    public void selectYear(String year) {
        Select select = new Select(
            wait.until(
                ExpectedConditions.visibilityOfElementLocated(yearDropdown)
            )
        );
        select.selectByValue(year);
    }

    // Select newsletter checkbox
    public void selectNewsletter() {
        clickCheckbox(newsletterCheckbox);
    }

    // Select special offers checkbox
    public void selectSpecialOffers() {
        clickCheckbox(specialOffersCheckbox);
    }

    // Enter first name
    public void enterFirstName(String firstName) {
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(firstNameField)
        ).sendKeys(firstName);
    }

    // Enter last name
    public void enterLastName(String lastName) {
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(lastNameField)
        ).sendKeys(lastName);
    }

    // Enter company
    public void enterCompany(String company) {
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(companyField)
        ).sendKeys(company);
    }

    // Enter address
    public void enterAddress(String address) {
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(addressField)
        ).sendKeys(address);
    }

    // Enter second address
    public void enterAddress2(String address2) {
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(address2Field)
        ).sendKeys(address2);
    }

    // Select country
    public void selectCountry(String country) {
        Select select = new Select(
            wait.until(
                ExpectedConditions.visibilityOfElementLocated(countryDropdown)
            )
        );
        select.selectByVisibleText(country);
    }

    // Enter state
    public void enterState(String state) {
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(stateField)
        ).sendKeys(state);
    }

    // Enter city
    public void enterCity(String city) {
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(cityField)
        ).sendKeys(city);
    }

    // Enter zipcode
    public void enterZipcode(String zipcode) {
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(zipcodeField)
        ).sendKeys(zipcode);
    }

    // Enter mobile number
    public void enterMobileNumber(String mobileNumber) {
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(mobileNumberField)
        ).sendKeys(mobileNumber);
    }

    // Click Create Account button
    public void clickCreateAccountButton() {

        WebElement button = wait.until(
            ExpectedConditions.presenceOfElementLocated(createAccountButton)
        );

        ((JavascriptExecutor) driver).executeScript(
            "arguments[0].scrollIntoView({block: 'center'});",
            button
        );

        try {
            wait.until(
                ExpectedConditions.elementToBeClickable(createAccountButton)
            ).click();

        } catch (ElementClickInterceptedException e) {

            ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();",
                button
            );
        }
    }

    // Reusable checkbox helper
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
                wait.until(
                    ExpectedConditions.elementToBeClickable(locator)
                ).click();

            } catch (ElementClickInterceptedException e) {

                ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].click();",
                    checkbox
                );
            }
        }
    }

    public boolean isEmailAlreadyExistVisible() {
        By emailAlreadyExistMessage =
            By.cssSelector("#form > div > div.row > div:nth-child(3) > div > form > p");

        try {
            return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                    emailAlreadyExistMessage
                )
            ).isDisplayed();

        } catch (TimeoutException e) {
            return false;
        }
    }

}
