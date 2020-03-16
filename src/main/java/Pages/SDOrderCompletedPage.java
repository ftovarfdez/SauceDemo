package Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Extensions.BrowserExtensions;
import Extensions.WaitExtensions;

public class SDOrderCompletedPage {
	
	/* Thanks message*/
	@FindBy(css = "#checkout_complete_container > h2")
	WebElement thanksMessage;
	
	
	/* Validates thanks message is displayed*/
	public boolean isThanksTextDisplayed() {
		WaitExtensions.waitForPageToLoad(10);
		WaitExtensions.waitForVisibilityOfElement(thanksMessage);
		return thanksMessage.isDisplayed();
	}
}
