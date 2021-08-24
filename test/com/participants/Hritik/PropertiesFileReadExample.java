import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileReadExample {
	public static void main(String[] args) throws IOException {

		FileReader reader = new FileReader("files/info.properties");
		Properties p = new Properties();
		p.load(reader);
		
		System.out.println(p.getProperty("url"));
		System.out.println(p.getProperty("browser"));
		System.out.println(p.getProperty("email"));
		System.out.println(p.getProperty("password"));
		
		
		
		
		
		
		
		
		
		
		
	}
}
