package orderCompletion;

import java.io.IOException;


import org.openqa.selenium.support.ui.Select;

import org.testng.Assert;

import org.testng.annotations.Test;


import base.Hooks;
import pageObjects.HomePage;
import pageObjects.ShopContentPanel;
import pageObjects.ShopProductPage;
import pageObjects.ShoppingCart;
import pageObjects.ShoppingHomePage;

public class AddRemoveItemFromBasketTest extends Hooks{

	public AddRemoveItemFromBasketTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Test
	public void addRemoveItem() throws IOException, InterruptedException
	{
		// creating an object of the automationtesting.co.uk webpage
				HomePage home = new HomePage();
				
				Thread.sleep(5000);
				
				home.getToggle().click();
				Thread.sleep(5000);
				
				home.getTestStoreLink().click();
				
				//handle cookie visibility using JSE - added 20230217
				/*
				 * JavascriptExecutor jse = (JavascriptExecutor)getDriver();
				 * jse.executeScript("arguments[0].scrollIntoView()", home.getTestStoreLink());
				 * home.getTestStoreLink().click();
				 */

				// creating an object of the test store homepage
				ShoppingHomePage shopHome = new ShoppingHomePage();
				shopHome.getProdOne().click();

				// creating an object of the shop products page (when a product has been
				// selected)
				ShopProductPage shopProd = new ShopProductPage();
				Select option = new Select(shopProd.getSizeOption());
				option.selectByVisibleText("M");
				shopProd.getQuantIncrease().click();
				shopProd.getAddToCartBtn().click();

				// creating an object of the cart content panel (once an item was added)
				ShopContentPanel cPanel = new ShopContentPanel();
				cPanel.getContinueShopBtn().click();
				shopProd.getHomepageLink().click();
				shopHome.getProdTwo().click();
				shopProd.getAddToCartBtn().click();
				cPanel.getCheckoutBtn().click();
				Thread.sleep(5000);

				// creating an object for the shopping cart page and deleting item 2
				ShoppingCart cart = new ShoppingCart();
				cart.getDeleteItemTwo().click();
				
				Thread.sleep(5000);

				// using a wait to ensure the deletion has taken place
				//WebDriverWait wait = new WebDriverWait(driver, 120);
				//wait.until(ExpectedConditions.invisibilityOf(cart.getDeleteItemTwo()));

				// printing the total amount to console
				System.out.println(cart.getTotalAmount().getText());
				
				// using an assertion to make sure the total amount is what we are expecting
				Assert.assertEquals(cart.getTotalAmount().getText(), "$45.24");

			}
	}
	


