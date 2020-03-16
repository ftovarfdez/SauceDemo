package Extensions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.BaseTest;

public class WaitExtensions{
	
	
	public static void waitForPageToLoad(int timeOut) {
		final WebDriverWait wait = new WebDriverWait(BaseTest.driver, timeOut);
		wait.until((ExpectedCondition<Boolean>) drv -> (Boolean) ((JavascriptExecutor) drv).executeScript("return document.readyState").equals("complete"));
	}
	
	public static void waitForVisibilityOfElement (WebElement element) {
		final WebDriverWait wait = new WebDriverWait(BaseTest.driver, 5);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
}
