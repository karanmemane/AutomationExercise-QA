package com.karan.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By loginLink = By.linkText("Signup / Login");

    public void clickLoginLink() {
        driver.findElement(loginLink).click();
    }
}