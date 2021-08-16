package day1;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingData {
public static void main(String[] args) throws Exception {
		
		//this is for taking file as a input
		XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream("C:\\Users\\Nidhi\\Desktop\\data.xlsx"));
		
		//Reading Sheet
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		
		//Reading Data
//		String pwd=sheet.getRow(1).getCell(1).toString();//in index format number starts from 0
//		
//		System.out.println(pwd);
		
		//printing how many rows are there
		int rowNum = sheet.getLastRowNum(); //LastRowNum return index number of rows 
		System.out.println("Index of last row" +rowNum);
		
		//printing number of cells in each row
		int colNum=sheet.getRow(0).getLastCellNum(); //LastCellNum will return actual number of cells not than index count by default
		System.out.println("Index of last cell is " +colNum);
		
		for(int i=0;i<=rowNum;i++)
		{
		    String un=sheet.getRow(i).getCell(0).toString();
		    String pwd=sheet.getRow(i).getCell(1).toString();
		    System.out.print(un+" ");
		    System.out.println(pwd);
		    
		}
		
		workbook.close();
		
		
}

}
