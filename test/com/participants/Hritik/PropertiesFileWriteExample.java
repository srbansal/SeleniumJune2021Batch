
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileWriteExample {
	public static void main(String[] args) throws IOException {

			FileReader reader = new FileReader("files/info.properties");
			Properties p = new Properties();
			p.load(reader);
			
			
			p.setProperty("baseUrl", "https://www.google.com/");
			p.store(new FileWriter("files/config.properties"), "Properties Example");
			
			
			
			
			
			
			
			
			
			
			
			
		}
}
