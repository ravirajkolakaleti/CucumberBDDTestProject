
Feature: Order History Validation
  

 @Sanity
  Scenario: Order History verification
    Given user launches Chrome browser
    When user opens URL "http://www.automationpractice.pl/index.php"
    And user click on Sign In link
    And user enters Email as "<Email>" and Password as "<Password>"
    And click on Login
    Then Page title should be "<PageTitle1>"
    When user clicks on Order History and Details link
    Then Page Heading should be ORDER HISTORY
    And count the orders by date
    When user clicks on Log Out link
    And close the browser
    

     Examples:
    |Email|Password|PageTitle1|PageTitle2|
    |rkola1223344@gmail.com|abc123|My account - My Shop|Login - My Shop|
