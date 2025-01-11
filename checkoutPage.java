package testPages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class checkoutPage {

	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));

	@FindBy(id="email")
	WebElement email;
	
	@FindBy(name="lastName")
	WebElement lastName;
	
	@FindBy(name="address1")
	WebElement address;
	
	@FindBy(xpath="//ul[@role='listbox']/li[1]")
	WebElement location;
	
	@FindBy(tagName ="iframe")
	List<WebElement> listOfFrames;
	
	@FindBy(css ="#number")
	WebElement cardNumber;
	
	@FindBy(name ="expiry")
	WebElement expiryDate;
	
	@FindBy(name ="verification_value")
	WebElement verifyValue;
	
	@FindBy(name ="name")
	WebElement cardName;
	
	@FindBy(xpath = "//button[@id='checkout-pay-button']")
	WebElement payNow;
	
	@FindBy(xpath = "//h2[@tabindex='-1']")
	WebElement finalMessage;
	
	public checkoutPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void addDetails() throws InterruptedException
	{
		
		email.sendKeys("demo@email.com");
		
		lastName.sendKeys("LastName");
		
		address.sendKeys("Airoli");
		
		wait.until(ExpectedConditions.visibilityOf(location));
		location.click();

		wait.until(ExpectedConditions.visibilityOfAllElements(listOfFrames.get(0)));
		
		driver.switchTo().frame(listOfFrames.get(0));
		cardNumber.sendKeys("1");
				
		driver.switchTo().defaultContent();
		driver.switchTo().frame(listOfFrames.get(1));
		expiryDate.sendKeys("12");
		expiryDate.sendKeys("25");
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame(listOfFrames.get(2));
		verifyValue.sendKeys("111");
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame(listOfFrames.get(5));
		cardName.sendKeys("Myname");
		
		driver.switchTo().defaultContent();
		payNow.click();
	}
	
	public String verifyMessage()
	{
		wait.until(ExpectedConditions.visibilityOf(finalMessage));
		String finalMsg = finalMessage.getText();
		return finalMsg;
	}
}
