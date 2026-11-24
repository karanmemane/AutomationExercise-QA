
package com.karan.automation.tests;

import org.testng.annotations.Test;
import org.testng.Assert;

import com.karan.automation.pages.HomePage;
import com.karan.automation.pages.SignupPage;
import com.karan.automation.pages.LoginPage;
import com.karan.automation.pages.AccountPage;

public class TestCaseTest01 extends BaseTest {

    @Test
    public void testCase01() {

        System.out.println(
            "Test Case 01: Verify that a new user can register successfully."
        );

        // Initialize Page Objects
        HomePage homePage = new HomePage(driver);
        SignupPage signupPage = new SignupPage(driver);
        AccountPage accountPage = new AccountPage(driver);

        // Step 1 and 2: Open browser and navigate to website
        homePage.openHomePage();

        // Step 3: Verify home page
        Assert.assertTrue(
            homePage.isHomePageVisible(),
            "Home page is not visible!"
        );

        // Step 4: Click Signup / Login
        homePage.clickSignupLogin();

        // Step 5: Verify New User Signup
        Assert.assertTrue(
            signupPage.isNewUserSignupVisible(),
            "New User Signup heading is not visible!"
        );

        // Step 6: Enter name and email
        signupPage.registerUserName("Karan Test");
        signupPage.registerUserEmail("karantest1@gmail.com");

        // Step 7: Click Signup
        signupPage.clickSignupButton();

        // Step 8: Verify Account Information
        Assert.assertTrue(
            signupPage.isAccountInformationVisible(),
            "Account Information page did not load!"
        );

        // Step 9: Fill personal information
        signupPage.selectTitleMr();
        signupPage.enterPassword("Test@123");
        signupPage.selectDay("1");
        signupPage.selectMonth("1");
        signupPage.selectYear("2000");

        // Step 10 and 11: Select preferences
        signupPage.selectNewsletter();
        signupPage.selectSpecialOffers();

        // Step 12: Fill address information
        signupPage.enterFirstName("Karan");
        signupPage.enterLastName("Test");
        signupPage.enterCompany("Test Company");
        signupPage.enterAddress("123 Test Street");
        signupPage.enterAddress2("Apt 456");
        signupPage.selectCountry("United States");
        signupPage.enterState("Test State");
        signupPage.enterCity("Test City");
        signupPage.enterZipcode("12345");
        signupPage.enterMobileNumber("1234567890");

        // Step 13: Create account
        signupPage.clickCreateAccountButton();

        // Step 14: Verify account created
        Assert.assertTrue(
            accountPage.isAccountCreated(),
            "Account creation failed!"
        );

        // Step 15: Click Continue
        accountPage.clickContinueButton();

        // Step 16: Verify logged-in username
        Assert.assertTrue(
            accountPage.isLoggedInAsUser("Karan Test"),
            "User is not logged in successfully!"
        );

        // Step 17: Delete account
        accountPage.clickDeleteAccount();

        // Step 18: Verify account deleted
        Assert.assertTrue(
            accountPage.isAccountDeleted(),
            "Account deletion failed!"
        );

        // Step 19: Click Continue
        accountPage.clickContinueButton();

        System.out.println(
            "Test Case 01 passed: Registration and account deletion successful."
        );
    }
}
