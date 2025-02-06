package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


import PageObject.AddressesPage;
import PageObject.CreateAccountPage;
import PageObject.HomePage;
import PageObject.LoginPage;
import PageObject.OrderHistoryPage;
import PageObject.ProductPage;
import Utilities.ExtentReportManager;
import io.cucumber.java.en.*;

public class StepDef {
	
	
	public WebDriver driver;
	ExtentTest test;
	
	public LoginPage loginPg;
	
	public HomePage homePg;
	
	public AddressesPage addPg;
	
	public CreateAccountPage accountPg;
	
	public ProductPage productPg;
	
	public OrderHistoryPage orderPg;
	
	@Before
	public void setUp(Scenario scenario) {
        test = ExtentReportManager.createTest(scenario.getName());
        test.log(Status.INFO, "Starting test: " + scenario.getName());
        
	}
	
	@Given("user launches Chrome browser")
	public void user_launches_chrome_browser() {
		
		driver=new ChromeDriver();

		//maximise windows
		driver.manage().window().maximize();

		loginPg = new LoginPage(driver);
		homePg = new HomePage(driver);
		addPg = new AddressesPage(driver);
		accountPg = new CreateAccountPage(driver);
		productPg = new ProductPage(driver);
		orderPg = new OrderHistoryPage(driver);
	}

	@When("user opens URL {string}")
	public void user_opens_url(String url) {
		
		//open url
		driver.get(url);
		test.log(Status.PASS, "Navigated to home page");
	    
	}

	@And("user click on Sign In link")
	public void user_click_on_sign_in_link() {
		
		homePg.clickOnSignInLink();
		test.log(Status.PASS, "Clicked on Sign In");
	}

	@And("user enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String emailAdd, String Pwd) {
		
		loginPg.enterEmail(emailAdd);
		loginPg.enterPassword(Pwd);
		test.log(Status.PASS, "Entered username and password");
	}

	@And("click on Login")
	public void click_on_login() {
		
		loginPg.clickLoginBtn();
		test.log(Status.PASS, "Clicked Login");
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String expectedTitle) {
		
		String actualTitle = driver.getTitle();
		
		if(actualTitle.equals(expectedTitle)) {
			
			org.testng.Assert.assertTrue(true); // Pass
			
			System.out.println("Page Title is : " +actualTitle);
			test.log(Status.PASS, "My account - My Shop page is displayed");
		}
		else {
			
			org.testng.Assert.assertTrue(false); // Fail
			
		}
	}

	@When("user clicks on Log Out link")
	public void user_clicks_on_log_out_link() {
		
		loginPg.clickOnLogoutLink();
		test.log(Status.PASS, "Clicked Logout");
	}

	@Then("close the browser")
	public void close_browser() {
		
	//	driver.close();
		driver.quit();
		test.log(Status.INFO, "Browser closed");
		ExtentReportManager.flushReports(); 
	}
	
	///////////////////////////////////////////////////Create User Functionality ////////////////////////
	
	@When("user enters Customer Email as {string}")
	public void user_enters_customer_email_as(String custemail) {
		loginPg.enterEmailCreate(custemail);
		test.log(Status.PASS, "Entered email in Customer Email Field");
	}

	@When("click on Create an Account")
	public void click_on_create_an_account() {
	    
		loginPg.clickOnCreateAccountButton();
		test.log(Status.PASS, "Clicked On Create an Account");
	}
	
	@When("user enters information in Create Account page with DOB {string}, {string}, {string}")
	public void user_enters_information_in_Create_Account_page(String dobDay, String dobMonth, String dobYear) throws InterruptedException {
		
		Thread.sleep(2000);
		accountPg.selectTitleMr();
		accountPg.enterCustomerFirstName("RaviRR");
		accountPg.enterCustomerLastName("Kolakaleti");	
		accountPg.enterCustomerPassword("test123");
		accountPg.enterday(dobDay);
		accountPg.enterMonth(dobMonth);
		accountPg.enterYear(dobYear);
		test.log(Status.PASS, "Entered Customer Information");
	}

	@When("click on Register")
	public void click_on_register() {
	    
		 accountPg.clickRegisterButton();
		 test.log(Status.PASS, "Clicked On Register Button");
	}
	
	//////////////////////////////////////Add Address Functionality //////////////////////////////////////
	
