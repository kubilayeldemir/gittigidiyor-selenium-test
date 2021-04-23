package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasketPage {
	WebDriver driver;
	By itemBoxContainer = By.className("product-item-box-container");
	By priceOfItem = By.className("total-price");
	By amountSelectBox = By.xpath("//select[@class='amount']");
	By amountListSecondItem = By.xpath("//option[@value='2']");
	By removeFromBasketButton = By.className("btn-delete");
	
	public BasketPage(WebDriver driver) {
		this.driver = driver;

	}
	
	public WebElement getFirsProduct() {
		WebElement basketProduct = driver.findElement(itemBoxContainer);
		return basketProduct;
	}
	
	public String getProductsPrice(WebElement product) throws InterruptedException{		
		String basketPrice = product.findElement(priceOfItem).getText();
		Thread.sleep(1000);
		return basketPrice;		
	}
	
	public void setProductAmountTo2(WebElement product) throws InterruptedException {
		WebElement selectBox = product.findElement(amountSelectBox);
		selectBox.click();
		Thread.sleep(1000);
		selectBox.findElement(amountListSecondItem).click();
		Thread.sleep(2000);
	}
	
	public String getProductAmount(WebElement product) throws InterruptedException {
		WebElement selectBox = product.findElement(amountSelectBox);
		String amount = selectBox.getAttribute("value");
		Thread.sleep(1000);
		return amount;		
	}
	
	public void RemoveFirstItemFromBasket(WebElement product) throws InterruptedException {
		WebElement removeButton = product.findElement(removeFromBasketButton);
		removeButton.click();
		Thread.sleep(2000);
	}
	
	public int getNumberOfProducts() {
		List<WebElement> basketProductsList = driver.findElements(itemBoxContainer);
		return basketProductsList.size();
	}
}
