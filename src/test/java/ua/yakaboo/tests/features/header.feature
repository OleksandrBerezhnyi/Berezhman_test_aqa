Feature: Header section

  Background: Pre-condition
    Given Check that Header section is displayed

  @SmokeTest
  Scenario: Check check elements in the Header section
    When User clicks Cancel button on the dialog
    When User clicks Promotions button in the section
    Then User sees that Discounts page opens
    When User clicks About Us button in the section
    Then User sees that About Us page opens
    When User clicks Delivery button in the section
    Then User sees that Delivery page opens
    When User clicks Payment button in the section
    Then User sees that Payment page opens
    When User clicks Contact button in the section
    Then User sees that Contact page opens
    When User clicks Blog button in the section
    Then User redirects to Blog page