package test;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.HomePage;
import pages.SeeAllQAJobsPage;
import utils.screenShotUtil;

public class JobListAndViewRoleTest {

public static String url = "https://useinsider.com/careers/quality-assurance/";
	
// I will test jobListTest.javaclass on the same page list with SellAllQAJobs. Same POM.
//  Check that all jobs’ Position contains “Quality Assurance”, Department contains
// “Quality Assurance”, and Location contains “Istanbul, Turkey

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		// to navigate the url
		driver.get(url);
		driver.manage().window().maximize();
		
		// wait for 3 seconds
		Thread.sleep(3000);
		SeeAllQAJobsPage jobsPage = new SeeAllQAJobsPage(driver);

		// to accept the all cookies
		HomePage allJobs = new HomePage(driver);
		allJobs.acceptCookies();

		// click the See all QA Jobs button
		jobsPage.seeAllJobsButton();

		// QA Assurance has automatically selected by website.
		Thread.sleep(20000);

		// Open the location filter
		jobsPage.locationDropDown();

		// then click the istanbul, turkey selection
		jobsPage.selectLocationIstanbul();

		Thread.sleep(3000);
		
		jobsPage.locationDropDown();

		Thread.sleep(2000);
		
		// scroll mouse to the joblist
		jobsPage.scrollToJobList();

		Thread.sleep(4000);
		
		// Since the job postings are not displayed in a list, I have to check them one by one.
//		List<WebElement> jobList = driver.findElements(By.xpath("//div[@id='jobs-list']"));
//		int count = 0;
//		for (WebElement job : jobList) {
//			if (job.getText().contains("Quality Assurance")) {
//				System.out.print("Job is: " + job.getText() + " (Test Passed)" + ", ");
//				System.out.println("Job number is: " + count);
//			} else {
//				System.out.println("Job does not have contains Quality Assurance.");
//			}
//			count++;
//		}
		
		String expectedword = "Quality Assurance";
		WebElement firstJob = driver.findElement(By.cssSelector("#jobs-list > div:nth-child(1) > div > p"));
		if(firstJob.getText().contains(expectedword)) {
			System.out.println("First Job Post contains " + expectedword);
			System.out.println("First Job is: " + firstJob.getText());
			System.out.println("Test Passed!");
		}
		else {
			System.out.println("First Job Post does not contain " + expectedword);
			System.out.println("Test Failed!");
		}
		
		Thread.sleep(3000);
		
		System.out.println("==========================");
		
		WebElement secondJob = driver.findElement(By.cssSelector("#jobs-list > div:nth-child(2) > div > p"));
		if(secondJob.getText().contains(expectedword)) {
			System.out.println("Second Job Post contains " + expectedword);
			System.out.println("Second Job is: " + secondJob.getText());
			System.out.println("Test Passed!");
		}
		else {
			System.out.println("Second Job Post does not contain " + expectedword);
			System.out.println("Test Failed!");
		}
		
		Thread.sleep(3000);
		
		// Click the “View Role” button and check that this action redirects us to the Lever
		// Application form page
		
		System.out.println("=============================");
		
		// Get the current url as a string
		String originalWindow = driver.getWindowHandle();
		
		// Click the “View Role” button
		WebElement viewRole = driver.findElement(By.cssSelector("#jobs-list > div:nth-child(1) > div > a"));
		jobsPage.scrollToJobList();
		
		Actions action = new Actions(driver);
		action.moveToElement(viewRole).perform();
		
		Thread.sleep(3000);
		
		viewRole.click();
		
		// Wait until the viewrolepage open
		WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(15));
		waits.until(ExpectedConditions.numberOfWindowsToBe(2));

		Set<String> windowHandles = driver.getWindowHandles();
		for (String windowHandle : windowHandles) {
			if (!windowHandle.equals(originalWindow)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}
		
		String newPageURL = driver.getCurrentUrl();
		if (newPageURL.contains("lever.co")) {
		    System.out.println("Başarılı: Lever Application sayfası yeni pencerede açıldı");
		    System.out.println("URL: " + newPageURL);
		} else {
		    System.out.println("Hata: Lever Application sayfası açılmadı");
		    System.out.println("URL: " + newPageURL);
		}

		Thread.sleep(3000);
		
		// to take a screeenshot of the application page
		screenShotUtil.takeAScreenShot(driver, "screenShots/JobListAndViewRoleTest01.png");
		
		driver.close();
		driver.switchTo().window(originalWindow);
		
		System.out.println("=================");
		
		// I need to hover the mouse over the view role for it to appear.
		jobsPage.scrollToJobList();
		// Click the 2nd job view role
		driver.findElement(By.cssSelector("#jobs-list > div:nth-child(2) > div > a")).click();
		
		waits.until(ExpectedConditions.numberOfWindowsToBe(2));

		Set<String> windowHandles2 = driver.getWindowHandles();
		for (String windowHandle2 : windowHandles2) {
			if (!windowHandle2.equals(originalWindow)) {
				driver.switchTo().window(windowHandle2);
				break;
			}
		}
		
		String newPageURL2 = driver.getCurrentUrl();
		if (newPageURL.contains("lever.co")) {
		    System.out.println("Başarılı: Lever Application sayfası yeni pencerede açıldı");
		    System.out.println("URL: " + newPageURL2);
		} else {
		    System.out.println("Hata: Lever Application sayfası açılmadı");
		    System.out.println("URL: " + newPageURL2);
		}

		Thread.sleep(4000);
		
		// to take a screeenshot at the end of the test
		screenShotUtil.takeAScreenShot(driver, "screenShots/JobListAndViewRoleTest02.png");
		
		Thread.sleep(4000);
		
		driver.quit();
	}
	
}
