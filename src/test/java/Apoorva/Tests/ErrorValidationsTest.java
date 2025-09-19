
package Apoorva.Tests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Apoorva.TestComponents.BaseTest;
import Apoorva.TestComponents.Retry;
import apoorva.pageobjects.CartPage;
import apoorva.pageobjects.ConfirmationPage;
import apoorva.pageobjects.LandingPage;
import apoorva.pageobjects.ProductCatalogue;
import apoorva.pageobjects.checkOutpage;

public class ErrorValidationsTest extends BaseTest{
//ExtentReports extent;
	@Test(groups= {"ErrorHandling"},retryAnalyzer=Retry.class)
	public void LoginErrorValidation() throws IOException, InterruptedException {
		
	landingpage.loginApplication("apoorvagoud.1603@gmail.com", "Apoorva@123");
//		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//	   // wait.until(ExpectedConditions.visibilityOf(landingpage.getErrorMessage()));
//	//   Thread.sleep(5000);
Assert.assertEquals("Incorrect email or password.",landingpage.getErrorMessage());
	}
	
	@Test
	public void ProductErrorValidation() throws IOException, InterruptedException
	{
		String prodname = "ZARA COAT 3";
	String country = "IND";
	ProductCatalogue productcatalogue = landingpage.loginApplication("apoorvagoud.1603@gmail.com", "Apoorva@123");

	List<WebElement> products = productcatalogue.getProductList();
	productcatalogue.addProductToCart(prodname);
	CartPage cartpage = productcatalogue.goToCartPage();
	Boolean match = cartpage.VerifyProductDisplay("ZARA COAT 33");
	Assert.assertFalse(match);
	}
}