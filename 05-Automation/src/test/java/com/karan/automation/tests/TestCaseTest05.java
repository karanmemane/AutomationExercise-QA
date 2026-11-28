package com.karan.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.karan.automation.pages.HomePage;
import com.karan.automation.pages.SignupPage;

public class TestCaseTest05 extends BaseTest {

    @Test
    public void testCase05() {

        System.out.println("Test Case 5: Register User with existing email");

        HomePage homePage = new HomePage(driver);
        SignupPage signupPage = new SignupPage(driver);

        homePage.openHomePage();

        Assert.assertTrue(
            homePage.isHomePageVisible(),
            "Home page is not visible!"
        );

        homePage.clickSignupLogin();

        Assert.assertTrue(
            signupPage.isNewUserSignupVisible(),
            "New User Signup heading is not visible!"
        );

        signupPage.registerUserName("Karan Test");
        signupPage.registerUserEmail("karan.test@example.com");
        signupPage.clickSignupButton();

        Assert.assertTrue(
            signupPage.isEmailAlreadyExistVisible(),
            "Email Address already exist error is not visible!"
        );
        System.out.println("Test Case 5: PASSED ");
    }
}