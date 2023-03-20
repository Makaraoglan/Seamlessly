package net.seamlessly.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
	//create the object of Properties class
	private static Properties properties = new Properties();

	static {
		try {
			//we need to open the file in java memory:FileInputStream
			FileInputStream file = new FileInputStream("configuration.properties");

			//load the properties object using FileInputStream object
			properties.load(file);

			//close the file
			file.close();

		} catch (IOException e) {
			System.out.println("file not found in the configurationReader class");
			e.printStackTrace();
		}

	}
	public static String getProperty(String keyword){
		return properties.getProperty(keyword);
	}
}
