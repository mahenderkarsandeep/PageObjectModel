package orderCompletion;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.Hooks;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.NewAccountCreate;

public class LoginTest extends Hooks 
{
	public CreateNewAccount createnewaccount;
	
	public LoginTest() throws IOException {
		super();
	}

	@Test
	public void login() throws IOException, InterruptedException {

		HomePage home = new HomePage();
		Thread.sleep(5000);
		home.getToggle().click();
		Thread.sleep(2000);
		home.getTestStoreLink().click();

		LoginPage login = new LoginPage();

		login.getClickOnSignInButton().click();
		Thread.sleep(2000);
		login.getEmail().sendKeys("sandeep@test.com");
		login.getPassword().sendKeys("test123");
		login.getclickSigninButton().click();

		String title = login.getTitle();

		if (title.equalsIgnoreCase("My account")) 
		{
			System.out.println("Login successful");	
		}
			 else  {	
				 
				System.out.println("User entered invalid credentials");	
				WebElement element = login.getNewAccountCreate();
				element.click();
				NewAccountCreate newAccountcreate = new NewAccountCreate();
				newAccountcreate.getMr().click();
				newAccountcreate.get_First_name().sendKeys("sandeep");
				newAccountcreate.get_Last_Name().sendKeys("mahenderkar");
				newAccountcreate.get_Email().sendKeys("sandeep.mahenderkar@gmail.com");
				newAccountcreate.get_Password().sendKeys("sandeep123");
				newAccountcreate.get_Date().sendKeys("09252023");
				newAccountcreate.get_Agree().click();
				newAccountcreate.get_save_button().click();
			 }	
		}  
	}


