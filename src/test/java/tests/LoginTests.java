package tests;

import base.BaseTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.LoginPage;
import pages.SignUpPage;
import utilities.TestUtility;

import java.io.IOException;

public class LoginTests extends BaseTests {
    public LoginPage loginPage;
    public Logger logger;
    public TestUtility testUtility;

    @BeforeClass
    public void init(){
        logger = LoggerFactory.getLogger(LoginTests.class);
        loginPage = new LoginPage(driver);
        testUtility = new TestUtility();
    }

    @Test(priority = 1)
    public void testLoginSuccessfully() throws IOException {
        navigateToHome();
        loginPage.enterUsername("zainab");
        logger.info("Got here");
        loginPage.enterPassword("zay");
        logger.info("Pass");
        loginPage.clickRememberMe();
        loginPage.clickSignInButton();
        loginPage.verifyErrorMessageIsDisplayed();
        logger.info("G");
    }

    @DataProvider
    public Object[][] getDataFromExcel()
    {
        Object data[][] = TestUtility.getTestData("Contacts");
        return data;
    }

    @Test(priority = 2, dataProvider = "getDataFromExcel")
    public void testLoginUnSuccessfully(String FirstName, String LastName) throws IOException {
        navigateToHome();
        loginPage.enterUsername(FirstName);
        logger.info("Got here");
        loginPage.enterPassword(LastName);
        logger.info("Pass");
        loginPage.clickRememberMe();
        loginPage.clickSignInButton();
        loginPage.verifyErrorMessageIsDisplayed();
        logger.info("G");
    }
}
