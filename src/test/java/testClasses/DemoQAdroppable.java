package testClasses;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoQAdroppable {
	WebDriver driver;

	@Test
	public void Verify_DragAndDrop() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoqa.com/droppable");

		driver.findElement(By.xpath("//a[@id='droppableExample-tab-accept']")).click();

		WebElement notAcceptable = driver.findElement(By.xpath("//div[@id='notAcceptable']"));
		WebElement dropHere = driver.findElement(By.xpath("//div[@id='acceptDropContainer']//div[@id='droppable']"));

		Actions actions = new Actions(driver);
		actions.dragAndDrop(notAcceptable, dropHere).perform();

		driver.quit();

	}

}
