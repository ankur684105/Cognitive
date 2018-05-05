package congnitiveScale.assignment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class propertiesReader {
	
	public static String getValue(String desiredValue) {
		InputStream is = null;
		Properties prop = null;
		String value = null;
		try {
			prop = new Properties();
			is = new FileInputStream(new File(System.getProperty("user.dir")+"/src/main/java/congnitiveScale/assignment/data.properties"));
			prop.load(is);
			value = prop.getProperty(desiredValue.toLowerCase());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;
	}

}
