package PageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CreateAccountPage {
	
	// 1. Create object of WebDriver
	
				WebDriver ldriver;
				
				//constructor
	public CreateAccountPage (WebDriver rdriver) {
					
					ldriver = rdriver;
					
					
					PageFactory.initElements(rdriver, this);
					
				}
				
				// identify webelements in index page
				
				@FindBy (id = "id_gender1") // Title Mr
				WebElement titleMr;
				
				@FindBy (id = "id_gender2") // Title Mrs
				WebElement titleMrs;
				
				@FindBy (id = "customer_firstname") // First Name
				WebElement custfirstName;
				
				@FindBy (id = "customer_lastname") // Last Name
				WebElement custlastName;
				
				@FindBy (id = "passwd") //Password
				WebElement password;
				
				@FindBy(id = "days")
			    WebElement dayDropdown;

			    @FindBy(id = "months")
			    WebElement monthDropdown;

			    @FindBy(id = "years")
			    WebElement yearDropdown;
				
				@FindBy (id = "submitAccount") //Register  Button
				WebElement register;
				
				@FindBy(xpath = "//div[contains(@class,'alert-danger')]") 
				WebElement errorMessage;
				
				
				
				// identify action on SignIn webElement
				
				public void selectTitleMr() {
					
					titleMr.click();
				}
				
				public void selectTitleMrs() {
					
					titleMrs.click();
				}
				
				public void enterCustomerFirstName(String fname) {
					
					custfirstName.sendKeys(fname);
						
				}
				
				public void enterCustomerLastName(String lname) {
					
					custlastName.sendKeys(lname);
						
				}
				
				public void enterCustomerPassword(String pwd) {
					
					password.sendKeys(pwd);			
				}
				
				public void enterday(String dobDay) {
					
					dayDropdown.sendKeys(dobDay);
				}
				
				public void enterMonth(String dobMonth) {
					
					monthDropdown.sendKeys(dobMonth);
				}
				
				public void enterYear(String dobYear) {
					
					yearDropdown.sendKeys(dobYear);
				}
				
				public void clickRegisterButton() {
					
					register.click();
					
				}
				
				public boolean isErrorMessageDisplayed() {
			        try {
			            WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(5));
			            wait.until(ExpectedConditions.visibilityOf(errorMessage));
			            return errorMessage.isDisplayed();
			        } catch (Exception e) {
			            return false;
			        }
			    }

}
