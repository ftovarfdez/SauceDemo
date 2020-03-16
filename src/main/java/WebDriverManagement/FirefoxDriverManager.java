package WebDriverManagement;

import java.io.File;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

public class FirefoxDriverManager extends DriverManager{
	private GeckoDriverService firefoxService;

    @Override
    public void startService() {
        if (null == firefoxService) {
            try {
            	firefoxService = new GeckoDriverService.Builder()
                    .usingDriverExecutable(new File("src/main/resources/geckodriver.exe"))
                    .usingAnyFreePort()
                    .build();
                firefoxService.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void stopService() {
        if (null != firefoxService && firefoxService.isRunning())
            firefoxService.stop();
    }

    @Override
    public void createDriver() {
        driver = new FirefoxDriver(firefoxService);
    }

}
