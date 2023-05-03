package pomClasses;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ExplicitWait;

public class FlowBoyGirlsJeans {
	
	WebDriver driver;
	Actions actions;

	@FindBy(xpath = "//div[contains(text(),'Fashion')]")
	private WebElement fashionTab;

	@FindBy(xpath = "(//a[@class='_6WOcW9'])[8]")
	private WebElement kidsTab;

	@FindBy(xpath = "//a[text()='Boys & Girls Jeans' and @class='_6WOcW9 _3YpNQe']")
	private WebElement boysGirlsJeansbtn;

	@FindBy(xpath = "//button[text()='✕' and @class='_2KpZ6l _2doB4z']")
	private WebElement loginpopclosebtn;
	
	@FindBy(xpath = "//div[normalize-space()='Price -- Low to High']")
	private WebElement pricelowtohigh;

	@FindBy(xpath = "//div[@data-id='JEAGADSRFVGBAHRV']//a[@title='Boys Regular Mid Rise Dark Blue Jeans'][normalize-space()='Boys Regular Mid Rise Dark Blue Jeans']")
	private WebElement boysregularmidjeans;

	@FindBy(xpath = "//span[@class='B_NuCI']")
	private WebElement boysjeansgettitle;
	
	@FindBy(xpath = "//div[contains(text(),'₹170')]")
	private WebElement boyjeansprice;

	@FindBy(xpath = "//a[contains(text(),'6 - 7 Years')]")
	private WebElement six_seven_size;

	@FindBy(xpath = "//input[@placeholder='Enter delivery pincode']")
	private WebElement pincode;

	@FindBy(xpath = "//span[contains(text(),'Check')]")
	private WebElement pincodeCheck;

	@FindBy(xpath = "//button[@class='_2KpZ6l _2U9uOA _3v1-ww'][contains(.,'Add to cart')]")
	private WebElement addtocart;

	@FindBy(xpath = "//a[contains(text(),'Kcoy Regular Boys Dark Blue')]")
	private WebElement productCheckoutTitle;

	@FindBy(xpath = "//span[text()='178']")
	private WebElement productCheckoutPrice;


	public FlowBoyGirlsJeans(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void loginpopupclose() {
		ExplicitWait.elementtimexpath("//button[text()='✕' and @class='_2KpZ6l _2doB4z']", 10, driver);
		//Web-site pop-up login dynamic possible
		try {
			loginpopclosebtn.click();
		} catch (Exception e) {
			
		}
	}

	// Hover over the "Fashion" tab
	public void hoverFashion() {
		actions = new Actions(driver);
		ExplicitWait.elementtimexpath("//div[contains(text(),'Fashion')]", 10, driver);
		actions.moveToElement(fashionTab).perform();
	}

	// Hover over the "Kids" tab
	public void hoverKids() {
		actions = new Actions(driver);
		ExplicitWait.elementtimexpath("(//a[@class='_6WOcW9'])[8]", 10, driver);
		actions.moveToElement(kidsTab).perform();
	}
	
	//Click Boys & Girls tab
	public void clickBoysAndGirls() {
		ExplicitWait.elementtimexpath("//a[text()='Boys & Girls Jeans' and @class='_6WOcW9 _3YpNQe']", 10, driver);
		boysGirlsJeansbtn.click();
	}
	
	//Click Price Low To High 
	public void clickPriceLowToHigh() {
		ExplicitWait.elementtimexpath("//div[normalize-space()='Price -- Low to High']", 10, driver);
		pricelowtohigh.click();
	}
	
	//Click Boys Regular Mid Jeans 
	public void clickboyjeans() {
		ExplicitWait.elementtimexpath("//div[@data-id='JEAGADSRFVGBAHRV']//a[@title='Boys Regular Mid Rise Dark Blue Jeans'][normalize-space()='Boys Regular Mid Rise Dark Blue Jeans']", 10, driver);
		boysregularmidjeans.click();
	}
		
	//Get jeans Title
	public String boysjeansgettitle() {
		ExplicitWait.elementtimexpath("//span[@class='B_NuCI']", 10, driver);
		String jeanstitle= boysjeansgettitle.getText();
		return jeanstitle;
	}
	
	//Get Jeans Price
	public String boyjeansprice() {
		ExplicitWait.elementtimexpath("//div[contains(text(),'₹170')]", 10, driver);
		String jeansprice= boyjeansprice.getText();
		//only get 170 not a symbol ₹ i.e i am use substring
		String partialText = jeansprice.substring(1, 4);
		//System.out.println(partialText);
		return partialText;
	}
	

	//Switch Focus To Child Window
	public void switchwindow() {
		Set<String> handle= driver.getWindowHandles();
		Iterator it=handle.iterator();
		String parentid=(String) it.next();
		String childid=(String) it.next();
		driver.switchTo().window(childid);
	}
	
	//Select 6-7 Size
	public void select_size() {
		
		ExplicitWait.elementtimexpath("//a[contains(text(),'6 - 7 Years')]", 10, driver);
		six_seven_size.click();
	}
	
	//Enter Pin-code 
	public void enterpincode() {
		ExplicitWait.elementtimexpath("//input[@placeholder='Enter delivery pincode']", 10, driver);
		pincode.sendKeys("560011");
		ExplicitWait.elementtimexpath("//span[contains(text(),'Check')]", 10, driver);
		pincodeCheck.click();
	}
	
	//Add to Cart Button Click
	public void clickaddtocart() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(0,2000)");
		ExplicitWait.elementtimexpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww'][contains(.,'Add to cart')]", 10, driver);
		addtocart.click();
		//Error While First Click i.e I use try catch
		try {
			addtocart.click();
		} catch (Exception e) {
			
		}
	}
	
	public String getCheckoutPageProductTitle() {
		ExplicitWait.elementtimexpath("//a[contains(text(),'Kcoy Regular Boys Dark Blue')]", 10, driver);
		String title= productCheckoutTitle.getText();
		return title;
	}
	public String getCheckoutPageProductPrice() {
		ExplicitWait.elementtimexpath("//span[text()='178']", 0, driver);
		String price= productCheckoutPrice.getText();
		return price;
	}
}
