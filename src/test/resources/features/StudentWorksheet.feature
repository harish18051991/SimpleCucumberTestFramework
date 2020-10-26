Feature: As a tester, I want to verify Student portal

  Scenario: Verify student login
    Given I open LOGIN_PAGE
    And I click stdntTab on LOGIN_PAGE
    And I type "9600149719" in username on LOGIN_PAGE
    And I type "G9a6n0e0" in password on LOGIN_PAGE
    When I click loginBtn on LOGIN_PAGE
    Then I validate HOME_PAGE page was successfully loaded
    And the text at "welcomeMessage" should be "Welcome" on HOME_PAGE