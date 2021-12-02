package ThreadConcept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Parametrizedxml {
	WebDriver driver;
	@Parameters({"suite-param"})
  @Test (description="Search term in google")
  public void GoogleSearch(String param) throws Exception {
		driver.get("https://www.google.com/");
		driver.findElement(By.id("gbqfq")).clear();
		driver.findElement(By.id("gbqfq")).sendKeys(param);
		driver.findElement(By.id("gbqfb")).clear();
		System.out.println(driver.getTitle());
		driver.quit();
  }
}
