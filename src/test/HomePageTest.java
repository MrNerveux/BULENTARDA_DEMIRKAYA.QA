package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.HomePage;
import utils.screenShotUtil;

public class HomePageTest {

public static String url = "https://useinsider.com/";
	
	// Scenario: Visit https://useinsider.com/ and check Insider home page is opened or not
	
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
		
		// 1st way to verify the website is getTitle method, 
		// if title contains Insider then print Test Passed on the console.
		String title = homePage.getTitle();
		if(title.contains("Insider")) {
			System.out.println("Test Passed!");
		}
		else {
			System.out.println("Test Failed!");
		}
		
		// wait for 3 secs
		Thread.sleep(3000);
		
		// 2nd way is verify the Insıder logo is displayed, 
		// if the logo is displayed homepage on website then print the test passed on the console.
		boolean insiderLogo = homePage.isLogoDisplayed();
		if(insiderLogo) {
			System.out.println("Logo is visible on the homepage. Test Passed!");
		}
		else {
			System.out.println("Logo is not visible on the homepage. Test Failed!");
		}
		
		Thread.sleep(3000);
		
		screenShotUtil.takeAScreenShot(driver, "screenShots/HomePageTest.png");
		
		// close the browser
		driver.quit();
	}
}
