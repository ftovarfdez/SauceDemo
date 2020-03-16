package Pages;

import org.openqa.selenium.support.PageFactory;

import Base.BaseTest;
public class SauceDemoPages {
	
	
	static <T> T getPage(Class <T> pageClass){
		
		T page = null;
		 
		try {
			page = pageClass.newInstance();
			PageFactory.initElements(BaseTest.driver, page);
		}catch (Exception e) {
			
		}
		return page;
	}
	
	public static SDLoginPage sdLoginPage() {
		return getPage(SDLoginPage.class);
	}
	
	public static SDInventoryPage sdInventoryPage() {
		return getPage(SDInventoryPage.class);
	}
	
	public static SDLeftMenu sdLeftMenu() {
		return getPage(SDLeftMenu.class);
	}
	
	public static SDShoppingCartPage sdShoppingCartPage() {
		return getPage(SDShoppingCartPage.class);
	}
	
	public static SDMailingInformationPage sdMailingInformationPage() {
		return getPage(SDMailingInformationPage.class);	
	}

	public static SDOverviewPage sdOverviewPage() {
		return getPage(SDOverviewPage.class);	
	}
	
	public static SDOrderCompletedPage sdOrderCompletedPage() {
		return getPage(SDOrderCompletedPage.class);	
	}
}
