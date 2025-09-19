package apoorva.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import apoorva.AbstractComponenets.AbstractComponent;

public class LandingPage extends AbstractComponent {
	WebDriver driver;
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	//WebElement userEmail=driver.findElement(By.id("userEmail"));
@FindBy(id="userEmail")	
WebElement userEmail;

//driver.findElement(By.id("userPassword")).sendKeys("Apoorva@123");
@FindBy(id="userPassword")
WebElement userpassword;

//driver.findElement(By.id("login")).click();
@FindBy(id="login")
WebElement Submit;
@FindBy(css="[class*='flyInOut']")
WebElement errorMessage;


public ProductCatalogue loginApplication(String email,String password)
{
	userEmail.sendKeys(email);
	userpassword.sendKeys(password);
	Submit.click();
	ProductCatalogue productcatalogue=new ProductCatalogue(driver);
	return productcatalogue;
}
public void goTo() {
	driver.get("https://rahulshettyacademy.com/client");
}
public String getErrorMessage() {
	waitforElementToAppear(errorMessage);
	return errorMessage.getText();
	
}


}
