package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import base.BasePage;

public class LoginPage extends BasePage
{
		public WebDriver driver;
		
		
	By singInButton = By.xpath("//span[normalize-space()='Sign in']");	
	By email = By.xpath("//input[@class='form-control']");
	By password = By.xpath("//input[@title='At least 5 characters long']");
	By signIn = By.xpath("//button[@id='submit-login']");
	By CreatenNewAccount = By.xpath("//a[normalize-space()='No account? Create one here']");
		
	 public LoginPage() throws IOException
	 {
		 super();
	 }
	 
	 public WebElement getClickOnSignInButton() throws IOException
	 {
		 this.driver = getDriver();
		 return driver.findElement(singInButton);
	 }
	 
	 public WebElement getEmail() throws IOException
	 {
		 this.driver = getDriver();
		 return driver.findElement(email);
	 }
	 
	 public WebElement getPassword() throws IOException
	 {
		 this.driver = getDriver();
		 return driver.findElement(password);
	 }
	 
	 public WebElement getclickSigninButton() throws IOException
	 {
		 this.driver = getDriver();
		 return driver.findElement(signIn);
	 }
	 
	 public WebElement getNewAccountCreate() throws IOException
	 {
		 this.driver = getDriver();
		 return driver.findElement(CreatenNewAccount);
	 }
	 
	 public String getTitle() throws IOException
	 {
		 this.driver = getDriver();
		 return driver.getTitle();
	 }

	
}
