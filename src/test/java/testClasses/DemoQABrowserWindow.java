package testClasses;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoQABrowserWindow {
	WebDriver driver;

	@Test
	public void Verify_Browser_Window() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoqa.com/browser-windows");

		driver.findElement(By.xpath("//button[@id='windowButton']")).click();

		Set<String> handle = driver.getWindowHandles();
		Iterator<String> it = handle.iterator();
		String parentid = it.next();
		String childid = it.next();
		driver.switchTo().window(childid);

		String gettext = driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText();

		System.out.println(gettext);

		AssertJUnit.assertEquals(gettext, "This is a sample page");

		driver.quit();
	}
}
