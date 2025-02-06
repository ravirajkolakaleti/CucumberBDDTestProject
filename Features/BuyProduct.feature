Feature: Buy Product
  I want to use this template to test Login feature
  
  
  @Sanity
	Scenario: Buy Dress Product successfully
    Given user launches Chrome browser
    When user opens URL "http://www.automationpractice.pl/index.php"
    And user click on Sign In link
    And user enters Email as "<email>" and Password as "<pwd>"
    And click on Login
    Then Page title should be "My account - My Shop"
    When user enters "<searchText>" in the search field
    And user clicks on search
    Then Page title should be "Search - My Shop"
    And User clicks on Printed Summer Dress in the left panel 
    Then User should see the Printed Summer Dress details page
    And user selects the size "<size>"
    And user click on Orange Color
    Then verify that In stock text is displayed
    When user clicks on Add to Cart button
    Then verify the successful message is displayed
    When user clicks on Proceed to checkout button
    And user clicks on proceed to checkout button on Shopping Cart Summary page
    Then Page title should be "Order - My Shop"
    When user clicks on Proceed to checkout button to process Address
    Then verify page heading is Shipping
    When user clicks on checkbox
    And user clicks on Proceed to checkout button on Shipping page
    Then verify page heading is payment
    When user clicks on pay by check link
    Then verify page heading is Check Payment
    And user clicks on I Confirm my order link
    Then verify confirmation message is displayed
    When user clicks on back to order history link
    Then Page title should be "Order history - My Shop"
    When user clicks on Log Out link
    And close the browser
    
    
    Examples:
    
    |email|pwd|searchText|size|
    |rkola1223344@gmail.com|abc123|Dresses|M|
    
  @Regression
  Scenario Outline: Buy Product successfully
    Given user launches Chrome browser
    When user opens URL "http://www.automationpractice.pl/index.php"
    And user click on Sign In link
    And user enters Email as "<Email>" and Password as "<Password>"
    And click on Login
    Then Page title should be "My account - My Shop"
    When user enters "<Women>" in the search field
    And user clicks on search
    Then Page title should be "Search - My Shop"
    When user clicks on Blouse image
    And user selects the size "<size>"
    And user click on White Color
    Then verify that In stock text is displayed
    When user clicks on Add to Cart button
    Then verify the successful message is displayed
    When user clicks on Proceed to checkout button
    And user clicks on proceed to checkout button on Shopping Cart Summary page
    Then Page title should be "Order - My Shop"
    When user clicks on Proceed to checkout button to process Address
    Then verify page heading is Shipping
    When user clicks on checkbox
    And user clicks on Proceed to checkout button on Shipping page
    Then verify page heading is payment
    When user clicks on pay by check link
    Then verify page heading is Check Payment
    And user clicks on I Confirm my order link
    Then verify confirmation message is displayed
    When user clicks on back to order history link
    Then Page title should be "Order history - My Shop"
    When user clicks on Log Out link
    And close the browser
    
    
    Examples:
    |Email|Password|PageTitle1|PageTitle2|size|
    |rkola1223344@gmail.com|abc123|My account - My Shop|Login - My Shop|L|