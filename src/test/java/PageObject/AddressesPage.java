package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddressesPage {
	
	WebDriver driver;
	
	
	public AddressesPage(WebDriver rdriver) {
		
		driver=rdriver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="address1")
	WebElement address;
	
	@FindBy(id="city")
	WebElement city;
	
	@FindBy(id="id_state")
	WebElement state;
	
	@FindBy(id="postcode")
	WebElement zipcode;
	
	@FindBy(name="phone")
	WebElement homePhone;
	
	@FindBy(id="phone_mobile")
	WebElement mobilePhone;
	
	@FindBy(id="other")
	WebElement additionalInfo;
	
	@FindBy(id="alias")
	WebElement addressTitle;
	
	@FindBy(xpath="//span[normalize-space()='Save']//i[@class='icon-chevron-right right']")
	WebElement saveBtn;
	
	
	
	public void enterAddress(String addrs) {
		
		address.sendKeys(addrs);
	}
	
	public void enterCity(String cityname) {
		
		city.sendKeys(cityname);
	}
	
	public void selectState(String addState) {
		
		Select dropdown = new Select(state);
		
		dropdown.selectByVisibleText(addState);
		
	}
	
	public void enterPostalCode(String postalcode) {
		
		zipcode.sendKeys(postalcode);
	}
	
	public void enterHomePhoneNumber(String homephonenum) {
		
		homePhone.sendKeys(homephonenum);
	}
	
	public void enterMobilePhoneNumber(String mobilenum) {
		
		mobilePhone.sendKeys(mobilenum);
		
	}
	
	public void enterAddInfo(String addinfo) {
		
		additionalInfo.sendKeys(addinfo);
	}
	
	public void enterAddressTitle(String addTitle) throws InterruptedException {
		
		addressTitle.clear();
		Thread.sleep(2000);
		addressTitle.sendKeys(addTitle);
	}
	
	public void clickOnSaveButton() throws InterruptedException {
		
		Thread.sleep(3000);
		saveBtn.click();
	}
}
