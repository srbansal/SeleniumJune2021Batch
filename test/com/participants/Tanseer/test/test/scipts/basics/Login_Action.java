package scipts.basics;
import org.openqa.selenium.WebDriver;

public class Login_Action {

	public static void execute(WebDriver driver) {
		// TODO Auto-generated method stub
		Login_Page.txt_Username(driver).sendKeys("nidhipatni12@yahoo.com");
		Login_Page.btn_signin(driver).click();
		Login_Page.txt_Password(driver).sendKeys("Student@123");
		Login_Page.verify_Password(driver).click();
	}
	

	

}