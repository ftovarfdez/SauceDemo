package Extensions;

import Base.BaseTest;

public class BrowserExtensions {

	public static String getCurrentURL() {
		return BaseTest.driver.getCurrentUrl();
	}
}
