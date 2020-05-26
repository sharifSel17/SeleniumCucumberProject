Feature: Customers
  Background: bellow steps are common for every scenario
    Given User Launch Chrome browser
    When User open URL "https://admin-demo.nopcommerce.com/login/"
    And User enters Email as "admin@yourstore.com" and Password as "admin"
    And Click on Login
    Then User can view Dashboard
  @sanity
  Scenario: Add a new customer
    When User click on Customers Menu
    And User click on Customers Menu Item
    And Click on Add new button
    Then Customer can view and Add new customer page
    When User enter customer info
    And Click on Save button
    Then User can view confirmation message "The new customer has been added successfully."
    And close browser

  @regression
    Scenario: Search customer by EmailId
      When User click on Customers Menu
      And User click on Customers Menu Item
      And Enter customer Email
      When Click on search button
      Then User should found email in the search table
      And close browser
  @regression
  Scenario: Search customer by Customer Name
    When User click on Customers Menu
    And User click on Customers Menu Item
    And Enter customer FirstName
    And Enter customer LastName
    When Click on search button
    Then User should found Name in the search table
    And close browser