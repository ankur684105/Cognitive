package congnitiveScale.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class automationTest {
	WebDriver driver;
	citrusPayPageObject page;

	@BeforeClass
	public void preTestSetup() {
		driver = browserUtil.selectBrowserToStart("Chrome",propertiesReader.getValue("url"));
		page = new citrusPayPageObject(driver);
	}

	@Test(priority = 1, alwaysRun = true)
	public void loginTest() {
		page.loginToCitrus("connectankur03@gmail.com", "Ankur@93");
	}

	@Test(priority = 2)
	public void validateWithDrawWindowPane() {
		Assert.assertTrue(page.validateWithdrawPage());

	}

	@Test(priority = 3)
	public void validateZeroErrorMessage() {
		Assert.assertTrue(page.validateLowAmountError("200"));
		driver.findElement(By.xpath("//*[@id='withdrawCashPopupCloseBtn']")).click();
	}

	@Test(priority = 4)
	public void validateKYCMessage() {
		Assert.assertTrue(page.validateKYCblocker());
	}

	@Test(priority = 5)
	public void colorTest() {
		Assert.assertEquals("rgba(51, 51, 51, 1)", page.getAddMoneyButtonColor());
	}

	@Test(priority = 6)
	public void fontTest() {
		Assert.assertEquals("Roboto", page.getElementFontEditProfileLink());
	}	
	@AfterClass
	public void postTest() {
		driver.quit();
	}

}
