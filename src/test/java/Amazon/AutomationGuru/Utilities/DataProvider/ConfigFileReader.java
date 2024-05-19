package Amazon.AutomationGuru.Utilities.DataProvider;

import java.util.Properties;

import org.testng.annotations.Test;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
public class ConfigFileReader {

	private  static Properties pros;
	private final static String configFilePath = "TestData/config.properties";  
	
	
	public  static void loadPropertyFile () throws IOException {
		File  configFile=new File(configFilePath);
		FileInputStream configFileReader=new FileInputStream(configFile);
	      pros = new Properties();	      
	      pros.load(configFileReader);  
	}
	
		public static  String  getApplicationUrl () throws IOException {
           loadPropertyFile();
		String Url = pros.getProperty("app.url");
			return Url;
	}
     
		
		public static String  getBrowserl () throws IOException {
	           loadPropertyFile();
			String browser = pros.getProperty("app.browser");
				return browser;
		}

}
