package com.karan.automation.tests;

import org.testng.annotations.Test;
import org.testng.Assert;

import com.karan.automation.pages.HomePage;
import com.karan.automation.pages.LoginPage;

public class TestCaseTest03 extends BaseTest {

    @Test
    public void testCase03() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        homePage.openHomePage();

        Assert.assertTrue(
            homePage.isHomePageVisible(),
            "Home page is not visible!"
        );

        homePage.clickSignupLogin();
        Assert.assertTrue(
            loginPage.isLoginHeadingVisible(),
            "Login to your account heading is not visible!"
        );

        loginPage.enterLoginEmail("wronguser123@mail.com");
        loginPage.enterLoginPassword("WrongPassword@123");
        loginPage.clickLoginButton();

        Assert.assertTrue(
        loginPage.isLoginErrorVisible(),
            "Your email or password is incorrect! message is not visible!"
        );

    }
}