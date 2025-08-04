package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.CareerPage;
import pages.HomePage;
import utils.screenShotUtil;

public class CareerPageTest {

	public static String url = "https://useinsider.com/";
	
	public static void main(String[] args) throws InterruptedException {
		
System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		// to navigate the url
		driver.get(url);
		driver.manage().window().maximize();
		
		// wait for 3 seconds
		Thread.sleep(3000);
		
		// to accept the all cookies
		HomePage homePage = new HomePage(driver);
		homePage.acceptCookies();
		
		Thread.sleep(3000);
		
		WebElement careerButton = driver.findElement(By.cssSelector("#navbarNavDropdown > ul:nth-child(1) > li:nth-child(6) > div > div.new-menu-dropdown-layout-6-mid-container > a:nth-child(2)"));
		WebElement companyButton = driver.findElement(By.linkText("Company"));
		Actions action = new Actions(driver);
		
		CareerPage career = new CareerPage(driver);
		
		action.moveToElement(companyButton).perform();
		careerButton.click();
		
		// wait until the career page is open
		WebDriverWait wait = new WebDriverWait(driver,	Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#page-head > div > div > div.col-12.col-lg-6.order-2.order-lg-1 > div > h1"))));
		
		// to show the locations on the career page
		career.scrollToOurLocations();
		career.seelocationsIsDisplayed();
		screenShotUtil.takeAScreenShot(driver, "screenShots/Locations.png");
		
		Thread.sleep(2000);
		
		// to show LifeAtInsider on the career page
		career.scrollToLifeAtInsıder();
		career.seelifeAtInsiderIsDisplayed();
		screenShotUtil.takeAScreenShot(driver, "screenShots/LifeAtInsider.png");
		
		Thread.sleep(2000);
		
		career.scrollToTeams();
		career.seeAllTeamsIsDisplayed();
		screenShotUtil.takeAScreenShot(driver, "screenShots/SeeAllTeams.png");
		
		Thread.sleep(2000);
		
		driver.quit();
	}
}
