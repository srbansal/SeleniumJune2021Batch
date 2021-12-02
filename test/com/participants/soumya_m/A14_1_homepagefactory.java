package com.participants.soumya_m;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class A14_1_homepagefactory {
	WebDriver driver;
	@FindBy(xpath = "//h1")
	WebElement Header;
	@FindBy(xpath = "//*[@id='signupModalButton']")
	WebElement getStarted;

	public A14_1_homepagefactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}

		public void veryHeader() {
		String getheadertext = Header.getText();
		assertEquals("App & Browser Testing Made Easy", getheadertext);
		}
		public void clickOnGetStarted() {
		getStarted.click();
		}
}
