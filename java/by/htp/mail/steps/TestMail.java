package by.htp.mail.steps;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestMail {

	private Steps steps;
	private final String USERNAME = "cantehnick@gmail.com";
	private final String PASSWORD = "r2d2749136";

	private final String ADRESS = "bullzeye1983@gmail.com";
	private final String THEME = "Test letter";
	private final String MESSAGE = "Hello!";

	private final String REPLY_MESSAGE = "How are you?";
	private final String THEME_LETTER = "1307198313071983";//3

	@BeforeMethod(description = "Init browser")
	public void setUp() {
		steps = new Steps();
		steps.initBrowser();
	}

	 @Test(description = "Login to Gmail")
	 public void oneCanLoginGmail() {
	 steps.loginGmail(USERNAME, PASSWORD);
	 String actual = steps.isLoggedIn();
	
	 Assert.assertEquals(actual, USERNAME);
	 }
	
	 @Test(description = "Send Email ")
	 public void testSendEmail() throws InterruptedException {
	 steps.loginGmail(USERNAME, PASSWORD);
	 String actual = steps.sendEmail(ADRESS, THEME, MESSAGE);
	
	 Assert.assertEquals(actual, THEME);
	 }

	@Test(description = "Contains theme letter  ")
	public void testContainLetter() throws InterruptedException {
		steps.loginGmail(USERNAME, PASSWORD);
		for (WebElement thm : steps.getLetters()) {
			if (thm.getText().toUpperCase().equals(THEME_LETTER)) {
			steps.sendEmail(ADRESS, THEME, REPLY_MESSAGE);
			}
		}

	// if (steps.getLetters().contains(THEME_LETTER)) {
		// steps.sendEmail(ADRESS, THEME, REPLY_MESSAGE);
		// }
		Assert.assertEquals("1307198313071983", THEME_LETTER);

	}

}