	@When("user clicks on Add my first address link")
	public void user_clicks_on_add_my_first_address_link() {
	    
		loginPg.clickOnAddMyNewAddressLink();
		test.log(Status.PASS, "Clicked On Add My New Address Link");
	}

	@When("user enter information in Your addresses page")
	public void user_enter_information_in_your_addresses_page() throws InterruptedException {
		addPg.enterAddress("3205 Owls Roost Rd");
		addPg.enterCity("Charlotte");
		addPg.selectState("North Carolina");
		addPg.enterPostalCode("27410");
		addPg.enterHomePhoneNumber("314-346-9465");
		addPg.enterMobilePhoneNumber("314-346-9464");
		addPg.enterAddInfo("Entered Personal Addresss for testing");
		addPg.enterAddressTitle("Home Address");
		Thread.sleep(3000);
	//	addPg.clickOnSaveButton();
		test.log(Status.PASS, "Entered data into all required fields");
	}

	@When("user clicks on Save button")
	public void user_clicks_on_save_button() throws InterruptedException {
	    
		addPg.clickOnSaveButton();
		test.log(Status.PASS, "Clicked On Save Button");
	}

	///////////////////////////////////////////Buy Product functionality//////////////////
	
	@When("user enters {string} in the search field")
	public void user_enters_in_the_search_field(String searchText) {
		
		productPg.enterTextInSearch(searchText);
		test.log(Status.PASS, "Searched for: " + searchText);
	}

	@When("user clicks on search")
	public void user_clicks_on_search() {
		
		productPg.clickOnSearchBtn();
		test.log(Status.PASS, "Clicked On Search Button");
	}

	@When("user clicks on Blouse image")
	public void user_clicks_on_blouse_image() throws InterruptedException {
		
		
		productPg.clickOnBlouseImage();
	    Thread.sleep(3000);
	    test.log(Status.PASS, "Clicked On Blouse Image");
	}

	@When("user selects the size {string}")
	public void selects_the_size_as(String size) throws InterruptedException {
		
		productPg.clickOnSelectSize(size);
		Thread.sleep(3000);
		test.log(Status.PASS, "Clicked On Select Size dropdown");
	}

	@Then("verify that In stock text is displayed")
	public void verify_that_text_is_displayed_in_green_color() {
		
		String expectedText = "In stock";
		
		String actualText = driver.findElement(By.xpath("//span[@id='availability_value']")).getText();
		
		if(actualText.equals(expectedText))
		{
			System.out.println("Product is available and is : " +actualText);
			test.log(Status.PASS, "Product is available and is : " +actualText);
		}
		else
		{
			System.out.println("Product is not available");
		}
	    
	}

	@When("user clicks on Add to Cart button")
	public void user_clicks_on_add_to_cart_button() throws InterruptedException {
		
		Thread.sleep(3000);
		productPg.clickOnAddToCartButton();
	    Thread.sleep(4000);
	    test.log(Status.PASS, "Clicked On Add to Cart Button");
	}

	@Then("verify the successful message is displayed")
	public void verify_the_successful_message_is_displayed() {
		
		String expectedMessage = "Product successfully added to your shopping cart";
		
		String actualMessage = driver.findElement(By.xpath("//h2[normalize-space()='Product successfully added to your shopping cart']")).getText();
				
	    if(actualMessage.equals(expectedMessage))
	    {
	    	System.out.println(actualMessage);
	    	test.log(Status.PASS, "Message is : " +actualMessage);
	    }
	    else
	    {
	    	System.out.println("Item was not added to cart");
	    }
	}

	@When("user clicks on Proceed to checkout button")
	public void user_clicks_on_proceed_to_checkout_button() {
	    
		productPg.clickOnProceedButton();
		 test.log(Status.PASS, "Clicked On Proceed to Checkout Button");
	}
	
	@When("user clicks on proceed to checkout button on Shopping Cart Summary page")
	public void user_clicks_on_proceed_to_checkout_button_on_shopping_cart_summary_page() {
	    productPg.clickOnProceedtocheckoutButton();
	    test.log(Status.PASS, "Clicked On Proceed to Checkout Button on Shopping Cart Summary Page");
	}
	
	@When("user clicks on Proceed to checkout button to process Address")
	public void user_clicks_on_proceed_to_checkout_button_to_process_address() throws InterruptedException {
	    Thread.sleep(2000);
		productPg.clickOnProcessAddCheckout();
		test.log(Status.PASS, "Clicked On Proceed to Checkout Button to Process Address");
	}

