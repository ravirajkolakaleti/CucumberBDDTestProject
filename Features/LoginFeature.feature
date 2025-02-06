
Feature: Login
  I want to use this template to test Login feature

	@Regression
  Scenario Outline: Successful login with valid credentials
    Given user launches Chrome browser
    When user opens URL "http://www.automationpractice.pl/index.php"
    And user click on Sign In link
    And user enters Email as "<Email>" and Password as "<Password>"
    And click on Login
    Then Page title should be "<PageTitle1>"
    When user clicks on Log Out link
    Then Page title should be "<PageTitle2>"
    And close the browser
    
    Examples:
    |Email|Password|PageTitle1|PageTitle2|
    |rkola1223344@gmail.com|abc123|My account - My Shop|Login - My Shop|
 
 @Regression
 Scenario: Successful login with invalid credentials
    Given user launches Chrome browser
    When user opens URL "http://www.automationpractice.pl/index.php"
    And user click on Sign In link
    And user enters Email as "rkola1223344@gmail.com" and Password as "test123"
    And click on Login
    Then Verify the error message is displayed
    And close the browser