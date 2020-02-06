package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    //private static
    public WebDriver driver;
    public WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }
//protected
    public void enterText(WebElement element, String text){
        wait.until(ExpectedConditions.visibilityOf(element)).clear();
        element.sendKeys(text);
    }

    public void clickElement(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

    public void selectByValue(WebElement element, String value){
        wait.until(ExpectedConditions.visibilityOf(element));
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public void verifyElementIsDisplayed(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));

    }
    //clickElement, setText, selectByVisibleText, selectByValue,
}
