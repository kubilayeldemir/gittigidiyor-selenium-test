package Test;
import org.junit.AfterClass;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.OrderWith;
import org.junit.runner.manipulation.Alphanumeric;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Pages.BasketPage;
import Pages.Header;
import Pages.LoginPage;
import Pages.ProductsPage;

import static org.junit.Assert.assertEquals;
import Util.EnvironmentManager;


@OrderWith(Alphanumeric.class)
public class GittiGidiyorMainTest {
	private static WebDriver driver;
	private static Header header;
	private String firstPrice;
	
@BeforeClass
public static void  setUp() {
	driver = EnvironmentManager.initWebDriver();
	header = new Header(driver);
}
@Test
public void step1_goToLoginPage() throws InterruptedException {
	driver.get("https://www.gittigidiyor.com");	
	header.clickLoginButton();
}

@Test
public void step2_testLogin() throws InterruptedException {	
	LoginPage loginPage = new LoginPage(GittiGidiyorMainTest.driver);
	Thread.sleep(1000);
	loginPage.fillUsername("uegwzkoxmsfspsozwt@twzhhq.com");
	loginPage.fillPassword("Test123");
	loginPage.clickLoginButton();
	String username = header.getUsername();
	assertEquals("asasdasdasdasdasdd", username); //User's username is "asasdasdasdasdasdd". Check if logged in successfully
}
@Test
public void step3_search() throws InterruptedException {
	header.search("bilgisayar");
}
@Test
public void step4_changePage() throws InterruptedException {
	ProductsPage pPage = new ProductsPage(driver);
	pPage.goToSecondPage();
	String pageNumber = pPage.getPage();
	assertEquals(pageNumber, "2");
	
}
@Test
public void step5_compareProductPrice() throws InterruptedException {
	ProductsPage pPage = new ProductsPage(driver);
	WebElement randomProd = pPage.getRandomProduct();
	this.firstPrice = pPage.getPriceOfSelectedProduct(randomProd);
	System.out.println(firstPrice);
	pPage.AddToBasketSelectedProduct(randomProd);
	header.clickToBasketButton();
	BasketPage bp = new BasketPage(driver);
	WebElement firstProduct = bp.getFirsProduct();
 	String priceAtBasket = bp.getProductsPrice(firstProduct);
 	assertEquals(firstPrice, priceAtBasket);
 	System.out.println(priceAtBasket);
}

@Test
public void step6_changeProductAmount() throws InterruptedException {
	BasketPage bp = new BasketPage(driver);
	WebElement firstProduct = bp.getFirsProduct();
	bp.setProductAmountTo2(firstProduct);
	String productAmount = bp.getProductAmount(firstProduct);
	assertEquals("2", productAmount);
}

@Test
public void step7_removeProduct() throws InterruptedException {
	BasketPage bp = new BasketPage(driver);
	WebElement firstProduct = bp.getFirsProduct();
	bp.RemoveFirstItemFromBasket(firstProduct);
	int productNumber = bp.getNumberOfProducts();
	assertEquals(0, productNumber);
}


@AfterClass
public static void afterr() {
	EnvironmentManager.shutDownDriver(driver);
}


}
