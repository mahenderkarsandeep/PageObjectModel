package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverInstance 
{
	

	public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
	public static WebDriver getDriver(){
		if(driver.get() == null)
		{
			try {
				driver.set(createDriver());
			}catch(IOException e){
				e.printStackTrace();
				
			}
		}
		return driver.get();
		
	}

	public static WebDriver createDriver() throws IOException {
		
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		WebDriver driver = new ChromeDriver(options);
		
		/*
		 * WebDriver driver = null; Properties prop = new Properties(); FileInputStream
		 * data = new FileInputStream( System.getProperty("user.dir") +
		 * "\\src\\main\\java\\resource\\Config.Properties"); prop.load(data);
		 * 
		 * if (prop.getProperty("browser").equals("Chrome")) {
		 * System.setProperty("webdriver.chrome.driver",
		 * "D:\\Selenium Frameworks\\NormalSeleniumprograms\\Drivers\\chromedriver.exe"
		 * ); driver = new ChromeDriver(); } else if
		 * (prop.getProperty("browser").equals("firefox")) {
		 * System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") +
		 * "\\src\\main\\java\\drivers\\geckodriver.exe"); driver = new FirefoxDriver();
		 * } else { System.setProperty("webdriver.edge.driver",
		 * System.getProperty("user.dir") +
		 * "\\src\\main\\java\\drivers\\msedgedriver.exe"); driver = new EdgeDriver(); }
		 */

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;
	}
	
	public static void cleanUpDriver()
	{
		driver.get().quit();
		driver.remove();
		
	}
	
}
