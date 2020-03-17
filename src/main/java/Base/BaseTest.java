package Base;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.internal.annotations.DataProviderAnnotation;
import org.testng.internal.reflect.DataProviderMethodMatcher;

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
    
    @DataProvider(name = "standard_user")
	public String[] readLoginData() throws IOException, ParseException {
		JSONParser jsonParser = new JSONParser();
		FileReader reader = new FileReader("src/main/resources/DataDriven/LoginData.json");
		Object obj = jsonParser.parse(reader);
		JSONObject loginObj = (JSONObject) obj;
		JSONArray array = (JSONArray) loginObj.get("standard_user");
		
		String arr[] = new String[array.size()];
		DataProviderAnnotation dataProviderAnnotation = new DataProviderAnnotation();
		dataProviderAnnotation.getName();
		for (int i = 0; i < array.size(); i++) {
			JSONObject loginData = (JSONObject) array.get(0);
			
			String username = (String) loginData.get("username");
			String password = (String) loginData.get("password");
			
			arr[0] = username + "," + password;
		}
	    return arr;
	    }
}
