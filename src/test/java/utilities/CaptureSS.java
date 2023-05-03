package utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class CaptureSS {
	//Capture Screenshot Using Selenium TakesScreenShot Interface
		public static String screenshot(WebDriver driver) throws IOException {
			String path = System.getProperty("user.dir")+File.separator+"test-output"+File.separator+"ScreenShots"+File.separator+System.currentTimeMillis()+".png";
			File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File dest = new File(path);
			FileHandler.copy(src, dest);
			return path;
		}
}
