package com.collabera.definations;

import java.util.Random;

import org.junit.Assert;

import com.collabera.factory.DriverFactory;
import com.collabera.pages.Login;
import com.collabera.pages.MyStore;
import com.collabera.utils.Variables;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterUserDefination {

	MyStore store = new MyStore(DriverFactory.getDriver());
	Login login;

	@Given("user open the appliaction")
	public void user_open_the_appliaction() {

	}

	@When("user click the Sign in button")
	public void user_click_the_sign_in_button() {
		login = store.clickSignIn();
	}

	@Then("the Login page should load")
	public void the_login_page_should_load() {
		String text = login.getHeaderText();
		Assert.assertTrue(text.equals("CREATE AN ACCOUNT"));
	}

	@When("user enter  {string} in the email address text box")
	public void user_enter_in_the_email_address_text_box(String email) {
		Random rand = new Random();
		int number = rand.nextInt(99);
		String[] emailarray = email.split("@");
		email = emailarray[0] + number + "@" + emailarray[1];
		System.out.println(email);
		login.enterEmailId(email);
	}

	@When("click the create an account button")
	public void click_the_create_an_account_button() {
		login.createAccount();
	}

	@Then("user can enter the  PERSONAL INFORMATION")
	public void user_can_enter_the_personal_information() {
		String text = login.getPersonalInfoText();
		Assert.assertTrue(text.equals("YOUR PERSONAL INFORMATION"));
	}

	@When("user enter select {string} options for title")
	public void user_enter_select_options_for_title(String string) {
		login.selectTitle(string);
	}

	@When("user enter {string} in the first name text box")
	public void user_enter_in_the_first_name_text_box(String name) {
		login.enterFirstName(name);
	}

	@When("user enter {string} in the last name text box")
	public void user_enter_in_the_last_name_text_box(String name) {
		login.enterLastName(name);
	}

	@When("user enter {string} in the email text box")
	public void user_enter_in_the_email_text_box(String email) {
		login.enterEmail(email);
	}

	@When("user enter {string} in the password text box")
	public void user_enter_in_the_password_text_box(String pwd) {
		login.enterpwd(pwd);
	}

	@When("user select the {string} as dob in the dropdown")
	public void user_select_the_as_dob_in_the_dropdown(String dob) {
		login.selectDOB(dob);
	}

	@When("user enter {string} in the company text box")
	public void user_enter_in_the_company_text_box(String com) {
		login.enterCompany(com);
	}

	@When("user enter {string} in the address text box")
	public void user_enter_in_the_address_text_box(String add) {
		login.enterAddress(add);
	}

	@When("user enter {string} in the city text box")
	public void user_enter_in_the_city_text_box(String cit) {
		login.enterCity(cit);
	}

	@When("user select the {string} as state in the dropdown")
	public void user_select_the_as_state_in_the_dropdown(String st) {
		login.selectState(st);
	}

	@When("user enter {string} in the pincode text box")
	public void user_enter_in_the_pincode_text_box(String code) {
		login.enterZip(code);
	}

	@When("user select the {string} as country in the dropdown")
	public void user_select_the_as_country_in_the_dropdown(String ct) {
		login.selectCountry(ct);
	}

	@When("user enter {string} in the mobile text box")
	public void user_enter_in_the_mobile_text_box(String mob) {
		login.enterMobile(mob);
	}

	@When("click the register button")
	public void click_the_register_button() {
		login.clickRegister();
	}

	@Then("user should successfully craete the new account")
	public void user_should_successfully_craete_the_new_account() {
		String text = login.getWelcometext();
		Assert.assertTrue(text
				.equals("Welcome to your account. Here you can manage all of your personal information and orders."));
	}

	@When("user click personal info button")
	public void user_click_personal_info_button() {
		login.clickInfo();
	}

	@Then("the first name should be {string}")
	public void the_first_name_should_be(String string) {
		// String text=login.getPersonalInfoText();
		// Assert.assertTrue(text.equals("YOUR PERSONAL INFORMATION"));
		String name = login.getFirstNametext();
		System.out.println("******************************************************************");
		System.out.println(name);
		System.out.println(string);
		Assert.assertTrue(name.equals(string));
	}

	@Then("the last name should be {string}")
	public void the_last_name_should_be(String string) {
		String name = login.getlastNametext();
		Assert.assertTrue(name.equals(string));
	}

	@When("user click sign out button")
	public void user_click_sign_out_button() {
		login.clickSignOut();
	}

	@Then("user should be log out")
	public void user_should_be_log_out() {
		String text = login.getHeaderText();
		Assert.assertTrue(text.equals("CREATE AN ACCOUNT"));
	}

	@When("user click the signin button")
	public void user_click_the_signin_button() {
		login.clickSignin();
	}

	@Then("user should successfully login")
	public void user_should_successfully_login() {
		String text = login.getWelcometext();
		Assert.assertTrue(text
				.equals("Welcome to your account. Here you can manage all of your personal information and orders."));
	}

	@When("user click home button")
	public void user_click_home_button() {
		store=login.clickHome();
	}

	@When("user select an item")
	public void user_select_an_item() {
		store.selectItem();
	}

	@When("user click the add to cart button")
	public void user_click_the_add_to_cart_button() {
		store.clickAddtoCart();
	}
	
	@When("user click the proceed to checkout button")
	public void user_click_the_proceed_to_checkout_button() {
		store.clickCheckOut();
	}
	
	@When("user click the proceed to checkout button in summary")
	public void user_click_the_proceed_to_checkout_button_in_summary() {
		store.clickProceedToCheckOut();
	}
	
	@When("user click the proceed to address button")
	public void user_click_the_proceed_to_address_button() {
		store.clickProceedToAddress();
	}
	
	@When("user check the terms and condition check box")
	public void user_check_the_terms_and_condition_check_box() {
		store.selectTerms();
	}
	
	@When("user click the proceed to payment button")
	public void user_click_the_proceed_to_payment_button() {
		store.clickProcessCarrier();
	}
	
	@Then("the product name should be same as the product added")
	public void the_product_name_should_be_same_as_the_product_added() {
		String name=store.getProductName();
		Assert.assertTrue(name.equals(Variables.itemName));
	}
	@When("the product price should be same as the product added")
	public void the_product_price_should_be_same_as_the_product_added() {
		String price=store.getProductPrice();
		Assert.assertTrue(price.equals(Variables.price));
	}
}
