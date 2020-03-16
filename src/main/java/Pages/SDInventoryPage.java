package Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Extensions.BrowserExtensions;
import Extensions.WaitExtensions;

public class SDInventoryPage {
	
	/* Add item list */
	@FindBy(css = "#inventory_container button")
	List<WebElement> addItemList;
	
	/* Verifies if is at inventory page*/
	public boolean isAt(){
		WaitExtensions.waitForPageToLoad(10);
		String currentURL = BrowserExtensions.getCurrentURL();
		
		return currentURL.contains("inventory.html");
	}
	
	/* Adds a number of items to the cart*/
	public void addItemsToCart(int numberOfItems){
		WaitExtensions.waitForPageToLoad(10);
		for (int i = 0; i < numberOfItems; i++) {
			addItemList.get(i).click();
		}
	}
}
