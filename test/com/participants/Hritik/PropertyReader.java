
/*
 * Challenge
In selenium project, create a new class PropertyReader
include a static method to get value of a property e.g. getProperty()
PropertyReader.getProperty(baseUrl)
etc...
Use these properties in the Selenium Script
*/



package scripts.basics;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

class PropertyReader {
	static String getProperties(String s) throws IOException {
		FileReader reader = new FileReader("files/info.properties");
		Properties p = new Properties();
		p.load(reader);
		return (p.getProperty(s));
	}


}
