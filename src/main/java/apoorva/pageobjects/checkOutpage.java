package apoorva.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import apoorva.AbstractComponenets.AbstractComponent;

public class checkOutpage extends AbstractComponent{
	WebDriver driver;
	public checkOutpage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	//Actions a=new Actions(driver);
	//a.sendKeys(driver.findElement(By.cssSelector("input[placeholder='Select Country']")),"ind").build().perform();
	//driver.findElement(By.cssSelector("input[placeholder='Select Country']")).sendKeys("ind");
//	a.click(driver.findElement(By.cssSelector(".ta-item:nth-child(3)"))).build().perform();
//a.click(driver.findElement(By.cssSelector("a[class*='action__submit']"))).build().perform();
//String exp =driver.findElement(By.cssSelector("h1[class='hero-primary']")).getText();
	//Assert.assertTrue(exp.equalsIgnoreCase("THANKYOU FOR THE ORDER."));	
	
	@FindBy(css=("input[placeholder='Select Country']"))
	WebElement country;
	
	@FindBy(css=".ta-item:nth-child(3)")
	WebElement CountryName;
	
	@FindBy(xpath="//button[contains(@class,'ta-item')])[2]")
	WebElement SelectCountry;
	
	//By results=By.cssSelector(".ta-results");
	
	@FindBy(css="a[class*='action__submit']")
	WebElement submit;
	

	
	public void selectCountry(String Selectcountry)
	{
		Actions a=new Actions(driver);
		a.sendKeys(country,Selectcountry).build().perform();
		//waitforElementToAppear(results);
		//SelectCountry.click();
		a.click(CountryName).build().perform();
		//a.click(submit).build().perform();
	}
		public ConfirmationPage submitOrder() {
	submit.click();
	return new ConfirmationPage(driver);
	}}
	
	

