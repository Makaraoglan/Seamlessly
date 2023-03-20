package net.seamlessly.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Driver {
	//Singleton Design Pattern we use
	private Driver(){}

	//private static WebDriver driver;

	private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();

	public static WebDriver getDriver(){

		if (driverPool.get() == null){
			String browserType = ConfigurationReader.getProperty("browser");

			switch (browserType){
				case "chrome":
					ChromeOptions options = new ChromeOptions();
					Map<String, Object> prefs = new HashMap<String, Object>();
					prefs.put("intl.accept_languages", "en-GB");
					options.setExperimentalOption("prefs", prefs);
					WebDriverManager.chromedriver().setup();
					//WebDriver driver = new ChromeDriver(options);
					driverPool.set(new ChromeDriver(options));
					driverPool.get().manage().window().maximize();
					driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					break;
					/*WebDriverManager.chromedriver().setup();
					driverPool.set(new ChromeDriver());
					driverPool.get().manage().window().maximize();
					driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					break;*/
				case "firefox":
					WebDriverManager.firefoxdriver().setup();
					driverPool.set(new FirefoxDriver());
					driverPool.get().manage().window().maximize();
					driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					break;
				case "edge":
					WebDriverManager.edgedriver().setup();
					driverPool.set(new EdgeDriver());
					driverPool.get().manage().window().maximize();
					driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					break;
				default:
			}
		}
		return driverPool.get();
	}

	/*
	this method will make sure our driver value is always null after using quit()method
	 */
	public static void closeDriver(){
		if (driverPool.get()!= null){
			driverPool.get().quit();
			//driverPool.set(null);
			driverPool.remove();
		}

	}
}
