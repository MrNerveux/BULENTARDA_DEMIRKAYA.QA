package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeeAllQAJobsPage{

	WebDriver driver;
    WebDriverWait wait;
    
    public SeeAllQAJobsPage(WebDriver driver) {
    	this.driver = driver;
    	this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }
    
    public void seeAllJobsButton() {
    	driver.findElement(By.linkText("See all QA jobs")).click();
    }
    
    public void selectDepartment(String department) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    	WebElement departmentDropDown = driver.findElement(By.id("filter-by-department"));
    	departmentDropDown.click();
    	Select select = new Select(departmentDropDown);
    	select.selectByVisibleText(department);
    }
    
    public void locationDropDown() {
    	WebElement locationDropDown = driver.findElement(By.xpath("//span[@id='select2-filter-by-location-container']"));
    	locationDropDown.click();
    }
    
    public void selectLocationIstanbul() {
    WebElement istanBulOption = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#filter-by-location > option.job-location.istanbul-turkiye")));
	istanBulOption.click();
    }
    
    public void isJobListVisible() {
    	WebElement jobPictures = driver.findElement(By.cssSelector("#jobs-list > div:nth-child(1) > div"));
		if(jobPictures.isDisplayed()) {
			System.out.println("Job post is visible. Test Passed.");
		}
		else {
			System.out.println("Job post is not visible. Test Failed.");
		}
    }
    
    public void scrollToJobList() throws InterruptedException {
    	WebElement jobList = driver.findElement(By.cssSelector("#career-position-list > div > div > div.col-12.d-flex.flex-column.flex-lg-row.justify-content-lg-between.align-items-lg-end > h3"));
    	
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("arguments[0].scrollIntoView(true);", jobList);
    	Thread.sleep(2000);
    }
    
}
