package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver lDriver;
	
	public  LoginPage(WebDriver rDriver) {
		
		lDriver = rDriver;
		
		PageFactory.initElements(rDriver, this);
		
	}
	
	
	
	@FindBy(id = "email")
	WebElement emailAddress;
	
	@FindBy(name = "passwd")
	WebElement password;
	
	@FindBy(id="SubmitLogin")
	WebElement signInBtn;
	
	@FindBy(xpath = "//div[@class='alert alert-danger']")
    WebElement errorMessage;

	
	@FindBy(xpath="//a[@class='logout']")
	WebElement logoutBtn;
	
	@FindBy(xpath="//a[@title='Add my first address']//i[@class='icon-building']")
	WebElement addFirstAdd;
	
	@FindBy(id="email_create")
	WebElement emailEnter;
	
	@FindBy(id="SubmitCreate")
	WebElement createAcctBtn;
	
	public void enterEmail(String emailAdd) {
		
		emailAddress.sendKeys(emailAdd);
	}
	
	public void enterPassword(String pwd) {
		
		password.sendKeys(pwd);
	}
	
	public void clickLoginBtn() {
		signInBtn.click();
		
	}
	
	public void clickOnLogoutLink() {
		
		logoutBtn.click();
	}
	
	public void clickOnAddMyNewAddressLink() {
		
		addFirstAdd.click();
	}
	
public void enterEmailCreate(String emailCreate) {
		
		emailEnter.sendKeys(emailCreate);
		
	}
	
	public void clickOnCreateAccountButton()
	{
		
		createAcctBtn.click();
	}
	
	public boolean isErrorMessageDisplayed() {
        return errorMessage.isDisplayed();
    }

}
