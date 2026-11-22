
package com.karan.automation.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.Assert;

import com.karan.automation.pages.TestCasePage01;

public class TestCaseTest01 extends BaseTest {

    @Test
    public void testCase01() {

        System.out.println("Test Case 01: Verify that a new user can register successfully.");

        TestCasePage01 testCasePage = new TestCasePage01(driver);

        // Step 1 and 2: Open browser and navigate to website
        testCasePage.openHomePage();

        // Step 3: Verify home page
        Assert.assertTrue(
            testCasePage.isHomePageVisible(),
            "Home page is not visible!"
        );

        // Step 4: Click Signup / Login
        testCasePage.clickSignupLogin();

        // Step 5: Verify New User Signup
        Assert.assertTrue(
            testCasePage.isNewUserSignupVisible(),
            "New User Signup heading is not visible!"
        );

        // Step 6: Enter name and email
        testCasePage.registerUserName("Karan Test");
        testCasePage.registerUserEmail("karantest!@gmail.com");

        // Step 7: Click Signup
        testCasePage.clickSignupButton();

        // Diagnostic: Check what page or message appears after Signup
        System.out.println("URL after Signup: " + driver.getCurrentUrl());
        System.out.println("Page Title: " + driver.getTitle());
        System.out.println("Page message after Signup:");
        System.out.println(driver.findElement(By.tagName("body")).getText());

        // Step 8: Verify Account Information
        Assert.assertTrue(
            testCasePage.isAccountInformationVisible(),
            "Account Information page did not load!"
        );

        // Step 9: Fill account information
        testCasePage.selectTitleMr();
        testCasePage.enterPassword("Test@123");
        testCasePage.selectDay("1");
        testCasePage.selectMonth("1");
        testCasePage.selectYear("2000");

        // Step 10 and 11: Select checkboxes
        testCasePage.selectNewsletter();
        testCasePage.selectSpecialOffers();

        // Step 12: Fill address information
        testCasePage.enterFirstName("Karan");
        testCasePage.enterLastName("Test");
        testCasePage.enterCompany("Test Company");
        testCasePage.enterAddress("123 Test Street");
        testCasePage.enterAddress2("Apt 456");
        testCasePage.selectCountry("United States");
        testCasePage.enterState("Test State");
        testCasePage.enterCity("Test City");
        testCasePage.enterZipcode("12345");
        testCasePage.enterMobileNumber("1234567890");

        // Step 13: Create account
        testCasePage.clickCreateAccountButton();

        // Step 14: Verify account created
        Assert.assertTrue(
            testCasePage.isAccountCreated(),
            "Account creation failed!"
        );

        // Step 15: Click Continue
        testCasePage.clickContinueButton();

        // Step 16: Verify logged-in username
        Assert.assertTrue(
            testCasePage.isLoggedInAsUser("Karan Test"),
            "User is not logged in successfully!"
        );

        System.out.println("Test Case 01 passed: User registered successfully.");
    }
}
