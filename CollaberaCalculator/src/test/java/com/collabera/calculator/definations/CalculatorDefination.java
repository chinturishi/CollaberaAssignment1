package com.collabera.calculator.definations;

import org.junit.Assert;

import com.collabera.calculator.factory.DriverFactory;
import com.collabera.calculator.pages.Calculator;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CalculatorDefination {

	private Calculator calculator;
	@Given("the application should open in the browser")
	public void the_application_should_open_in_the_browser() {
		calculator=new Calculator(DriverFactory.getDriver());
	}
	@When("user select application type as {string}")
	public void user_select_application_type_as(String string) {
		calculator.clickAppliactionType();
	}
	@When("user select number of dependent as {string}")
	public void user_select_number_of_dependent_as(String dependentNo) {
		calculator.selectDependent(dependentNo);
	}
	@When("user select property type as {string}")
	public void user_select_property_type_as(String string) {
		calculator.clickPropertyType();
	}
	@When("user enter the income as {string}")
	public void user_enter_the_income_as(String incomeAmount) {
		calculator.setIncome(incomeAmount);
	}
	@When("user enter the other income as {string}")
	public void user_enter_the_other_income_as(String incomeAmount) {
		calculator.setOtherIncome(incomeAmount);
	}
	@When("user enter the living expenses as {string}")
	public void user_enter_the_living_expenses_as(String expensesAmount) {
		calculator.setExpenses(expensesAmount);
	}
	@When("user enter the current home loan as {string}")
	public void user_enter_the_current_home_loan_as(String loanAmount) {
		calculator.setHomeLoan(loanAmount);
	}
	@When("user enter the other loan as {string}")
	public void user_enter_the_other_loan_as(String loanAmount) {
		calculator.setLoan(loanAmount);
	}
	@When("user enter the other commitment as {string}")
	public void user_enter_the_other_commitment_as(String cAmount) {
		calculator.setCommitments(cAmount);
	}
	@When("user enter the card limit as {string}")
	public void user_enter_the_card_limit_as(String cLimit) {
		calculator.setCardLimit(cLimit);
	}
	@When("user click the Work out how much I could borrow button")
	public void user_click_the_work_out_how_much_i_could_borrow_button() {
		calculator.clickBorrow();
	}
	@Then("user can see the borrow amount as {string}")
	public void user_can_see_the_borrow_amount_as(String string) {
		String text=calculator.getBorrowAmountText();
		System.out.println("***************************");
		System.out.println(text);
		Assert.assertTrue(text.equals(string));
	}
	@When("user click the start over button")
	public void user_click_the_start_over_button() {
		calculator.clickStartOver();
	}
	@Then("user can see the message as {string}")
	public void user_can_see_the_message_as(String string) {
		String text=calculator.getErrorText();
		System.out.println("***************************");
		System.out.println(text);
		Assert.assertTrue(text.equals(string));
	}
}
