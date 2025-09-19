package apoorva.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import apoorva.AbstractComponenets.AbstractComponent;

public class ConfirmationPage extends AbstractComponent{
	WebDriver driver;
	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
}
	
	@FindBy(css="h1[class='hero-primary']")
	WebElement ConfirmationMessage;
	
	
	public String getConfirmationmessage() {
		return ConfirmationMessage.getText();
	}


	
	
}