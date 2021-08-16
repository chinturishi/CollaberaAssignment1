Feature: To verify create new account functionality

  Background: 
    Given user open the appliaction
    When user click the Sign in button
    Then the Login page should load

  Scenario: User  can a new user account
    When user enter  "testcollabera@gmail.com" in the email address text box
    And click the create an account button
    Then user can enter the  PERSONAL INFORMATION
    When user enter select "Mr." options for title
    And user enter "Collabera" in the first name text box
    And user enter "Test" in the last name text box
    #And user enter "testcollabera@gmail.com" in the email text box
    And user enter "testcollaberapwd" in the password text box
    And user select the "1-April-1990" as dob in the dropdown
    And user enter "Collabera Company" in the company text box
    And user enter "Test address" in the address text box
    And user enter "Bangalore" in the city text box
    And user select the "Alabama" as state in the dropdown
    And user enter "00000" in the pincode text box
    And user select the "United States" as country in the dropdown
    And user enter "8976345678" in the mobile text box
    And click the register button
    Then user should successfully craete the new account
    When user click personal info button
    Then the first name should be "Collabera"
    And the last name should be "Test"
    When user click sign out button
    Then user should be log out

  Scenario: User can login with valid user id and password
    When user enter "testcollabera@gmail.com" in the email text box
    And user enter "testcollaberapwd" in the password text box
    And user click the signin button
    Then user should successfully login
    When user click home button
    And user select an item
    And user click the add to cart button
    And user click the proceed to checkout button
    And user click the proceed to checkout button in summary
    And user click the proceed to address button
    And user check the terms and condition check box
    And user click the proceed to payment button
    Then the product name should be same as the product added
    And the product price should be same as the product added
