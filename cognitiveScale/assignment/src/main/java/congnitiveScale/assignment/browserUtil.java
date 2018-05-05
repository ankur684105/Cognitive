package congnitiveScale.assignment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class browserUtil {
	static WebDriver driver;

	public static WebDriver selectBrowserToStart(String browser, String url) {
		String Browser = browser.toLowerCase();
		if (Browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"/Users/ankurmarkanda/Documents/Selenium WebDriver/chromedriver");
			driver = new ChromeDriver();
		} else if (Browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"/Users/ankurmarkanda/Documents/Selenium WebDriver/geckodriver");
			driver = new ChromeDriver();
		} else if (Browser.equals("safari")) {
			driver = new SafariDriver();
		}

		driver.get(url);
		return driver;

	}

}
