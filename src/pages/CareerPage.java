package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CareerPage {

	WebDriver driver;
	
	private By companyButton = By.cssSelector("#navbarDropdownMenuLink");
	private By careerButton = By.cssSelector("#navbarNavDropdown > ul:nth-child(1) > li:nth-child(6) > div > div.new-menu-dropdown-layout-6-mid-container > a:nth-child(2)");
	
	public CareerPage(WebDriver driver) {
        this.driver = driver;
    }
	
	public void goToCareer() throws InterruptedException {
		driver.findElement(companyButton).click();
		Thread.sleep(1000);
		driver.findElement(companyButton).click();
	}
	
	 public void scrollToOurLocations() throws InterruptedException {
	    	WebElement locations = driver.findElement(By.cssSelector("#career-find-our-calling > div > div > a"));
	    	
	    	JavascriptExecutor js = (JavascriptExecutor) driver;
	    	js.executeScript("arguments[0].scrollIntoView(true);", locations);
	    	Thread.sleep(2000);
	    }
	 
	 public void scrollToCompany() throws InterruptedException {
	    	WebElement company = driver.findElement(By.cssSelector("#navbarDropdownMenuLink"));
	    	
	    	JavascriptExecutor js = (JavascriptExecutor) driver;
	    	js.executeScript("arguments[0].scrollIntoView(true);", company);
	    	Thread.sleep(2000);
	    }
	 
	 public void scrollToLifeAtInsıder() throws InterruptedException {
	    	WebElement lifeAtInsıder = driver.findElement(By.cssSelector("#career-our-location > div > div > div > div.col-12.mt-3.mt-md-5.pt-md-5 > div.location-slider-pagination.d-none.d-lg-flex.justify-content-center.align-items-center.mt-0.mt-xl-5.mb-5.pt-3.pt-xl-5.pb-5"));
	    	
	    	JavascriptExecutor js = (JavascriptExecutor) driver;
	    	js.executeScript("arguments[0].scrollIntoView(true);", lifeAtInsıder);
	    	Thread.sleep(2000);
	    }
	 
	 public void scrollToTeams() throws InterruptedException {
	    	WebElement teams = driver.findElement(By.cssSelector("#career-find-our-calling > div > div > a"));
	    	
	    	JavascriptExecutor js = (JavascriptExecutor) driver;
	    	js.executeScript("arguments[0].scrollIntoView(true);", teams);
	    	Thread.sleep(2000);
	    }
	 
	 public void seeAllTeamsIsDisplayed() {
		 WebElement teams = driver.findElement(By.cssSelector("#career-find-our-calling > div > div > a"));
		 if(teams.isDisplayed()) {
			 System.out.println("Test Passed!");
		 }
		 else {
			 System.out.println("Test Failed!");
		 }
	 }
	 
	 public void seelifeAtInsiderIsDisplayed() {
		 WebElement insider = driver.findElement(By.cssSelector("body > div.elementor.elementor-22610 > section.elementor-section.elementor-top-section.elementor-element.elementor-element-a8e7b90.elementor-section-full_width.elementor-section-height-default.elementor-section-height-default > div > div > div > div.elementor-element.elementor-element-21cea83.elementor-widget.elementor-widget-heading > div > h2"));
		 if(insider.isDisplayed()) {
			 System.out.println("Test Passed!");
		 }
		 else {
			 System.out.println("Test Failed!");
		 }
	 }
	 
	 public void seelocationsIsDisplayed() {
		 WebElement locations = driver.findElement(By.cssSelector("#career-our-location > div > div > div > div.col-12.col-md-6 > h3"));
		 if(locations.isDisplayed()) {
			 System.out.println("Test Passed!");
		 }
		 else {
			 System.out.println("Test Failed!");
		 }
	 }
}
