package by.htp.mail.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends AbstractPage {

	private final Logger logger = LogManager.getRootLogger();
	private static final String BASE_URL = "http://www.gmail.com";

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage() {
		driver.navigate().to("BASE_URL");
		logger.info("Login page opened");
	}

	@FindBy(xpath = "//input[@type='email']")
	private WebElement enterLogin;

	@FindBy(xpath = "//input[@type='password']")
	private WebElement enterPassword;

	@FindBy(xpath = "//span[@class='gb_db gbii']")
	private WebElement enterAccountUser;

	@FindBy(xpath = "//div[@class='gb_Cb']//div[@class='gb_Ib']")
	private WebElement logedInUserName;

	@FindBy(css = "#identifierNext")
	private WebElement nextlogin;

	@FindBy(css = "#passwordNext")
	private WebElement nextPass;



	public void login(String login, String password) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type=email]")));
		enterLogin.sendKeys(login);
		nextlogin.click();
	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type=password]")));
		enterPassword.sendKeys(password);
		nextPass.click();
		logger.info("Login performed");
	}

	public String getLoggedInUserName() {
		enterAccountUser.click();
		return logedInUserName.getText();
	}

}