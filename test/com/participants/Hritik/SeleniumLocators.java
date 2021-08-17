package scripts.basics;

import org.testng.annotations.Test;



import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class SeleniumLocators {
	WebDriver driver;
	String baseURL = "https://www.amazon.in/";

	@Test
	public void id_Name() throws Exception {// Sakshi

		driver.manage().window().maximize();
		driver.get(baseURL);

		driver.findElement(By.id("twotabsearchtextbox")).click();
		driver.findElement(By.name("field-keywords")).sendKeys("watches");
		driver.findElement(By.id("nav-search-submit-button")).click();
	}

	@Test
	public void zidClass() throws InterruptedException { // Amruta
		driver.get(baseURL);
		driver.findElement(By.id("twotabsearchtextbox")).click();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("shoes");

		driver.findElement(By.id("nav-search-submit-button")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.className("s-image")).click();
		Thread.sleep(2000);
		
		
	}

	@Test
	public void amazonTagName() throws IOException { // Vaibhav
		System.out.println("Inside Function");
		driver.manage().window().maximize();
		driver.get(baseURL);
		java.util.List<WebElement> links = driver.findElements(By.tagName("a"));

		for (WebElement link : links) {
			System.out.println(link.getText() + "-->" + link.getAttribute("href"));
		}
		driver.findElement(
				By.xpath("//a[@href = '/gp/sva/dashboard?ref_=nav_cs_apay_fe0c735739554ca1a7cccf7c41941f2f']")).click();
	}

	@Test
	public void linkText() { // Hritik

		driver.get(baseURL);
		System.out.println(driver.findElement(By.linkText("All")).toString());
	}

	@Test
	public void partialLinkText() { // Hritik
		driver.get(baseURL);
		System.out.println(driver.findElement(By.partialLinkText("Pay")).toString());

	}

	@Test
	public void xPath() throws InterruptedException { // Anurag

		
		driver.manage().window().maximize();

		driver.get(baseURL);

		WebElement e = driver.findElement(By.xpath("//div[@class='nav-search-field ']//input[@type='text']"));
		e.sendKeys("OnePlus 9 pro");

		driver.findElement(By.xpath(
				"//div[@class='nav-search-submit nav-sprite']//span[@class='nav-search-submit-text nav-sprite nav-progressive-attribute']//input[@class='nav-input nav-progressive-attribute']"))
				.click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[@id='nav-logo']//a[@class='nav-logo-link nav-progressive-attribute']"))
				.click();

	}

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "test/resources/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
