package Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Extensions.BrowserExtensions;
import Extensions.WaitExtensions;

public class SDShoppingCartPage {
	
	/* Shopping cart button */
	@FindBy(css = "#shopping_cart_container path")
	WebElement cartButton;
	
	/* Items list */
	@FindBy(css = ".cart_item")
	List <WebElement> itemsList;
	
	/* Checkout button */
	@FindBy(css = "a.btn_action")
	WebElement checkoutButton;
	
	/* Items list names */
	@FindBy(css = ".cart_item div.inventory_item_name")
	List <WebElement> itemsListNames;
	
	/* Click on shopping cart button */
	public void clickOnCart() {
		WaitExtensions.waitForVisibilityOfElement(cartButton);
		cartButton.click();
	}
	
	/* Verifies if is at shopping cart page */
	public boolean isAt(){
		WaitExtensions.waitForPageToLoad(10);
		String currentURL = BrowserExtensions.getCurrentURL();
		
		return currentURL.contains("cart.html");
	}
	
	/*Validates the number of items added to the cart */
	public boolean validateNumberOfItemsInCart(int numberOfItems){
		
		if(itemsList.size() != numberOfItems) {
			return false;
		}
		return true;
	}
	
	/* Checkout cart products*/
	public void checkoutProducts() {
		WaitExtensions.waitForVisibilityOfElement(checkoutButton);
		checkoutButton.click();
	}
	
	public List<String> returnProductNamesInCart() {
		List<String> productsNames = new ArrayList<>(); 
		for (WebElement item : itemsListNames) {
			productsNames.add(item.getText());
		}
		return productsNames;
	}
}
