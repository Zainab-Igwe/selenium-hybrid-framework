package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends BasePage {
    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//select[@name='title']")
    public WebElement titleField;

    @FindBy(xpath = "//input[contains(@id, 'firstName')]")
    public WebElement firstNameField;

    public void selectTitle(String text){
        selectByValue(titleField, text);
    }

    public void enterFirstName(String text){
        enterText(firstNameField, text);
    }
}
