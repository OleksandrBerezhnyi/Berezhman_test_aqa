Feature: Home page


  Background: Pre-condition
    Given Check that Home page is displayed


  @SmokeTest
  Scenario: Check that Main Elements are displayed on Home page
    When User checks "Пошук товарів" search field placeholder
    When User checks that Search button is clickable
    When User sees that Wish list icon is displayed
    When User sees that Cart icon is displayed
    When User sees that Promo slider is displayed
    When User sees that All Categories section is displayed
    When User sees that Seo Block section is displayed
    Then Social Networks section is displayed
