package testBase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.BrowserFactory;
import utils.ConfigReader;
import utils.Constants;
import utils.PageInitializers;

public class TestBase extends PageInitializers {
    public static WebDriver driver;

    @BeforeMethod
    public void start(){
        ConfigReader.readProperties(Constants.CONFIGURATION_FILEPATH);
        switch (ConfigReader.getPropertyValue("browser")) {
            case "chrome":
                BrowserFactory.setDriver("chrome");
                break;
            case "firefox":
                BrowserFactory.setDriver("firefox");
                break;
            default:
                throw new RuntimeException("Invalid Browser Name");
        }
        driver = BrowserFactory.getDriver();
        driver.get(ConfigReader.getPropertyValue("url"));
        driver.manage().deleteAllCookies();
        //driver.manage().window().maximize();
        initializePageObjects();
    }

    @AfterMethod
    public void tearDown() {
        BrowserFactory.closeBrowser();
    }
}
