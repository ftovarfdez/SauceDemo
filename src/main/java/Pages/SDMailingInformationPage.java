package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Extensions.BrowserExtensions;
import Extensions.WaitExtensions;

public class SDMailingInformationPage {
	
	/* First Name field*/
	@FindBy(css = "#first-name")
	WebElement firstName;
	
	/* Last Name field*/
	@FindBy(css = "#last-name")
	WebElement lastName;
	
	/* Zip Code field*/
	@FindBy(css = "#postal-code")
	WebElement zipCode;
			
	/* Continue button*/
	@FindBy(css = "input[type='submit']")
	WebElement continueButton;
	
	/* Error Message*/
	@FindBy(css = "h3[data-test='error']")
	WebElement errorMsg;
	
	/*Validate is at mailing information page */
	public boolean isAt() {
		WaitExtensions.waitForPageToLoad(10);
		return BrowserExtensions.getCurrentURL().contains("checkout-step-one");
	}
	
	/* Fill mailing information and submit*/
	public void fillMailingSection(String firstName, String lastName, String zipCode) {
		WaitExtensions.waitForPageToLoad(10);
		
		this.firstName.sendKeys(firstName);
		this.lastName.sendKeys(lastName);
		this.zipCode.sendKeys(zipCode);
		
		continueButton.click();
	}
	
	/* Fill mailing information with missing info and submit*/
	public void fillMailingSectionWithMissingInfo(String firstName, String lastName) {
		WaitExtensions.waitForPageToLoad(10);
		
		this.firstName.sendKeys(firstName);
		this.lastName.sendKeys(lastName);
		
		continueButton.click();
	}
	
	public boolean isErrorMessageDisplayed() {
		WaitExtensions.waitForVisibilityOfElement(errorMsg);
		return errorMsg.isDisplayed();
	}
}
