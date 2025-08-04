package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class screenShotUtil {

	public static void takeAScreenShot(WebDriver driver, String fullPath) {
		 try {
		        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		        FileHandler.copy(src, new File(fullPath));
		        System.out.println("Screenshot kaydedildi: " + fullPath);
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
	}
}
