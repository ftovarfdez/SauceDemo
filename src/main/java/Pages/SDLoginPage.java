package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Extensions.BrowserExtensions;
import Extensions.WaitExtensions;

public class SDLoginPage {
	
	/* User name field */
	@FindBy(css = "#user-name")
	WebElement userNameField;
	
	/* Password Field */
	@FindBy(css = "#password")
	WebElement passwordField;
	
	/* Login button */
	@FindBy(css = "input.btn_action")
	WebElement loginButton;
	
	/* Error message */
	@FindBy(css = "h3[data-test='error']")
	WebElement errorMsg;
	
	
	/* Submits username and password*/
	public void login(String username, String password){
		WaitExtensions.waitForPageToLoad(10);
		userNameField.sendKeys(username);
		passwordField.sendKeys(password);
		loginButton.click();
	}
	
	/* Verifies if is at login page*/
	public boolean isAt(){
		WaitExtensions.waitForPageToLoad(10);
		return loginButton.isDisplayed();
		
	}
	
	/*Verifies if error message is displayed after submit of incorrect credentials*/
	public boolean isErrorMessageDisplayed(){
		WaitExtensions.waitForVisibilityOfElement(errorMsg);
		return errorMsg.isDisplayed();
	}

}
