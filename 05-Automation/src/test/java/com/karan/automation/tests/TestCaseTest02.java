package com.karan.automation.tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import com.karan.automation.pages.HomePage;
import com.karan.automation.pages.LoginPage;
import com.karan.automation.pages.AccountPage;

public class TestCaseTest02 extends BaseTest {

    @Test
    public void testCase02() {

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        AccountPage accountPage = new AccountPage(driver);
        System.out.println(
            "Test Case 02: Verify that an existing user can log in successfully."
        );
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
        loginPage.enterLoginEmail("karanTest12@mail.com");
        loginPage.enterLoginPassword("karanTest@123");
        loginPage.clickLoginButton();

        Assert.assertTrue(
            accountPage.isLoggedInAsUser("Karan Test"),
            "Logged in as Karan Test is not visible!"
        );

        accountPage.clickDeleteAccount();
        Assert.assertTrue(
            accountPage.isAccountDeleted(),
            "ACCOUNT DELETED! message is not visible!"
        );
    }
}