Feature: Login User

  Scenario: User signs in with valid credentials
    Given User opens Login popup
    When  User enters "oleksandr.berezhnyi@gravit.io" into Email field on the popup
    When  User enters "123456" into Password field on the popup
    When  User clicks Login button on the popup
    Then  User sees that first name appers in the profile

  Scenario: User signs in with empty fields
    Given User opens Login popup
    When  User clicks Login button on the popup
    Then  User sees that Alert message appears

  Scenario: User signs in without an email
    Given User opens Login popup
    When  User enters "123456" into Password field on the popup
    When  User clicks Login button on the popup
    Then  User sees that Alert message appears

  Scenario: User signs in without a password
    Given User opens Login popup
    When  User enters "oleksandr.berezhnyi@gravit.io" into Email field on the popup
    When  User clicks Login button on the popup
    Then  User sees that Alert message appears

  Scenario: User signs in with invalid credentials
    Given User opens Login popup
    When  User enters "oleksandr.berezhnyi@gravit.io" into Email field on the popup
    When  User enters "1234567" into Password field on the popup
    When  User clicks Login button on the popup
    Then  User sees that Valid message appears

