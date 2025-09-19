package apoorva.AbstractComponenets;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import apoorva.pageobjects.CartPage;
import apoorva.pageobjects.OrderPage;

public class AbstractComponent {
	WebDriver driver;
	public AbstractComponent(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(css="[routerlink*='cart']")
	WebElement cartHeader;
	//driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
	
	@FindBy(css="[routerlink*='myorders']")
	WebElement orderHeader;
	
	public void waitforElementToAppear(By findBy) {
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	public void waitforElementToAppear(WebElement findBy) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findBy));
	}
	public void waitforElementToDisappear(WebElement ele) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	public CartPage goToCartPage() {
		cartHeader.click();
		CartPage cartpage=new CartPage(driver);
		return cartpage;
	}
	public OrderPage goToOrdersPage() {
		orderHeader.click();
		OrderPage OrderPage=new OrderPage(driver);
		return OrderPage;
	}
}
