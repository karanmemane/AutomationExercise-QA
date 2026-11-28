package com.karan.automation.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactUsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private String pageTitle = "Contact Us - Automation Exercise";
    private String pageUrl = "https://automationexercise.com/contact_us";

    private By getInTouchText = By.xpath("//*[@id='contact-page']/div[3]/div[1]/div/h2");
    private By nameTextArea = By.name("name");
    private By emailTextArea = By.name("email");
    private By subjectTextArea = By.name("subject");
    private By yourMessageTextArea = By.id("message");
    private By chooseFileButton = By.name("upload_file");
    private By submitButton = By.name("submit");
    private By successMessage = By.xpath("//div[contains(@class,'status') or contains(text(),'Success')]");

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public boolean isGetInTouchTextVisible() {
        try {
            return wait.until(
                ExpectedConditions.visibilityOfElementLocated(getInTouchText)
            ).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void enterName(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameTextArea))
            .sendKeys(name);
    }

    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailTextArea))
            .sendKeys(email);
    }

    public void enterSubject(String subject) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(subjectTextArea))
            .sendKeys(subject);
    }

    public void enterYourMessage(String message) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(yourMessageTextArea))
            .sendKeys(message);
    }

    public void uploadFile(String filePath) {
        wait.until(ExpectedConditions.presenceOfElementLocated(chooseFileButton))
            .sendKeys(filePath);
    }

    public void clickSubmitButton() {
        wait.until(ExpectedConditions.elementToBeClickable(submitButton))
            .click();
    }
}