package tests;

import base.BaseTests;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SignUpPage;

import java.io.IOException;

public class SignUpTests extends BaseTests {
    public LoginPage loginPage;
    public SignUpPage signUpPage;
    public Logger logger;

    @BeforeClass
    public void init() throws IOException{
        logger = LoggerFactory.getLogger(SignUpTests.class);
        signUpPage = new SignUpPage(setup());
        loginPage = new LoginPage(setup());
    }

    @Test
    public void testSignUpSuccessfully() throws IOException {
        navigateToHome();
        loginPage.clickSignUpLink();
        signUpPage.selectTitle("Ms.");
        signUpPage.enterFirstName("Zay");
    }
}
