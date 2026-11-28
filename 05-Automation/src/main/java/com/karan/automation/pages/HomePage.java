
package com.karan.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By signupLoginButton = By.linkText("Signup / Login");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void openHomePage() {
        driver.get("https://automationexercise.com/");
    }

    public boolean isHomePageVisible() {
        return driver.getTitle().contains("Automation Exercise");
    }

    public void clickSignupLogin() {
        wait.until(
            ExpectedConditions.elementToBeClickable(signupLoginButton)
        ).click();
    }

    public void clickContactUs() {
        By contactUsButton = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[8]/a");
        wait.until(
            ExpectedConditions.elementToBeClickable(contactUsButton)
        ).click();
    }
}
