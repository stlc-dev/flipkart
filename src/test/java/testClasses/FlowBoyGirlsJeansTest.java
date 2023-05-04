package testClasses;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeMethod;
import pomClasses.FlowBoyGirlsJeans;

public class FlowBoyGirlsJeansTest extends BaseClass {

	FlowBoyGirlsJeans flow;
	SoftAssert sAssert;

	@BeforeMethod
	public void beforemethod() {
		flow = new FlowBoyGirlsJeans(driver);
		sAssert = new SoftAssert();
	}

	@Test
	public void Verify_Product_Title_And_Price() {
		logger = report.createTest("Verify Product Title And Price");
		flow.loginpopupclose();
		flow.hoverFashion();
		flow.hoverKids();
		flow.clickBoysAndGirls();
		flow.clickPriceLowToHigh();
		flow.clickboyjeans();
		flow.switchwindow();
		String boysjeanstitle= flow.boysjeansgettitle();
		String boysjeansprice= flow.boyjeansprice();
		flow.select_size();
		flow.enterpincode();
		flow.clickaddtocart();
		String producttitle= flow.getCheckoutPageProductTitle();
		String productprice = flow.getCheckoutPageProductPrice();
		sAssert.assertEquals(boysjeanstitle, producttitle);
		sAssert.assertEquals(boysjeansprice, productprice);
		sAssert.assertAll();
	}
}
