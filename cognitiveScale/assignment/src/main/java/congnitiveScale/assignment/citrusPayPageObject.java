package congnitiveScale.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;

public class citrusPayPageObject extends baseClass {
	public WebDriver driver;
	JavascriptExecutor executor;
	baseClass base = new baseClass(driver);

	public citrusPayPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	String loginId = "[id=linkUserUserId]";
	String loginButton = "[id=linkUserIdBtn]";
	String loginWithPassword = "[id=passwordOptionContainer]";
	String password = "[id=linkUserPassword]";
	String confirmButton = "[id=emailloginButton]";
	String addMoney = "//*[@id='addBtDiv']/a";
	String kycClearMsg = "//*[@id='citrusErrorMessageForKycUser']";
	String withdrawCash = "btn-withdraw-cash";
	String withdrewCashMsg = "//label[contains(text(),'Enter the amount you want to withdraw')]";
	String withDrawAmount = "//*[@id='withdraw-cash-amount']";
	String proceedButton = "//*[@id='btn-withdraw-cash-continue']";
	String errorMsg = "//*[@id='AddCashStatusFailed' and contains(text(),'Balance is zero')]";

	public void loginToCitrus(String id, String pwd) throws ElementNotVisibleException {
		driver.findElement(By.cssSelector(loginId)).sendKeys(id);
		driver.findElement(By.cssSelector(loginButton)).click();
		driver.findElement(By.cssSelector(loginWithPassword)).click();
		driver.findElement(By.cssSelector(password)).sendKeys(pwd);
		driver.findElement(By.cssSelector(confirmButton)).click();
		driver.findElement(By.xpath("//*[@id='myModal']/div/div/div/a/img")).click();
	}

	public boolean validateWithdrawPage() throws ElementNotVisibleException {

		executor = (JavascriptExecutor) driver;
		executor.executeScript("$('[id=btn-withdraw-cash]').click();");
		return driver.findElement(By.xpath(withdrewCashMsg)).isDisplayed();
	}

	public boolean validateLowAmountError(String amount) throws ElementNotVisibleException {
		driver.findElement(By.xpath(withDrawAmount)).sendKeys(amount);
		driver.findElement(By.xpath(proceedButton)).click();
		return driver.findElement(By.xpath(errorMsg)).isDisplayed();
	}

	public boolean validateKYCblocker() throws ElementNotVisibleException {
		driver.findElement(By.xpath(addMoney)).click();
		return driver.findElement(By.xpath(kycClearMsg)).isDisplayed();
	}

	public String getAddMoneyButtonColor() {
		base.implicitWait(10);
		return driver.findElement(By.xpath("//*[@id='addBtDiv']")).getCssValue("color");

	}

	public void getWithdrawCashButtonCoordinates() {
		base.implicitWait(10);
		Point p = driver.findElement(By.xpath(withdrawCash)).getLocation();
		System.out.println("X Coordinates are " + p.x + "Y Coordinates are " + p.y);
	}

	public String getElementFontEditProfileLink() {
		base.implicitWait(10);
		return driver.findElement(By.xpath("//*[@class='user-links']/a[1]")).getCssValue("font-family");
	}

}
