package testScripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import testPages.HomePage;
import testPages.cartPage;
import testPages.checkoutPage;

public class BundleTest {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver= new ChromeDriver();
		
		driver.get("https://rennet-earphones.myshopify.com/");
		
		driver.manage().window().maximize();
		
		HomePage homePage= new HomePage(driver);
		
		homePage.login();
		
		homePage.selectProduct(0);
		
		String saleText = homePage.verifyHeader();
        homePage.addTheBundle();
		
		cartPage crtPg= new cartPage(driver);
		
		crtPg.checkout();
		
		checkoutPage checkPg=new checkoutPage(driver);
		
		checkPg.addDetails();
		
		String finalMessage = checkPg.verifyMessage();		
		finalMessage.trim();
                Assert.assertEquals(finalMessage, "Thank you!");
		
		
		
		
		
		
	}

}
