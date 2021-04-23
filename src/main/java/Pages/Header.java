package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class Header {
	WebDriver driver;
	By loginButtonPopup = By.xpath("//div[@title='Giriş Yap']");
	By loginButton = By.xpath("//a[@data-cy='header-login-button']");
	By username = By.xpath("//div[@data-cy='header-user-menu']/div[1]/div[2]/span");
	By searchBar = By.xpath("//input[@data-cy='header-search-input']");
	By searchButton = By.xpath("//button[@data-cy='search-find-button']");
	By addToBasketButton = By.className("dIB");
	
	public Header(WebDriver driver) {
		this.driver = driver;

	}

	private void holdMouseOnLoginButton() throws InterruptedException {
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(loginButtonPopup));
		actions.clickAndHold().perform();
		Thread.sleep(1000);
	}
	
	public void clickLoginButton() throws InterruptedException {
		holdMouseOnLoginButton();
		driver.findElement(loginButton).click();
		Thread.sleep(1000);
	}
	
	public String getUsername() throws InterruptedException {//Exists if user logged in
		String usernameOfLoggedInPerson = driver.findElement(username).getText();
		Thread.sleep(1000);
		return usernameOfLoggedInPerson;
	}
	
	public void search (String stringToSearch) throws InterruptedException {
		driver.findElement(searchBar).sendKeys(stringToSearch);
		Thread.sleep(1000);
		driver.findElement(searchButton).click();
		Thread.sleep(1000);
	}
	
	public void clickToBasketButton() {
		driver.findElement(addToBasketButton).click();
	}	
	
}
