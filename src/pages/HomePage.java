package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePage {

	WebDriver driver;
	
	private By acceptCookiesButton = By.id("wt-cli-accept-all-btn");
	private By logo = By.xpath("//*[@id=\"navigation\"]/div[2]/a[1]/img");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void acceptCookies() {
		driver.findElement(acceptCookiesButton).click();
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public boolean isLogoDisplayed() {
		return driver.findElement(logo).isDisplayed();
	}
}
