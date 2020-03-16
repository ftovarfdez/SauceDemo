package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import WebDriverManagement.DriverManager;
import WebDriverManagement.DriverManagerFactory;
import WebDriverManagement.DriverType;

public class BaseTest {
	DriverManager driverManager;
    public static WebDriver driver;

    @BeforeTest
    public void beforeTest() {
        driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver = driverManager.getDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void afterMethod() {
        driverManager.quitDriver();
    }
    
}
