package Tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import Base.BaseTest;
import Pages.SauceDemoPages;

public class SauceDemoTest extends BaseTest{
	
	@Test
	public void validUserLogin(){
		
		//Validate is at login page
		Assert.assertTrue(SauceDemoPages.sdLoginPage().isAt());
		Reporter.log("At login page");
		
		//Enter username and password
		SauceDemoPages.sdLoginPage().login("standard_user", "secret_sauce");
		Reporter.log("Logging in");
		
		//Validate is at inventory page
		Assert.assertTrue(SauceDemoPages.sdInventoryPage().isAt());
		Reporter.log("At inventory page");
	}
	
	@Test
	public void invalidUserLogin(){
		
		//Validate is at login page
		Assert.assertTrue(SauceDemoPages.sdLoginPage().isAt());
		Reporter.log("At login page");
				
		//Enter username and password
		SauceDemoPages.sdLoginPage().login("invalid_user", "invalid_pwd");
		Reporter.log("Logging in");
		
		//Validate is error message displayed
		Assert.assertTrue(SauceDemoPages.sdLoginPage().isErrorMessageDisplayed());
		Reporter.log("Error message displayed");
	}
	
	@Test
	public void logoutFromPage(){
		//Validate is at login page
		Assert.assertTrue(SauceDemoPages.sdLoginPage().isAt());
		Reporter.log("At login page");
				
		//Enter username and password
		SauceDemoPages.sdLoginPage().login("standard_user", "secret_sauce");
		Reporter.log("Logging in");
				
		//Validate is at inventory page
		Assert.assertTrue(SauceDemoPages.sdInventoryPage().isAt());
		Reporter.log("At inventory page");
		
		//Logout
		SauceDemoPages.sdLeftMenu().logout();
		Reporter.log("Log out");
		
		//Validate is at login page
		Assert.assertTrue(SauceDemoPages.sdLoginPage().isAt());
		Reporter.log("At login page");
	}
	
	@Test
	public void openCartPage(){
		//Validate is at login page
		Assert.assertTrue(SauceDemoPages.sdLoginPage().isAt());
		Reporter.log("At login page");
						
		//Enter username and password
		SauceDemoPages.sdLoginPage().login("standard_user", "secret_sauce");
		Reporter.log("Logging in");
				
		//Validate is at inventory page
		Assert.assertTrue(SauceDemoPages.sdInventoryPage().isAt());
		Reporter.log("At inventory page");
		
		//Open cart
		SauceDemoPages.sdShoppingCartPage().clickOnCart();
		Reporter.log("Opening cart page");
		
		//Validate is at cart page
		Assert.assertTrue(SauceDemoPages.sdShoppingCartPage().isAt());
		Reporter.log("At cart page");
	}
	
	@Test
	public void openSingleItemToCart(){
		//Validate is at login page
		Assert.assertTrue(SauceDemoPages.sdLoginPage().isAt());
		Reporter.log("At login page");
						
		//Enter username and password
		SauceDemoPages.sdLoginPage().login("standard_user", "secret_sauce");
		Reporter.log("Logging in");
				
		//Validate is at inventory page
		Assert.assertTrue(SauceDemoPages.sdInventoryPage().isAt());
		Reporter.log("At inventory page");
		
		//Add one item to the cart
		SauceDemoPages.sdInventoryPage().addItemsToCart(1);
		Reporter.log("One item added to cart");
		
		//Open cart
		SauceDemoPages.sdShoppingCartPage().clickOnCart();
		Reporter.log("Opening cart page");
		
		//Validate is at cart page
		Assert.assertTrue(SauceDemoPages.sdShoppingCartPage().isAt());
		Reporter.log("At cart page");
		
		//Validate items were added to cart
		Assert.assertTrue(SauceDemoPages.sdShoppingCartPage().validateNumberOfItemsInCart(1));
		Reporter.log("Item addded correctly");
	}
	
