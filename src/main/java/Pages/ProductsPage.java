package Pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

//Page you land when you search something
public class ProductsPage {
	WebDriver driver;
	By productsUL = By.className("products-container");
	By productItems = By.className("srp-item-list");
	By selectedProductPrice = By.className("fiyat");
	By addToBasketButtonForProduct = By.className("buy-now-button");
	By pageDiv = By.xpath("//div[contains(@class, 'pager') and not(contains(@class, 'mobile-pager'))]");
	By pageItems = By.tagName("li");
	By selectedPage = By.xpath("//li[@class='selected']/a[1]");

	public ProductsPage(WebDriver driver) {
		this.driver = driver;

	}
	
	private int pickRandomProductNumber(int maxNo) {
		Random rand = new Random();
		int randomProductNumber = rand.nextInt(maxNo - 1);
		return randomProductNumber;
	}
	
	public WebElement getRandomProduct() throws InterruptedException {
		WebElement productsContainer = driver.findElement(By.className("products-container"));
		List<WebElement> productList = productsContainer.findElements(productItems);
		int luckyNumber = pickRandomProductNumber(productList.size());
		WebElement luckyProduct = productList.get(luckyNumber);
		System.out.println(productList.size());
		System.out.println(luckyNumber);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", luckyProduct); //scroll to selected product
		Thread.sleep(1000);
		return luckyProduct;
	}
	
	public String getPriceOfSelectedProduct(WebElement product) {
		return product.findElement(selectedProductPrice).getText();			
	}
	
	
	public void AddToBasketSelectedProduct(WebElement product) throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(product);
		action.clickAndHold().perform();
		Thread.sleep(1000);
		WebElement addToBasketButton = product.findElement(addToBasketButtonForProduct);
		addToBasketButton.click();
	}
	public void goToSecondPage() throws InterruptedException {		
		Thread.sleep(5000);
		WebElement page = driver.findElement(pageDiv);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", page); //scroll to selected product
		List<WebElement> pageItemList = page.findElements(pageItems);
		pageItemList.get(1).click();
		Thread.sleep(1000);
	}
	public String getPage() {
		WebElement page = driver.findElement(pageDiv);
		WebElement selectedPageElement = page.findElement(selectedPage);
		return selectedPageElement.getText();
		
	}
}
