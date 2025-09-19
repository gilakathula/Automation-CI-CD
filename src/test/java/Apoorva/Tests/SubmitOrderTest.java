
package Apoorva.Tests;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Apoorva.TestComponents.BaseTest;
import apoorva.pageobjects.CartPage;
import apoorva.pageobjects.ConfirmationPage;
import apoorva.pageobjects.LandingPage;
import apoorva.pageobjects.OrderPage;
import apoorva.pageobjects.ProductCatalogue;
import apoorva.pageobjects.checkOutpage;

public class SubmitOrderTest extends BaseTest{
	String prodname = "ZARA COAT 3";
	@Test(dataProvider="getData",groups= {"Purchase"})
	public void SubmitOrder(HashMap<String,String> input) throws IOException, InterruptedException {
		
		String country = "IND";
		ProductCatalogue productcatalogue = landingpage.loginApplication(input.get("email"),input.get("password"));

		List<WebElement> products = productcatalogue.getProductList();
		productcatalogue.addProductToCart(input.get("prodname"));
		CartPage cartpage = productcatalogue.goToCartPage();
		Boolean match = cartpage.VerifyProductDisplay(input.get("prodname"));
		Assert.assertTrue(match);
		// cartpage.goToCheckOut();
		checkOutpage checkoutpage = cartpage.goToCheckOut();
		checkoutpage.selectCountry(country);
		ConfirmationPage confirmationpage = checkoutpage.submitOrder();
		String confirmMessage = confirmationpage.getConfirmationmessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		System.out.println("Successfull");
	}
	//tO VERIFY Zaracoat 3 is displaying in the orders page
	@Test(dependsOnMethods= {"SubmitOrder"})
	public void OrderHistoryTest() {
		ProductCatalogue productcatalogue = landingpage.loginApplication("apoorvagoud.1603@gmail.com", "Apoorva@123");
	OrderPage ordersPage=productcatalogue.goToOrdersPage();
	Assert.assertTrue(ordersPage.VerifyOrderDisplay(prodname));
	
	}
	
	
	//Extent Reports
	
	
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		
	List<HashMap<String,String>> data=getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//apoorvadata//data//PurchaseOrder.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}
}
	//@DataProvider
	//public object[][] getData()
	//{
	//return new object[][] {{"abc@gmail.com","acs123","zara coat"},{"shetty@gmail.com,"abcsdhi@123","ADIDAS "}}
    //}
//	HashMap<String,String> map=new HashMap<String,String>();
//	map.put("email","apoorvagoud.1603@gmail.com");
//	map.put("password","Apoorva@123");
//	map.put("prodname","ZARA COAT 3");
//	HashMap<String,String> map1=new HashMap<String,String>();
//	map1.put("email","sriramu@gmail.com");
//	map1.put("password","Ram@123456");
//	map1.put("prodname","ADIDAS ORIGINAL");	
	//}

	
	
