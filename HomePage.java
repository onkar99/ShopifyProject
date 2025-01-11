package testPages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	WebDriver driver;

	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement submitButton;
	
	@FindBy(xpath="//ul[@class[contains(.,'product-grid')]]/li")
	List<WebElement> listOfProducts;
	
	@FindBy(css =".pmpr_bundle__header")
	WebElement saleText;
	
	@FindBy(css =".pmpr_bundle__add_to_cart")
	WebElement addBundle;
	
	@FindBy(xpath="//h3[text()[contains(.,'Flash Sale')]]")
	WebElement saleTitle;
	
	@FindBy(name ="add")
	WebElement addToCart;
	
	@FindBy(id ="cart-notification-button")
	WebElement viewCart;
	
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void login()
	{
		password.sendKeys("onkar");
		submitButton.click();
	}
	
	public void selectProduct(int productNumber)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", listOfProducts.get(productNumber));
		listOfProducts.get(productNumber).click();
	}
	
	public String verifyHeader()
	{
        String actual = saleText.getText();
		
        return actual;
	}
	
	public void addTheBundle()
	{
		addBundle.click();
	}
	
	public String verifyTitle()
	{
        String actual = saleTitle.getText();
		
        return actual;
	}
	public void addToCart() throws InterruptedException
	{
		addToCart.click();
		wait.until(ExpectedConditions.visibilityOf(viewCart));
		//Thread.sleep(3000);
		viewCart.click();
	}
	
	
	
}
