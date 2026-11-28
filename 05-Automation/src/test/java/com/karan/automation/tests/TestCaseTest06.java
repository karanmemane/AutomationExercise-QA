package com.karan.automation.tests;
import org.testng.annotations.Test;
import org.testng.Assert;
import com.karan.automation.pages.ContactUsPage;
import com.karan.automation.pages.HomePage;

public class TestCaseTest06 extends BaseTest {

    @Test
    public void testCase06() {

        System.out.println("Test Case 6: Contact Us Form Submission");

        HomePage homePage = new HomePage(driver);
        ContactUsPage contactUsPage = new ContactUsPage(driver);

        homePage.openHomePage();

        Assert.assertTrue(
            homePage.isHomePageVisible(),
            "Home page is not visible!"
        );

        homePage.clickContactUs();

        Assert.assertTrue(
            contactUsPage.isGetInTouchTextVisible(),
            "GET IN TOUCH heading is not visible!"
        );

        contactUsPage.enterName("Karan Test");
        contactUsPage.enterEmail("karan.test@example.com");
        contactUsPage.enterSubject("Test Subject");
        contactUsPage.enterYourMessage("This is a test message.");
        contactUsPage.clickSubmitButton();
        
        System.out.println("Test Case 6: PASSED");
    }
}
