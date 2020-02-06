package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver){
        super(driver);
    }

    @FindBy(css = "input#username")
    public WebElement username;

    @FindBy(css = "input.form-control[name = password]")
    public WebElement passwordField;

    @FindBy(xpath = "//input[@name = 'remember-me']")
    public WebElement rememberMeLabel;

    @FindBy(css = "button#submit")
    public WebElement signInButton;

    @FindBy(linkText = "Sign Up Here")
    public WebElement signUpLink;

    @FindBy(xpath = "//span[contains(text(), 'Error')]")
    public WebElement errorMessage;


    public LoginPage enterUsername(String text){
        enterText(username, text);
        return this;
    }

    public LoginPage enterPassword(String text){
        enterText(passwordField, text);
        return this;
    }

    public void clickRememberMe(){
        clickElement(rememberMeLabel);
        String label = rememberMeLabel.getText();
        System.out.println(label);
    }

    public void clickSignInButton(){
        clickElement(signInButton);
    }

    public void clickSignUpLink(){
        clickElement(signUpLink);
    }

    public void verifyErrorMessageIsDisplayed(){
        verifyElementIsDisplayed(errorMessage);
    }
}
