package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	WebDriver driver;
	By usernameField = By.id("L-UserNameField");
	By passwordField = By.id("L-PasswordField");
	By loginButton = By.id("gg-login-enter");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void fillUsername(String username) {
		WebElement usernameElement = driver.findElement(usernameField);
		usernameElement.click();
		usernameElement.sendKeys(username);			
		}
	
	public void fillPassword(String password) {
		driver.findElement(passwordField).sendKeys(password);
	}
	public void clickLoginButton() {
		driver.findElement(loginButton).click();
	}
	
}
