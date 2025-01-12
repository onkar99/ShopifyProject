package testScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import testPages.HomePage;
import testPages.cartPage;
import testPages.checkoutPage;

public class QuantityTest {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver= new ChromeDriver();
		
		driver.get("https://rennet-earphones.myshopify.com/");
		
		driver.manage().window().maximize();
		
		HomePage homePage= new HomePage(driver);
		
		homePage.login();
		
		homePage.selectProduct(2);
		
		String saleTtile = homePage.verifyTitle();
		homePage.addToCart();

		cartPage crtPg= new cartPage(driver);
		
		crtPg.checkout();
		
		checkoutPage checkPg=new checkoutPage(driver);
		
		checkPg.addDetails();
		String lastMsg = checkPg.verifyMessage();
        	Assert.assertEquals(lastMsg, "Thank you!");

	}

}
