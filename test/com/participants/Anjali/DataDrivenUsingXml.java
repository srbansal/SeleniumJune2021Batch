package scripts.basics;
import javax.xml.parsers.DocumentBuilderFactory;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
public class DataDrivenUsingXml {
	

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		WebDriver driver;
		String url= "http://cookbook.seleniumacademy.com/Config.html";
		System.setProperty("webdriver.chrome.driver", "test/resource/chromedriver.exe");
		driver= new ChromeDriver();
		driver.get(url);
		
		File stocks=new File("D:\\login.xml");
		DocumentBuilderFactory dbFac=DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuil=dbFac.newDocumentBuilder();
		Document doc=dBuil.parse(stocks);
		doc.getDocumentElement().normalize();
		
		System.out.println("root of xml file"+doc.getDocumentElement().getNodeName());
		NodeList nodes=doc.getElementsByTagName("users");
		System.out.println("============================");
		
		for(int i=0;i<nodes.getLength();i++)
		{
			Node node=nodes.item(i);
			
			if(node.getNodeType()==Node.ELEMENT_NODE) {
				Element element=(Element) node;
				String strUname=getValue("uname", element);
				String strPwd=getValue("password", element);
				System.out.println("User name: "+strUname);
				System.out.println("Password : "+strPwd);
				driver.findElement(By.name("userName")).sendKeys(strUname);
				driver.findElement(By.name("password")).sendKeys(strPwd);
				driver.findElement(By.name("login")).click();
				
			}
		}

	}

	private static String getValue(String tag, Element element) {
		NodeList nodes=element.getElementsByTagName(tag).item(0).getChildNodes();
		Node node=(Node) nodes.item(0);
		return node.getNodeValue();
		// TODO Auto-generated method stub
		
	}

}