	@Test
	public void openMultipleItemsToCart(){
		
		int numberOfItems = 3;
		
		//Validate is at login page
		Assert.assertTrue(SauceDemoPages.sdLoginPage().isAt());
		Reporter.log("At login page");
						
		//Enter username and password
		SauceDemoPages.sdLoginPage().login("standard_user", "secret_sauce");
		Reporter.log("Logging in");
				
		//Validate is at inventory page
		Assert.assertTrue(SauceDemoPages.sdInventoryPage().isAt());
		Reporter.log("At inventory page");
		
		//Add one item to the cart
		SauceDemoPages.sdInventoryPage().addItemsToCart(numberOfItems);
		Reporter.log("3 items added to cart");
		
		//Open cart
		SauceDemoPages.sdShoppingCartPage().clickOnCart();
		Reporter.log("Opening cart page");
		
		//Validate is at cart page
		Assert.assertTrue(SauceDemoPages.sdShoppingCartPage().isAt());
		Reporter.log("At cart page");
		
		//Validate items were added to cart
		Assert.assertTrue(SauceDemoPages.sdShoppingCartPage().validateNumberOfItemsInCart(numberOfItems));
		Reporter.log(numberOfItems + " items addded correctly");
	}
	
	@Test
	public void fillMailingInformationWithMissingInfo() {
		//Validate is at login page
		Assert.assertTrue(SauceDemoPages.sdLoginPage().isAt());
		Reporter.log("At login page");
								
		//Enter username and password
		SauceDemoPages.sdLoginPage().login("standard_user", "secret_sauce");
		Reporter.log("Logging in");
				
		//Validate is at inventory page
		Assert.assertTrue(SauceDemoPages.sdInventoryPage().isAt());
		Reporter.log("At inventory page");
				
		//Add one item to the cart
		SauceDemoPages.sdInventoryPage().addItemsToCart(1);
		Reporter.log("Item added to cart");
		
		//Open cart
		SauceDemoPages.sdShoppingCartPage().clickOnCart();
		Reporter.log("Opening cart page");
		
		//Validate is at cart page
		Assert.assertTrue(SauceDemoPages.sdShoppingCartPage().isAt());
		Reporter.log("At cart page");
		
		//Checkout cart products
		SauceDemoPages.sdShoppingCartPage().checkoutProducts();
		Reporter.log("Checkout cart products");
		
		//Validate is mailing information page
		Assert.assertTrue(SauceDemoPages.sdMailingInformationPage().isAt());
		Reporter.log("At mailing information page");
		
		//Fill mailing information with missing info
		SauceDemoPages.sdMailingInformationPage().fillMailingSectionWithMissingInfo("Test", "Test");
		Reporter.log("Mailing information submited");
		
		//Validate error message is displayed
		Assert.assertTrue(SauceDemoPages.sdMailingInformationPage().isErrorMessageDisplayed());
		Reporter.log("Error Message Displayed");
	}
	
	@Test
	public void fillMailingInformation() {
		//Validate is at login page
		Assert.assertTrue(SauceDemoPages.sdLoginPage().isAt());
		Reporter.log("At login page");
								
		//Enter username and password
		SauceDemoPages.sdLoginPage().login("standard_user", "secret_sauce");
		Reporter.log("Logging in");
				
		//Validate is at inventory page
		Assert.assertTrue(SauceDemoPages.sdInventoryPage().isAt());
		Reporter.log("At inventory page");
				
		//Add one item to the cart
		SauceDemoPages.sdInventoryPage().addItemsToCart(1);
		Reporter.log("Item added to cart");
		
		//Open cart
		SauceDemoPages.sdShoppingCartPage().clickOnCart();
		Reporter.log("Opening cart page");
		
		//Validate is at cart page
		Assert.assertTrue(SauceDemoPages.sdShoppingCartPage().isAt());
		Reporter.log("At cart page");
		
		//Checkout cart products
		SauceDemoPages.sdShoppingCartPage().checkoutProducts();
		Reporter.log("Checkout cart products");
		
		//Validate is mailing information page
		Assert.assertTrue(SauceDemoPages.sdMailingInformationPage().isAt());
		Reporter.log("At mailing information page");
		
		//Fill mailing information
		SauceDemoPages.sdMailingInformationPage().fillMailingSection("Test", "Test","123456");
		Reporter.log("Mailing information submited");
		
		//Validate is at overview page
		Assert.assertTrue(SauceDemoPages.sdOverviewPage().isAt());
		Reporter.log("At overview page");
	}
	
