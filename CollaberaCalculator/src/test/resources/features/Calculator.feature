Feature: Verify the how much could borrow feature

Scenario: As a user I can find out how much I can borrow

Given the application should open in the browser

When user select application type as "Single"
And user select number of dependent as "0"
And user select property type as "Home to live in"
And user enter the income as "80000"
And user enter the other income as "10000"
And user enter the living expenses as "500"
And user enter the current home loan as "0"
And user enter the other loan as "100"
And user enter the other commitment as "0"
And user enter the card limit as "10000"
And user click the Work out how much I could borrow button
Then user can see the borrow amount as "$507,000"

When user click the start over button
And user enter the living expenses as "1"
And user click the Work out how much I could borrow button
Then user can see the message as "Based on the details you've entered, we're unable to give you an estimate of your borrowing power with this calculator. For questions, call us on 1800 035 500."
