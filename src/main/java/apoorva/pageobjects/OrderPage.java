package apoorva.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import apoorva.AbstractComponenets.AbstractComponent;

public class OrderPage extends AbstractComponent{
	WebDriver driver;
	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}	

@FindBy(css="tr td:nth-child(3)")
private List<WebElement> prodcutNames;


public boolean VerifyOrderDisplay(String prodname) {
	Boolean match =prodcutNames.stream().anyMatch(product->product.getText().equalsIgnoreCase(prodname));
	return match;
}


}



