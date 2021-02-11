Feature: Login User

  Background: Pre-condition
    Given User opens Login popup

  @SmokeTest
  Scenario: User signs in with valid credentials
    When  User enters "oleksandr.berezhnyi@gravit.io" into Email field on the popup
    When  User enters "123456" into Password field on the popup
    When User clicks Login button with JS on the popup
    Then  User sees that first name appears in the profile

  @SmokeTest
  Scenario: User signs in with empty fields
    When  User clicks Login button on the popup
    Then  User sees that "Введіть телефон або e-mail." alert message appears

  @SmokeTest
  Scenario: User signs in without an email
    When  User enters "123456" into Password field on the popup
    When  User clicks Login button on the popup
    Then  User sees that "Введіть телефон або e-mail." alert message appears

  @SmokeTest
  Scenario: User signs in without a password
    When  User enters "oleksandr.berezhnyi@gravit.io" into Email field on the popup
    When  User clicks Login button on the popup
    Then  User sees that "Input password" alert message appears

  @SmokeTest
  Scenario: User signs in with invalid credentials
    When  User enters "oleksandr.berezhnyi@gravit.io" into Email field on the popup
    When  User enters "1234567" into Password field on the popup
    When  User clicks Login button on the popup
    Then  User sees that Valid message appears