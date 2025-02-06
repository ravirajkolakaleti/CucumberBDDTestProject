
Feature: Add Address

@Regression
Scenario: Successful in creating an user account
		Given user launches Chrome browser
    When user opens URL "http://www.automationpractice.pl/index.php"
    And user click on Sign In link
    And user enters Customer Email as "<email>"
    And click on Create an Account
    Then Page title should be "Login - My Shop"
    When user enters information in Create Account page with DOB "<dobDay>", "<dobMonth>", "<dobYear>"
    And click on Register
    Then Page title should be "My account - My Shop"
    When user clicks on Add my first address link
    Then Page title should be "Address - My Shop"
    When user enter information in Your addresses page
    And user clicks on Save button
    Then Page title should be "Addresses - My Shop"
    When user clicks on Log Out link
    Then Page title should be "Login - My Shop"
    And close the browser
 
  Examples:
    | email                  | dobDay | dobMonth | dobYear |
    | rrk56kola@gmail.com   | 10     | April    | 2003    |
