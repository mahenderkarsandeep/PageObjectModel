package orderCompletion;

import java.io.IOException;

import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.Test;


import base.Hooks;
import pageObjects.HomePage;
import pageObjects.OrderForDelivery;
import pageObjects.OrderFormPayment;
import pageObjects.OrderFormShippingMethod;
import pageObjects.OrderPersonInformation;
import pageObjects.ShopContentPanel;
import pageObjects.ShopProductPage;
import pageObjects.ShoppingCart;
import pageObjects.ShoppingHomePage;

public class OrderCompletionTest extends Hooks
{

	public OrderCompletionTest() throws IOException {
		super();
		
	}
	@Test
	public void endToEndTest() throws InterruptedException, IOException {
		
		HomePage home = new HomePage();
		Thread.sleep(5000);
		
		//home.getCookie().click();
		home.getToggle().click();

		//handles cookie prompt
		//home.getCookie().click();
		
		Thread.sleep(2000);

		home.getTestStoreLink().click();
		
		ShoppingHomePage shopHome = new ShoppingHomePage();
		shopHome.getProdOne().click();
		
		ShopProductPage shopProd = new ShopProductPage();
		Select option = new Select(shopProd.getSizeOption());
		option.selectByVisibleText("M");
		shopProd.getQuantIncrease().click();
		shopProd.getAddToCartBtn().click();
		
		Thread.sleep(5000);
		
		ShopContentPanel cPanel = new ShopContentPanel();
		Thread.sleep(5000);
		cPanel.getCheckoutBtn().click();

		// creating an object of the shopping cart page (all items selected)
		ShoppingCart cart = new ShoppingCart();
		cart.getHavePromo().click();
		cart.getPromoTextbox().sendKeys("20OFF");
		cart.getPromoAddBtn().click();
		cart.getProceedCheckoutBtn().click();

		// creating an object of the order personal information page
		OrderPersonInformation pInfo = new OrderPersonInformation();
		pInfo.getGenderMr().click();
		pInfo.getFirstNameField().sendKeys("sandeep");
		pInfo.getLastnameField().sendKeys("mahenderkar");
		pInfo.getEmailField().sendKeys("testingsandeep4084@gmail.com");
		pInfo.getTermsConditionsCheckbox().click();
		pInfo.getContinueBtn().click();

		// creating an object of the order delivery info page
		OrderForDelivery orderDelivery = new OrderForDelivery();
		orderDelivery.getAddressField().sendKeys("123 Main Street");
		orderDelivery.getCityField().sendKeys("nalgonda");
		Select state = new Select(orderDelivery.getStateDropdown());
		state.selectByVisibleText("Indiana");
		orderDelivery.getPostcodeField().sendKeys("50800");
		orderDelivery.getContinueBtn().click();

		// creating an object of the shipping method page
		OrderFormShippingMethod shipMethod = new OrderFormShippingMethod();
		shipMethod.getDeliveryMsgTextbox().sendKeys("If I am not in, please leave my delivery on my porch.");
		shipMethod.getContinueBtn().click();

		// creating an object of the payment options page
		OrderFormPayment orderPay = new OrderFormPayment();
		orderPay.getPayByCheckRadioBtn().click();
		orderPay.getTermsConditionsCheckbox().click();
		orderPay.getOrderBtn().click();

	}
}
