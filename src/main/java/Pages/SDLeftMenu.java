package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Extensions.WaitExtensions;

public class SDLeftMenu {
	
	/* LogOut Link */
	@FindBy(css = "#logout_sidebar_link")
	WebElement logOut;
	
	/* Menu Button */
	@FindBy(css = ".bm-burger-button")
	WebElement menuButton;
	
	/*Open Left menu*/
	public void openMenu() {
		WaitExtensions.waitForVisibilityOfElement(menuButton);
		menuButton.click();
	}
	
	/* Clicks on logout link */
	public void logout() {
		openMenu();
		
		WaitExtensions.waitForVisibilityOfElement(logOut);
		logOut.click();
	}
}
