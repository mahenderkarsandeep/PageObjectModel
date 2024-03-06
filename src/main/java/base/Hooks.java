package base;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Hooks extends BasePage
{
	public Hooks() throws IOException
	{
		super();
	}
	

	@BeforeTest
	public void setUp() throws IOException
	{
		getDriver().get(geturl());
	}
	
	@AfterTest
	public void tearDown()
	{
		WebDriverInstance.cleanUpDriver();
	}
}
