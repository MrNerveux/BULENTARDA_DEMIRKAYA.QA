package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.HomePage;
import pages.SeeAllQAJobsPage;
import utils.screenShotUtil;

public class SeeAllQAJobsPageTest {

public static String url = "https://useinsider.com/careers/quality-assurance/";
	
// Go to https://useinsider.com/careers/quality-assurance/
// click “See all QA jobs”,
// filter jobs by Location: “Istanbul, Turkey”, and Department: “Quality Assurance”,
// check the presence of the job lis

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		// Go to https://useinsider.com/careers/quality-assurance/
		driver.get(url);
		driver.manage().window().maximize();
		
		// wait for 3 seconds
		Thread.sleep(3000);
		SeeAllQAJobsPage qaJobsPage = new SeeAllQAJobsPage(driver);
		
		// to accept the all cookies
		HomePage allJobs = new HomePage(driver);
		allJobs.acceptCookies();
		
		
		// click “See all QA jobs”,
		qaJobsPage.seeAllJobsButton();
		
		// filter jobs by Location: “Istanbul, Turkey”, and Department: “Quality Assurance”,
		// WebDriverWait timeout = new WebDriverWait(driver, Duration.ofSeconds(20));
		// timeout.until(ExpectedConditions.visibilityOf(driver.findElement(null)));
		//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("Quality Assurance"))));
		// QA Assurance has automatically selected by website.
		Thread.sleep(20000);
		
		// to filter the departments
		//qaJobs.selectDepartment("Quality Assurance");
		
		// Open the location filter
		qaJobsPage.locationDropDown();
		
		// then click the istanbul, turkey selection
		qaJobsPage.selectLocationIstanbul();
		
		Thread.sleep(3000);
		
		// to close the filter
		driver.findElement(By.cssSelector("#top-filter-form > div:nth-child(1) > span > span.selection > span > span.select2-selection__arrow")).click();
		
		// check the presence of the job list
		// scroll mouse to the joblist.
		qaJobsPage.scrollToJobList();
		
		screenShotUtil.takeAScreenShot(driver, "screenShots/SeeAllQAJobs.png");
		
		Thread.sleep(4000);
		
		// Are the jobs visible?
		qaJobsPage.isJobListVisible();
		
		driver.quit();
		
		
	}

	
}