	@Then("verify page heading is Shipping")
	public void verify_page_heading_is_shipping() {
	    
		String expectedHeading = "Shipping";
		String actualHeading = driver.findElement(By.xpath("//h1[normalize-space()='Shipping:']")).getText();
		
		if(actualHeading.equals(expectedHeading)) {
			
			System.out.println("The Page Heading is : " +actualHeading);
			test.log(Status.PASS, "The Page Heading is : " +actualHeading);
		}
		else {
			System.out.println("The Page Heading is not Shipping");
		}
	}
	
	@When("user clicks on checkbox")
	public void user_clicks_on_checkbox() {
		productPg.selectCheckbox();
		test.log(Status.PASS, "Clicked On Select Checkbox");
	}
	
	@And("user clicks on Proceed to checkout button on Shipping page")
	public void user_clicks_on_Proceed_to_checkout_button_on_Shipping_page() {
	
	productPg.clickOnProcessCarrierCheckoutButton();
	test.log(Status.PASS, "Clicked On Proceed to Checkout Button on Shipping Page");
	
	}
	
	@Then("verify page heading is payment")
	public void verify_page_heading_is_payment() {
		
		String expectedHeading = "Please choose your payment method";
		
		String actualHeading = driver.findElement(By.xpath("//h1[@class='page-heading']")).getText();
		
		if(actualHeading.equals(expectedHeading))
		{
			System.out.println("The page heading is : " +actualHeading);
			test.log(Status.PASS, "The Page Heading is : " +actualHeading);
		}
	}
	
	@When("user clicks on pay by check link")
	public void user_clicks_on_pay_by_check_link() throws InterruptedException {
		
		Thread.sleep(3000);
		productPg.clickOnPayByCheck();
		test.log(Status.PASS, "Clicked On Pay By Check Link");
	}
	
	@Then("verify page heading is Check Payment")
	public void verify_page_heading_is_Check_Payment() {
		
		String expectedHeading = "Check payment";
		
		String actualHeading = driver.findElement(By.xpath("//h3[normalize-space()='Check payment']")).getText();
		
		if(actualHeading.equals(expectedHeading))
		{
			System.out.println("The Page Heading is : " +actualHeading);
			test.log(Status.PASS, "The Page Heading is : " +actualHeading);
		}
				
	}
	
	@And("user clicks on I Confirm my order link")
	public void user_clicks_on_I_Confirm_my_order_link() throws InterruptedException {
		
		Thread.sleep(3000);
		productPg.clickOnConfirmButton();
		test.log(Status.PASS, "Clicked On Confirm Button");
	}
	
	@Then("verify confirmation message is displayed")
	public void verify_confirmation_message_is_displayed() {
		
		String expectedMessage = "Your order on My Shop is complete.";
		
		String actualMessage = driver.findElement(By.xpath("//p[@class='alert alert-success']")).getText();
		
		if(actualMessage.equals(expectedMessage))
		{
			System.out.println(actualMessage);
			test.log(Status.PASS, "The Message is : " +actualMessage);
		}
	}
	
	@When("user clicks on back to order history link")
	public void user_clicks_on_order_history_link() {
		
		productPg.clickOnOrderHistoryLink();
		test.log(Status.PASS, "Clicked On Back to Order History");
	}
	
	///////////////////////////Buy Dress product///////////////////////////////////
	
/*	@When("user hover the Dress Image")
	public void user_hover_the_Dress_Image() throws InterruptedException {
		
		Thread.sleep(3000);
		productPg.hoverOverDressImage();
	}*/
	
	@When("user clicks on Dress Image Link")
	public void user_clicks_on_dress_image_link() throws InterruptedException {
		
		Thread.sleep(3000);
		productPg.clickOnImageLink();
	   Thread.sleep(5000);
	   test.log(Status.PASS, "Clicked On Dress Image Link");
	}
		

/*	@Then("user selects the size as {string}")
	public void user_selects_the_size_as_m(String size) {
	    
		productPg.clickOnSelectSize(size);
	}*/

	@Then("user click on Orange Color")
	public void user_click_on_orange_color() throws InterruptedException {
		
		productPg.clickOnColorOrange();
	    Thread.sleep(5000);
	    test.log(Status.PASS, "Clicked On Orange Color Icon");
	}
	
