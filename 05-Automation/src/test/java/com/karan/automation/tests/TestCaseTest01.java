
package com.karan.automation.tests;

import org.testng.annotations.Test;
import org.testng.Assert;

import com.karan.automation.pages.LoginPage;

public class TestCaseTest01 extends BaseTest {

    @Test
    public void testCase01() {

        System.out.println(
            "Test Case 01: Verify that a new user can register successfully."
        );

        LoginPage loginPage = new LoginPage(driver);

        // Step 1 and 2: Open browser and navigate to website
        loginPage.openHomePage();

        // Step 3: Verify home page
        Assert.assertTrue(
            loginPage.isHomePageVisible(),
            "Home page is not visible!"
        );

        // Step 4: Click Signup / Login
        loginPage.clickSignupLogin();

        // Step 5: Verify New User Signup
        Assert.assertTrue(
            loginPage.isNewUserSignupVisible(),
            "New User Signup heading is not visible!"
        );

        // Step 6: Enter name and email
        loginPage.registerUserName("Karan Test");
        loginPage.registerUserEmail("karantest1@gmail.com");

        // Step 7: Click Signup
        loginPage.clickSignupButton();

        // Step 8: Wait for and verify Account Information
        Assert.assertTrue(
            loginPage.isAccountInformationVisible(),
            "Account Information page did not load!"
        );

        // Step 9: Fill account information
        loginPage.selectTitleMr();
        loginPage.enterPassword("Test@123");
        loginPage.selectDay("1");
        loginPage.selectMonth("1");
        loginPage.selectYear("2000");

        // Step 10 and 11: Select checkboxes
        loginPage.selectNewsletter();
        loginPage.selectSpecialOffers();

        // Step 12: Fill address information
        loginPage.enterFirstName("Karan");
        loginPage.enterLastName("Test");
        loginPage.enterCompany("Test Company");
        loginPage.enterAddress("123 Test Street");
        loginPage.enterAddress2("Apt 456");
        loginPage.selectCountry("United States");
        loginPage.enterState("Test State");
        loginPage.enterCity("Test City");
        loginPage.enterZipcode("12345");
        loginPage.enterMobileNumber("1234567890");

        // Step 13: Create account
        loginPage.clickCreateAccountButton();

        // Step 14: Verify account created
        Assert.assertTrue(
            loginPage.isAccountCreated(),
            "Account creation failed!"
        );

        // Step 15: Click Continue
        loginPage.clickContinueButton();

        // Step 16: Verify logged-in username
        Assert.assertTrue(
            loginPage.isLoggedInAsUser("Karan Test"),
            "User is not logged in successfully!"
        );

        // Step 17: Delete account
        loginPage.clickDeleteAccount();

        // Step 18: Verify account deleted
        Assert.assertTrue(
            loginPage.isAccountDeleted(),
            "Account deletion failed!"
        );

        // Step 19: Click Continue
        loginPage.clickContinueButton();

        System.out.println(
            "Test Case 01 passed: Registration and account deletion successful."
        );
    }
}
