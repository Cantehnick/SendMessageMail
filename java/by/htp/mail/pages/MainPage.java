package by.htp.mail.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPage{


	private static final String BASE_URL = "http://www.gmail.com";
	
	public MainPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage() {
	driver.navigate().to(BASE_URL);
	
	}

	@FindBy(xpath="//p[contains(text(),'Use another account')]")
	private WebElement enterAccount;


public void clickOnEnterAccount() {
	enterAccount.click();
}












}
