package WebDriverManagement;

public class DriverManagerFactory {
	public static DriverManager getManager(DriverType type) {

        DriverManager driverManager;

        switch (type) {
        	case CHROME:
        		driverManager = new ChromeDriverManager();
        
        	case FIREFOX:
        		driverManager = new FirefoxDriverManager();
        		
            default:
            	driverManager = new ChromeDriverManager();
                
        }
        return driverManager;

    }

}
