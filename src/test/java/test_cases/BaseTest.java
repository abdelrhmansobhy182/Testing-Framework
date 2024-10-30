package test_cases;

import frontend.utilities.ElementUtilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    WebDriver webDriver;

    @BeforeMethod
    public void setupWebDriver(){
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        ElementUtilities.setWebDriver(webDriver);
    }

    @AfterMethod
    public void closeBrowser(){
        webDriver.close();
    }
}