	@Then("user click on White Color")
	public void user_click_on_white_color() throws InterruptedException {
		
		productPg.clickOnColorWhite();
	    Thread.sleep(5000);
	    test.log(Status.PASS, "Clicked On White Color Icon");
	}
	
	@When("User clicks on Printed Summer Dress in the left panel")
    public void user_clicks_on_printed_summer_dress_in_left_panel() {
		productPg.clickPrintedSummerDressFilter();
		test.log(Status.PASS, "Clicked On Printed Summer Dress Image Link");
        
    }
	
	 @Then("User should see the Printed Summer Dress details page")
	    public void user_should_see_the_printed_summer_dress_details_page() {
	        try {
	            String expectedTitle = "Printed Summer Dress - My Shop";
	            Assert.assertEquals(expectedTitle, driver.getTitle());
	            System.out.println("Verified Printed Summer Dress details page");
	        } catch (AssertionError e) {
	            System.out.println("Page title did not match expected value.");
	            throw e;
	        }
	    }
	 
	 @Then("Verify the error message is displayed")
	    public void verify_the_error_message_is_displayed() throws InterruptedException {
		 	Thread.sleep(3000);
		 	Assert.assertTrue(loginPg.isErrorMessageDisplayed(), "Error message is not displayed!");
	        test.log(Status.PASS, "Error message is displayed as expected");
	    }
	 @Then("verify error message")
	 public void verify_error_message() {
	     
		 Assert.assertTrue(accountPg.isErrorMessageDisplayed(), "Error message is not displayed!");
	        test.log(Status.PASS, "Error message is displayed as expected");
	    }
	 
	 
	 ///////////////////////////////////Order History scenario/////////////////////////////////
	 
	 @When("user clicks on Order History and Details link")
	    public void user_clicks_on_order_history_and_details_link() {
		 orderPg.clickOrderHistory();
		 test.log(Status.PASS, "Clicked on Order History link");
	        
	    }
	 
	 @Then("Page Heading should be ORDER HISTORY")
	    public void page_heading_should_be_order_history() {
	        Assert.assertTrue(orderPg.isOrderHistoryDisplayed(), "Order History page is not displayed!");
	        test.log(Status.PASS, "Order History page displayed successfully");
	        
	    }

	/*    @Then("count the orders by date")
	    public void count_the_orders_by_date() {
	        int orderCount = orderPg.countOrdersByDate();
	        test.info("Total number of orders: " + orderCount);
	    }

	    @Then("count the Total Price by date")
	    public void count_the_total_price_by_date() {
	        double totalPrice = orderPg.countTotalPriceByDate();
	        test.info("Total order price: $" + totalPrice);
	    }*/
	 
	 @Then("count the orders by date")
	 public void count_the_orders_by_date() {
	     Map<String, OrderHistoryPage.OrderDetails> ordersByDate = orderPg.getOrdersByDate();

	     if (ordersByDate.isEmpty()) {
	         test.warning("No orders found in the order history!");
	         System.out.println("No orders found in the order history!");
	     } else {
	         test.info("Orders grouped by date:");
	         System.out.println("Orders grouped by date:");
	         
	         for (Map.Entry<String, OrderHistoryPage.OrderDetails> entry : ordersByDate.entrySet()) {
	             String date = entry.getKey();
	             OrderHistoryPage.OrderDetails details = entry.getValue();

	             test.info("Date: " + date + " - Total Orders: " + details.orderCount + " - Total Price: $" + String.format("%.2f", details.totalPrice));
	             System.out.println("Date: " + date + " - Total Orders: " + details.orderCount + " - Total Price: $" + String.format("%.2f", details.totalPrice));
	         }
	     }
	 } 



	 
	 @After
		public void tearDown(Scenario scenario) {
			if (scenario.isFailed()) {
				test.log(Status.FAIL, "Scenario failed: " + scenario.getName());
			} else {
				test.log(Status.PASS, "Scenario passed: " + scenario.getName());
			}
		}
	 
	 public String takeScreenshot(String testName) {
	        TakesScreenshot ts = (TakesScreenshot) driver;
	        File srcFile = ts.getScreenshotAs(OutputType.FILE);
	        String destPath = "test-output/screenshots/" + testName + ".png";

	        try {
	            Files.copy(srcFile.toPath(), Paths.get(destPath));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return destPath;
	    }
}
