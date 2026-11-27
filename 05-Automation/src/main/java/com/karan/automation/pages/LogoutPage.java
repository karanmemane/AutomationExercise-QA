package com.karan.automation.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LogoutPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By logoutButton = By.cssSelector("a[href='/logout']");

    public LogoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickLogoutButton() {
        wait.until(
            ExpectedConditions.elementToBeClickable(logoutButton)
        ).click();
    }
}