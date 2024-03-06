package orderCompletion;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import base.Hooks;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.NewAccountCreate;

public class CreateNewAccount extends Hooks{
	
	public CreateNewAccount() throws IOException
	{
		super();
	}
	
	@Test
	public void newAccount() throws IOException, InterruptedException
	{
		
		HomePage home = new HomePage();
		Thread.sleep(5000);
		home.getToggle().click();
		Thread.sleep(2000);
		home.getTestStoreLink().click();
		
		LoginPage loginpage = new LoginPage();
		loginpage.getClickOnSignInButton().click();
		Thread.sleep(2000);
		
		loginpage.getNewAccountCreate().click();
		
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
