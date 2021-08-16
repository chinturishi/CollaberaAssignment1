package com.collabera.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.collabera.utils.ElementUtil;

public class Login {

	private WebDriver driver;
	private ElementUtil elementUtil;

	private By createAccount = By.xpath("//h3[text()='Create an account']");
	private By emailID = By.id("email_create");
	private By cAccount = By.id("SubmitCreate");
	private By personalInfo = By.xpath("//h3[text()='Your personal information']");
	private By fName = By.id("customer_firstname");
	private By lName = By.id("customer_lastname");
	private By email = By.id("email");
	private By password = By.id("passwd");
	private By days = By.id("days");
	private By months = By.id("months");
	private By years = By.id("years");
	private By afirstName = By.id("firstname");
	private By aLastName = By.id("lastname");
	private By company = By.id("company");
	private By address = By.id("address1");
	private By city = By.id("city");
	private By state = By.id("id_state");
	private By zip = By.id("postcode");
	private By country = By.id("id_country");
	private By mobile = By.id("phone_mobile");
	private By addressName = By.id("alias");
	private By register = By.id("submitAccount");
	private By welcomeMessage = By.xpath("//p[@class='info-account']");
	private By info = By.xpath("//a[@title='Information']");
	private By signOut = By.xpath("//a[contains(text(),'Sign out')]");
	private By login = By.id("SubmitLogin");
	private By home = By.xpath("//a[@title='Home']");

	public Login(WebDriver driver) {
		this.driver = driver;
		this.elementUtil = new ElementUtil(driver);
	}

	public String getHeaderText() {
		elementUtil.waitForElementVisible(createAccount,10);
		return elementUtil.doGetText(createAccount);
	}

	public void enterEmailId(String email) {
		elementUtil.doSendKeys(emailID, email);
	}
	public void enterEmail(String emailtext) {
		elementUtil.doSendKeys(email, emailtext);
	}

	public void createAccount() {
		elementUtil.doClick(cAccount);
	}

	public String getPersonalInfoText() {
		elementUtil.waitForElementVisible(personalInfo,10);
		return elementUtil.doGetText(personalInfo);
	}

	public void selectTitle(String titleValue) {
		String id = "";
		if (titleValue.equals("Mr.")) {
			id = "id_gender1";
		} else {
			id = "id_gender2";
		}
		elementUtil.doClick(By.id(id));
	}

	public void enterFirstName(String name) {
		elementUtil.doSendKeys(fName, name);
	}

	public void enterLastName(String name) {
		elementUtil.doSendKeys(lName, name);
	}

	public void enterpwd(String pwd) {
		elementUtil.doSendKeys(password, pwd);
	}

	public String getEmailText() {
		return elementUtil.doGetText(email);
	}

	public void selectDOB(String dob) {
		String[] dobArray = dob.split("-");
		System.out.println(dobArray[0]);
		elementUtil.doSelectDropDownByVisibleText(days, dobArray[0]+"  ");
		elementUtil.doSelectDropDownByVisibleText(months, dobArray[1]+" ");
		elementUtil.doSelectDropDownByVisibleText(years, dobArray[2]+"  ");
	}

	public String getFirstNametext() {
		return elementUtil.doGetTagValue(afirstName,"value");
	}

	public String getlastNametext() {
		return elementUtil.doGetTagValue(aLastName,"value");
	}

	public void enterCompany(String com) {
		elementUtil.doSendKeys(company, com);
	}

	public void enterAddress(String add) {
		elementUtil.doSendKeys(address, add);
	}

	public void enterCity(String cit) {
		elementUtil.doSendKeys(city, cit);
	}

	public void selectState(String st) {
		elementUtil.doSelectDropDownByVisibleText(state, st);
	}
	public void enterZip(String code) {
		elementUtil.doSendKeys(zip, code);
	}
	
	public void selectCountry(String ct) {
		elementUtil.doSelectDropDownByVisibleText(country, ct);
	}
	public void enterMobile(String mob) {
		elementUtil.doSendKeys(mobile, mob);
	}
	
	public void clickRegister() {
		elementUtil.doClick(register);
	}
	
	public String getWelcometext() {
		elementUtil.waitForElementVisible(welcomeMessage,10);
		return elementUtil.doGetText(welcomeMessage);
	}
	
	public void clickInfo() {
		elementUtil.doClick(info);
	}
	public void clickSignOut() {
		elementUtil.doClick(signOut);
	}
	
	public MyStore clickHome() {
		elementUtil.doClick(home);
		return new MyStore(driver);
	}
	
	public void clickSignin() {
		elementUtil.doClick(login);
	}
	
}
