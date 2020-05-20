Feature: Customers
  Scenario: Add a new customer
    Given User Launch Chrome browser
    When User open URL "https://admin-demo.nopcommerce.com/login/"
    And User enters Email as "admin@yourstore.com" and Password as "admin"
    And Click on Login
    Then User can view Dashboard
    When User click on Customers Menu
    And User click on Customers Menu Item
    And Click on Add new button
    Then Customer can view and Add new customer page
    When User enter customer info
    And Click on Save button
    Then User can view confirmation message "The new customer has been added successfully."
    And close browser