package by.htp.mail.steps;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import by.htp.mail.driver.DriverSingleton;
import by.htp.mail.pages.LoginPage;
import by.htp.mail.pages.MailPage;
import by.htp.mail.pages.MainPage;

public class Steps {

	private WebDriver driver;

	private final Logger logger = LogManager.getRootLogger();

	public void initBrowser() {
		driver = DriverSingleton.getDriver();
	}

	public void closeDriver() {
		DriverSingleton.closeDriver();
	}

	public void loginGmail(String login, String password) {
		LoginPage loginPage = new LoginPage(driver);
		MainPage mainPage = new MainPage(driver);
		mainPage.openPage();
		loginPage.login(login, password);
	}

	public String isLoggedIn() {
		LoginPage loginPage = new LoginPage(driver);
		String actualUsername = loginPage.getLoggedInUserName().trim().toLowerCase();
		logger.info("Actual username: " + actualUsername);
		return actualUsername;
	}

	public String sendEmail(String adress, String theme, String message) throws InterruptedException {
		MailPage mailpage = new MailPage(driver);
		mailpage.sendLetter(adress, theme, message);
		logger.info("Letter sent to   " + theme);
		return theme;
	}

	public List<WebElement> getLetters() {
		MailPage mailpage = new MailPage(driver);
		mailpage.getLettersTheme();
		return mailpage.getLettersTheme();
	}

}
