package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BasePage;

public class NewAccountCreate extends BasePage
{
	
	public WebDriver driver;
	
		By mr = By.xpath("//label[normalize-space()='Mr.']");
		By mrs = By.xpath("//input[@value='2']");
		By first_name = By.xpath("//input[@name='firstname']");
		By last_name = By.xpath("//input[@name='lastname']");
		By email = By.xpath("//input[@name='email']");
		By password = By.xpath("//input[@title='At least 5 characters long']");
		By date = By.xpath("//input[@placeholder='MM/DD/YYYY']");
		By agree = By.xpath("//input[@name='psgdpr']");
		By saveButton = By.xpath("//button[normalize-space()='Save']");
		
		
		public NewAccountCreate() throws IOException
		{
			super();
		}
		
		
		public WebElement getMr() throws IOException {
			this.driver = getDriver();
			return driver.findElement(mr);
		}
		
		public WebElement getMrs() throws IOException {
			this.driver = getDriver();
			return driver.findElement(mrs);
		}

		public WebElement get_First_name() throws IOException {
			this.driver = getDriver();
			return driver.findElement(first_name);
		}
		
		public WebElement get_Last_Name() throws IOException {
			this.driver = getDriver();
			return driver.findElement(last_name);
		}
		
		public WebElement get_Email() throws IOException {
			this.driver = getDriver();
			return driver.findElement(email);
		}
		
		public WebElement get_Password() throws IOException {
			this.driver = getDriver();
			return driver.findElement(password);
		}
		
		public WebElement get_Date() throws IOException {
			this.driver = getDriver();
			return driver.findElement(date);
		}
		
		public WebElement get_Agree() throws IOException {
			this.driver = getDriver();
			return driver.findElement(agree);
		}
		
		public WebElement get_save_button() throws IOException {
			this.driver = getDriver();
			return driver.findElement(saveButton);
		}
}
