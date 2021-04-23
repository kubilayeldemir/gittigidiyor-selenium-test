package Selenium;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LaunchChrome {
	//This is not the real test.
	//This file is used for test purposes.
	//For the real test go to Test>GittiGidiyorMainTest.java and run as jUnit
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.gittigidiyor.com");
		WebElement loginButton = driver.findElement(By.xpath("//div[@title='Giriş Yap']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(loginButton);
		actions.clickAndHold().perform();
		Thread.sleep(1000);
		WebElement login = driver.findElement(By.xpath("//a[@data-cy='header-login-button']"));
		login.click();
		// -----------------------
		WebElement username = driver.findElement(By.id("L-UserNameField"));
		username.sendKeys("uegwzkoxmsfspsozwt@twzhhq.com");

		WebElement password = driver.findElement(By.id("L-PasswordField"));
		password.sendKeys("Test123");

		WebElement loginnButton = driver.findElement(By.id("gg-login-enter"));
		loginnButton.click();

		// -------------------------------
		
		//Login check headerda.
		WebElement hop = driver.findElement(By.xpath("//div[@data-cy='header-user-menu']/div[1]/div[2]/span"));
		String text = hop.getText();
		System.out.println(hop.getText());
		if (text.equals("asasdasdasdasdasdd")) {
			System.out.println("Login is correct" + hop.getText());
		}
		// Assert.assertEquals(text, "asasdasdasdasdasdd");

		WebElement search = driver.findElement(By.xpath("//input[@data-cy='header-search-input']"));
		// search.click();
		search.sendKeys("bilgisayar");
		Thread.sleep(1000);
		WebElement searchButton = driver.findElement(By.xpath("//button[@data-cy='search-find-button']"));
		searchButton.click();
		Thread.sleep(1000);
		WebElement productsUL = driver.findElement(By.className("products-container"));

		List<WebElement> productList = productsUL.findElements(By.className("srp-item-list"));

		Random rand = new Random(productList.size());

		int randomProductNumber = rand.nextInt(productList.size() - 1);
		WebElement luckyProduct = productList.get(randomProductNumber);
		System.out.println(productList.size());
		System.out.println(randomProductNumber);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", luckyProduct);
		Thread.sleep(1000);
		//luckyProduct.click();
		String price = luckyProduct.findElement(By.className("fiyat")).getText();
		System.out.println(price);
		
		Actions action = new Actions(driver);
		actions.moveToElement(luckyProduct);
		actions.clickAndHold().perform();
		Thread.sleep(1000);
		WebElement addToBasketButton = luckyProduct.findElement(By.className("buy-now-button"));
		addToBasketButton.click();
		/*driver.findElement(By.className("lastPrice")).getText();
		
		driver.findElement(By.id("add-to-basket")).click();
		Thread.sleep(1000);
		driver.findElement(By.className("header-cart-container")).click();
		*/
		
		//buy-now-button
		
		driver.findElement(By.className("dIB")).click();
//-----------------------------------
		WebElement basketProduct = driver.findElement(By.className("product-item-box-container"));
		String basketPrice = basketProduct.findElement(By.className("total-price")).getText();
		System.out.println(basketPrice);
		Thread.sleep(1000);
		WebElement selectBox = driver.findElement(By.xpath("//select[@class='amount']"));
		selectBox.click();
		Thread.sleep(1000);
		WebElement amount = selectBox.findElement(By.xpath("//option[@value='2']"));
		amount.click();
		System.out.println(selectBox.getAttribute("value"));
		Thread.sleep(1000);
		//btn-delete
		WebElement deleteButton = basketProduct.findElement(By.className("btn-delete"));
		deleteButton.click();
		Thread.sleep(2000);
		//check if deleted or not
		List<WebElement> basketProductsList = driver.findElements(By.className("product-item-box-container"));
		System.out.println(basketProductsList.size());
		if(basketProductsList.size()==0) {
			System.out.println("Tebrikler ürün silindi");
		}
		
	}
}
