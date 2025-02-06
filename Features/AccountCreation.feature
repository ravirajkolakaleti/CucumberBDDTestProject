
Feature: User Creation
@Sanity
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
    When user clicks on Log Out link
    Then Page title should be "Login - My Shop"
    And close the browser
    
    Examples:
    | email                  | dobDay | dobMonth | dobYear |
    | rrk18kola@gmail.com   | 15     | April    | 1995    |
    | rasya.kola124@gmail.com | 20     | June     | 2000    |

@Sanity
Scenario: Validate Error Message in creating an user account
		Given user launches Chrome browser
    When user opens URL "http://www.automationpractice.pl/index.php"
    And user click on Sign In link
    And user enters Customer Email as "rrk12kola@gmail.com"
    And click on Create an Account
    Then verify error message
    And close the browser