package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderHistoryPage {
    WebDriver ldriver;

    public OrderHistoryPage(WebDriver driver) {
       ldriver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locators

    @FindBy(xpath = "//a[@title='Orders']")
    WebElement orderHistoryLink;

    @FindBy(xpath = "//h1[contains(text(),'Order history')]")
    WebElement orderHistoryHeading;

    @FindBy(xpath = "//table[@id='order-list']/tbody/tr/td[2]") // Order Dates
    private List<WebElement> orderDates;

    @FindBy(xpath = "//table[@id='order-list']/tbody/tr/td[3]") // Total Prices
    private List<WebElement> totalPrices;

   

    // Actions
   

    public void clickOrderHistory() {
        orderHistoryLink.click();
    }

    public boolean isOrderHistoryDisplayed() {
        return orderHistoryHeading.isDisplayed();
    }

    public static class OrderDetails {
	     public int orderCount;
	     public double totalPrice;

        OrderDetails() {
            this.orderCount = 0;
            this.totalPrice = 0.0;
        }

        void addOrder(double price) {
            this.orderCount++;
            this.totalPrice += price;
        }
    }

    // Method to group orders by date and count them
    public Map<String, OrderDetails> getOrdersByDate() {
        Map<String, OrderDetails> ordersByDate = new HashMap<>();

        for (int i = 0; i < orderDates.size(); i++) {
            String date = orderDates.get(i).getText().trim(); // Get correct order date
            String priceText = totalPrices.get(i).getText().trim().replace("$", ""); // Remove "$"
            
            // Debugging step - Print extracted values
            System.out.println("Extracted Order Date: " + date);
            System.out.println("Extracted Order Price: " + priceText);

            if (date.isEmpty()) { 
                System.out.println("Skipping row due to blank date.");
                continue; // Skip rows where the date is blank
            }

            double price;
            try {
                price = Double.parseDouble(priceText); // Convert price to double
            } catch (NumberFormatException e) {
                price = 0.0; // Handle cases where price is not a valid number
            }

            // If date doesn't exist, initialize new OrderDetails object
            ordersByDate.putIfAbsent(date, new OrderDetails());
            ordersByDate.get(date).addOrder(price);
        }

        return ordersByDate;
    }
}
