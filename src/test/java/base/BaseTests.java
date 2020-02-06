package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTests {
    public WebDriver driver;
    public Logger logger = LoggerFactory.getLogger(BaseTests.class);

    @BeforeSuite
    public WebDriver setup() throws IOException {

        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/config/config.properties");

        Properties properties = new Properties();
        properties.load(fileInputStream);

        String browserName = properties.getProperty("browser");
        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
            this.driver = new ChromeDriver();
        } else if(browserName.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/drivers/geckodriver");
            this.driver=new FirefoxDriver();

        }

        //logger = LoggerFactory.getLogger(baseTests.class);
        logger.info("Browser initialized successfully");

        return driver;
    }

    public void navigateToHome() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/config/config.properties");
        Properties properties = new Properties();
        properties.load(fileInputStream);

        String url = properties.getProperty("url");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
        driver.manage().window().maximize();
        logger.info("Home Page launched successfully");
    }

    @AfterSuite
    public void tearDown(){
        logger.info("i am shutting down");
        driver.quit();
    }
}
