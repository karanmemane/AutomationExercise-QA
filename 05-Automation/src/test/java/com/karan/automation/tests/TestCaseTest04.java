
package com.karan.automation.tests;

import org.testng.annotations.Test;
import org.testng.Assert;

import com.karan.automation.pages.HomePage;
import com.karan.automation.pages.LoginPage;
import com.karan.automation.pages.AccountPage;
import com.karan.automation.pages.LogoutPage;

public class TestCaseTest04 extends BaseTest {

    @Test
    public void testCase04() {

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        AccountPage accountPage = new AccountPage(driver);
        LogoutPage logoutPage = new LogoutPage(driver);

        System.out.println(
            "Test Case 04: Verify that a user can log in and logout successfully."
        );

        homePage.openHomePage();

        Assert.assertTrue(
            homePage.isHomePageVisible(),
            "Home page is not visible!"
        );

        homePage.clickSignupLogin();

        Assert.assertTrue(
            loginPage.isLoginHeadingVisible(),
            "Login heading is not visible!"
        );

        loginPage.enterLoginEmail("karan1test@mail.com");
        loginPage.enterLoginPassword("12345");
        loginPage.clickLoginButton();

        Assert.assertTrue(
            accountPage.isLoggedInAsUser("Karan Test"),
            "Logged in as Karan Test is not visible!"
        );

        logoutPage.clickLogoutButton();

        Assert.assertTrue(
            loginPage.isLoginHeadingVisible(),
            "Login page is not visible after logout!"
        );
    }
}
