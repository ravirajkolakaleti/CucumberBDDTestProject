package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductPage {
	
	WebDriver driver;
	
	public ProductPage(WebDriver rdriver) {
		
		driver=rdriver;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="search_query_top")
	WebElement search;
	
	@FindBy(name="submit_search")
	WebElement searchBtn;
	
	@FindBy(xpath="//div[@id='best-sellers_block_right']//li[1]//a[1]//img[1]")
	WebElement blouse;
	
	@FindBy(xpath = "(//div[@class='product-image-container']//a[@title='Printed Dress']/img)[2]")
    private WebElement printedDress;
	
	@FindBy(xpath="//div[@id='left_column']//li[6]//a[1]//img[1]")
	private WebElement printedSummerDressFilter;
	
	@FindBy(xpath="//li[@class='ajax_block_product col-xs-12 col-sm-6 col-md-4 last-item-of-tablet-line hovered']//span[contains(text(),'Quick view')]")
	WebElement quickView;
	
	@FindBy(xpath="(//span[normalize-space()='More'])[2]")
	WebElement dressMoreBtn;
	
	@FindBy(xpath="//select[@id='group_1']")
	WebElement selectSize;
	
	@FindBy(id="color_13")
	WebElement color;
	
	@FindBy(id="color_8")
	WebElement colorWhite;
	@FindBy(xpath="//span[normalize-space()='Add to cart']")
	WebElement addToCartBtn;
	
	@FindBy(linkText="Proceed to checkout")
	WebElement proceed;
	
	@FindBy(xpath="//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')]")
	WebElement ProceedtocheckoutButton;
	
	@FindBy(xpath="//button[@name='processAddress']//span[contains(text(),'Proceed to checkout')]")
	WebElement processAddCheckoutBtn;
	
	@FindBy(id="cgv")
	WebElement checkbox;
	
	@FindBy(xpath="//button[@name='processCarrier']//span[contains(text(),'Proceed to checkout')]")
	WebElement processCarrierCheckoutBtn;
	
	@FindBy(xpath="//a[@title='Pay by check.']")
	WebElement payByCheck;
	
	@FindBy(xpath="//span[normalize-space()='I confirm my order']")
	WebElement confirmButton;
	
	@FindBy(xpath="//a[normalize-space()='View your order history']")
	WebElement orderHistorylink;
	
	public void enterTextInSearch(String searchText) {
		
		search.sendKeys(searchText);	
	}
	
	public void clickOnSearchBtn() {
		
		searchBtn.click();
	}
	
	public void clickOnBlouseImage() {
		
		blouse.click();
	}
	
/*	public void hoverOverDressImage() {
		
		// Create Actions class instance
        Actions actions = new Actions(driver);
		
		actions.moveToElement(hoverDressImg).perform();
	}*/
	
	public void clickOnImageLink() {
		
		printedDress.click();
	}
	
	public void clickOnSelectSize(String size) {
		
		Select dropdown = new Select(selectSize);
		
		dropdown.selectByVisibleText(size);
	}
	
	public void clickOnColorOrange() {
		
		color.click();
	}
	
public void clickOnColorWhite() {
		
		colorWhite.click();
	}
	
	
	public void clickOnAddToCartButton() {
		addToCartBtn.click();
		
	}
	
	public void clickOnProceedButton() {
		
		proceed.click();
	}
	
	public void clickOnProceedtocheckoutButton() {
		
		ProceedtocheckoutButton.click();
	}
	
	public void clickOnProcessAddCheckout() {
		processAddCheckoutBtn.click();
	}
	
	public void selectCheckbox() {
		checkbox.click();
	}
	
	public void clickOnProcessCarrierCheckoutButton() {
		
		processCarrierCheckoutBtn.click();
	}
	
	public void clickOnPayByCheck() {
		
		payByCheck.click();
	}
	
	public void clickOnConfirmButton() {
		
		confirmButton.click();
	}
	
	public void clickOnOrderHistoryLink() {
		
		orderHistorylink.click();
	}
	
	// Method to click on "Printed Summer Dresses" filter
    public void clickPrintedSummerDressFilter() {
        printedSummerDressFilter.click();
    }
}
