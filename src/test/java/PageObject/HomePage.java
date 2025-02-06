package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	// constructor
	
	public HomePage(WebDriver rdriver) {
		
		driver=rdriver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@class='login']")
	WebElement signInLink;
	
	public void clickOnSignInLink() {
		
		signInLink.click();
	}

}
