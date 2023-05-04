package testClasses;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoQAAlerts {
	WebDriver driver;
	Alert alt;

	@Test
	public void Verify_Alert() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoqa.com/alerts");

		driver.findElement(By.xpath("//button[@id='alertButton']")).click();
		alt = driver.switchTo().alert();
		System.out.println("Alert 1 = " + alt.getText());
		alt.accept();

		driver.findElement(By.xpath("//button[@id='timerAlertButton']")).click();
		Thread.sleep(6000);
		alt = driver.switchTo().alert();
		System.out.println("Alert 2 = " + alt.getText());
		alt.accept();

		driver.findElement(By.xpath("//button[@id='confirmButton']")).click();
		alt = driver.switchTo().alert();
		System.out.println("Alert 3 = " + alt.getText());
		alt.accept();

		driver.findElement(By.xpath("//button[@id='promtButton']")).click();
		alt = driver.switchTo().alert();
		alt.sendKeys("Test");
		System.out.println("Alert 4 = " + alt.getText());
		alt.accept();

		Thread.sleep(5000);
		driver.quit();
	}
}
