package day1;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
 
//import org.apache.poi.hssf.usermodel.HSSFCell;
//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;


public class ReadWriteExcel {
	WebDriver driver;
    WebDriverWait wait;
    XSSFWorkbook workbook;
    XSSFSheet sheet;
    XSSFCell cell;
 @BeforeTest
  public void TestSetup() {
	// Set the path of the Firefox driver.
	    System.setProperty("webdriver.gecko.driver", "test/resources/geckodriver.exe");
	    driver = new FirefoxDriver();
	     
	    // Enter url.
	    driver.get("http://www.linkedin.com/");
	    driver.manage().window().maximize();
	     
	    wait = new WebDriverWait(driver,30);
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }
  @Test
  public void ReadData() throws IOException {
//	// Import excel sheet.
//	     File src=new File("C:\\Users\\Nidhi\\Desktop\\data.xlsx");
//	      
//	     // Load the file.
//	     FileInputStream finput = new FileInputStream(src);
//	      
//	     // Load he workbook.
//	    workbook = new XSSFWorkbook(finput);
//	      
//	     // Load the sheet in which data is stored.
//	     sheet= workbook.getSheetAt(2);
	  
	  XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream("C:\\Users\\Nidhi\\Desktop\\data.xlsx"));
		
		//Reading Sheet
		XSSFSheet sheet=workbook.getSheet("Sheet3");
	      
	     for(int i=1; i<=sheet.getLastRowNum(); i++)
	     {
	         // Import data for Email.
	         cell = sheet.getRow(i).getCell(1);
	         cell.setCellType(CellType.STRING);
	         driver.findElement(By.id("login-email")).sendKeys(cell.getStringCellValue());
	          
	         // Import data for password.
	         cell = sheet.getRow(i).getCell(2);
	         cell.setCellType(CellType.STRING);
	         driver.findElement(By.id("login-password")).sendKeys(cell.getStringCellValue());
  }
  }
}




