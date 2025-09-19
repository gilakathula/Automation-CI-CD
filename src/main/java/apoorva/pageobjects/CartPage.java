package apoorva.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import apoorva.AbstractComponenets.AbstractComponent;

public class CartPage extends AbstractComponent{
	WebDriver driver;
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
		//driver.findElement(By.xpath("//button[text()='Checkout']")).click();
	//List <WebElement> cartproducts=driver.findElements(By.cssSelector(".cartSection h3"));
	//	System.out.println(driver.findElement(By.cssSelector(".cartSection h3")).getText());	
	}	
@FindBy(css=".cartSection h3")
List <WebElement> cartproducts;	

@FindBy(xpath=("//button[text()='Checkout']"))
WebElement checkout;

public Boolean VerifyProductDisplay(String prodname) {
	
Boolean match =cartproducts.stream().anyMatch(cartproduct->cartproduct.getText().equalsIgnoreCase(prodname));
return match;
}
public checkOutpage goToCheckOut() {
	checkout.click();
//	checkOutpage checkoutpage=new checkOutpage(driver);
	return new checkOutpage(driver);
}

}



