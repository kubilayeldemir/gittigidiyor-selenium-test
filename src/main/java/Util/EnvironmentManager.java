package Util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EnvironmentManager {
	public static WebDriver initWebDriver() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
	    return driver;
	}
	public static void shutDownDriver(WebDriver driver) {
		driver.quit();
	}
}
