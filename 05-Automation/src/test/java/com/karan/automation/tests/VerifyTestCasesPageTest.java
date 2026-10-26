package com.karan.automation.tests;

// Import Selenium classes for browser control and locating elements
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

// Import Selenium classes for explicit waits
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// Import Java Duration to define the wait timeout
import java.time.Duration;

// Import TestNG classes for assertions and test execution
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyTestCasesPageTest {

    // @Test tells TestNG to execute this method as a test case
    @Test
    public void verifyTestCasesPage() {

        // Step 1: Launch the Chrome browser
        WebDriver driver = new ChromeDriver();

        // Create an explicit wait that waits up to 10 seconds
        WebDriverWait wait = new WebDriverWait(
            driver,
            Duration.ofSeconds(10)
        );

        try {
            // Step 2: Open the Automation Exercise homepage
            driver.get("https://www.automationexercise.com/");

            // Step 3: Locate the Test Cases link using XPath
            By testCaseLink = By.xpath(
                "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a"
            );

            // Click the Test Cases link in the navigation bar
            driver.findElement(testCaseLink).click();

            // Step 4: Wait until the URL contains /test_cases
            // This allows time for navigation to complete
            wait.until(
                ExpectedConditions.urlContains("/test_cases")
            );

            // Step 5: Verify that the browser opened the expected URL
            Assert.assertEquals(
                driver.getCurrentUrl(),
                "https://www.automationexercise.com/test_cases",
                "Test Cases page URL is incorrect"
            );

            // Step 6: Locate the Test Cases page heading using XPath
            By testCaseHeading = By.xpath(
                "//*[@id=\"form\"]/div/div[1]/div/h2/b"
            );

            // Wait until the heading becomes visible
            WebElement heading = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                    testCaseHeading
                )
            );

            // Step 7: Verify that the heading is displayed
            Assert.assertTrue(
                heading.isDisplayed(),
                "Test Cases heading is not displayed"
            );

            // Print a success message if all assertions pass
            System.out.println("Test Cases page verification passed!");

        } finally {
            // Step 8: Close the browser, even if the test fails
            driver.quit();
        }
    }
}
