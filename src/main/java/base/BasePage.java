package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class BasePage {

	public WebDriver driver;
	private Properties prop;
	private String url;

	public BasePage() throws IOException {
		prop = new Properties();
		FileInputStream data = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\resource\\Config.Properties");
		prop.load(data);
	}

	public WebDriver getDriver() throws IOException
	{
		return WebDriverInstance.getDriver();
		
	}
	
	public String geturl() throws IOException
	{
		url = prop.getProperty("url");
		
		return url;
		
	}
	public void takeSnapShot(String name) throws IOException {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		File destFile = new File(System.getProperty("user.dir") + "\\target\\screenshorts"
				+ timestamp() + ".png");

		FileUtils.copyFile(srcFile, destFile);
	}

	public String timestamp() {
		return new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());
	}
	

}
