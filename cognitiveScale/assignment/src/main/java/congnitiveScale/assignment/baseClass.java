package congnitiveScale.assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class baseClass {
	WebDriver driver;
	WebDriverWait wait;

	public baseClass(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void putImplicitWait(int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

}
