package by.htp.mail.pages;


import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailPage extends AbstractPage{

	private final Logger logger = LogManager.getRootLogger();
	private static final String BASE_URL = "https://mail.google.com/mail/u/0/#inbox";
	
	public MailPage(WebDriver driver) {
		super(driver);
	PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage() {
		driver.navigate().to("BASE_URL");
		logger.info("Login page opened");
		
	}

	@FindBy(xpath="//div[contains(text(),'НАПИСАТЬ')]")
	private WebElement writeButton;
	
	@FindBy(xpath="//textarea[@aria-label='Кому']")
	private WebElement inputAdress;
	
	@FindBy(xpath="//input[@name='subjectbox']")
	private WebElement inputTheme;

	@FindBy(xpath="//div[@class='Am Al editable LW-avf']")
	private WebElement inputMessage;

	@FindBy(xpath="//div[contains(text(),'Отправить')]")
	private WebElement sendButton;
	
	
	@FindBy(className="bog")
	private List<WebElement> lettersTheme;
	
	
	
	

public void sendLetter(String adress,String theme,String message) throws InterruptedException {
	WebDriverWait wait = new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'НАПИСАТЬ')]")));
	writeButton.click();
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@aria-label='Кому']")));
	inputAdress.sendKeys(adress);
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='subjectbox']")));
	inputTheme.sendKeys(theme);
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='Am Al editable LW-avf']")));
	inputMessage.sendKeys(message);
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Отправить')]")));
	sendButton.click();
}

public List<WebElement> getLettersTheme() {
	
	List<WebElement> lettersThm=driver.findElements(By.className("bog"));
	return lettersThm;



}
















}

