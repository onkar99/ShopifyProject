package testPages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class cartPage {

	WebDriver driver;

	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));

	@FindBy(className ="cart__checkout-button")
	WebElement checkout;
	
	
	public cartPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void checkout() throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOf(checkout));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",checkout);
		checkout.click();
	}
	
}
