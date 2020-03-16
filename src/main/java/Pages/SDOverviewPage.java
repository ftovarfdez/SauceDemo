package Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Extensions.BrowserExtensions;
import Extensions.WaitExtensions;

public class SDOverviewPage {
	/* Checkout items names*/
	@FindBy(css = ".cart_item div.inventory_item_name")
	List <WebElement> itemsNames;
	
	/* Finish button*/
	@FindBy(css = "a.btn_action")
	WebElement finishButton;
	
	/* Validates is at overview page*/
	public boolean isAt() {
		WaitExtensions.waitForPageToLoad(10);
		return BrowserExtensions.getCurrentURL().contains("checkout-step-two");
	}
	
	/* Validates names are equals in cart and overview pages*/
	public boolean areProductNamesEquals() {
		List<String> cartItems = SauceDemoPages.sdShoppingCartPage().returnProductNamesInCart();
		List<String> overviewItems = new ArrayList<String>();
		
		for (WebElement item : itemsNames) {
			overviewItems.add(item.getText());
		}
		return cartItems.equals(overviewItems);
	}
	
	/* Complete order*/
	public void completeOrder() {
		WaitExtensions.waitForVisibilityOfElement(finishButton);
		finishButton.click();
	}
}