	@Test
	public void validateItemsInCartAndOverviewPages() {
		int numberOfItems = 3;
		
		//Validate is at login page
		Assert.assertTrue(SauceDemoPages.sdLoginPage().isAt());
		Reporter.log("At login page");
								
		//Enter username and password
		SauceDemoPages.sdLoginPage().login("standard_user", "secret_sauce");
		Reporter.log("Logging in");
				
		//Validate is at inventory page
		Assert.assertTrue(SauceDemoPages.sdInventoryPage().isAt());
		Reporter.log("At inventory page");
				
		//Add one item to the cart
		SauceDemoPages.sdInventoryPage().addItemsToCart(numberOfItems);
		Reporter.log("3 items added to cart");
		
		//Open cart
		SauceDemoPages.sdShoppingCartPage().clickOnCart();
		Reporter.log("Opening cart page");
		
		//Validate is at cart page
		Assert.assertTrue(SauceDemoPages.sdShoppingCartPage().isAt());
		Reporter.log("At cart page");
		
		//Checkout cart products
		SauceDemoPages.sdShoppingCartPage().checkoutProducts();
		Reporter.log("Checkout cart products");
		
		//Validate is mailing information page
		Assert.assertTrue(SauceDemoPages.sdMailingInformationPage().isAt());
		Reporter.log("At mailing information page");
		
		//Fill mailing information with missing info
		SauceDemoPages.sdMailingInformationPage().fillMailingSection("Test", "Test","123456");
		Reporter.log("Mailing information submited");
		
		//Validate is at overview page
		Assert.assertTrue(SauceDemoPages.sdOverviewPage().isAt());
		Reporter.log("At overview page");
		
		//Validate products in cart and in overview page are the same
		Assert.assertTrue(SauceDemoPages.sdOverviewPage().areProductNamesEquals());
		Reporter.log("Products are correct");
	}
	
	@Test
	public void completeOrder() {
		int numberOfItems = 3;
		
		//Validate is at login page
		Assert.assertTrue(SauceDemoPages.sdLoginPage().isAt());
		Reporter.log("At login page");
								
		//Enter username and password
		SauceDemoPages.sdLoginPage().login("standard_user", "secret_sauce");
		Reporter.log("Logging in");
				
		//Validate is at inventory page
		Assert.assertTrue(SauceDemoPages.sdInventoryPage().isAt());
		Reporter.log("At inventory page");
				
		//Add one item to the cart
		SauceDemoPages.sdInventoryPage().addItemsToCart(numberOfItems);
		Reporter.log("3 items added to cart");
		
		//Open cart
		SauceDemoPages.sdShoppingCartPage().clickOnCart();
		Reporter.log("Opening cart page");
		
		//Validate is at cart page
		Assert.assertTrue(SauceDemoPages.sdShoppingCartPage().isAt());
		Reporter.log("At cart page");
		
		//Checkout cart products
		SauceDemoPages.sdShoppingCartPage().checkoutProducts();
		Reporter.log("Checkout cart products");
		
		//Validate is mailing information page
		Assert.assertTrue(SauceDemoPages.sdMailingInformationPage().isAt());
		Reporter.log("At mailing information page");
		
		//Fill mailing information with missing info
		SauceDemoPages.sdMailingInformationPage().fillMailingSection("Test", "Test","123456");
		Reporter.log("Mailing information submited");
		
		//Validate is at overview page
		Assert.assertTrue(SauceDemoPages.sdOverviewPage().isAt());
		Reporter.log("At overview page");
		
		//Complete order
		SauceDemoPages.sdOverviewPage().completeOrder();
		Reporter.log("Click on complete order");
		
		//Validate order is completed
		Assert.assertTrue(SauceDemoPages.sdOrderCompletedPage().isThanksTextDisplayed());
		Reporter.log("Order completed succesfully");
	}

}
