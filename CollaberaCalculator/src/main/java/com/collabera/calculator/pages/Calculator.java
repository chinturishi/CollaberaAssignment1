package com.collabera.calculator.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.collabera.calculator.utils.ElementUtil;



public class Calculator {

	private WebDriver driver;
	private ElementUtil elementUtil;
	private By applicationType=By.xpath("//label[@id='q1q1']/following::ul[@aria-labelledby='q1q1']/li/label[contains(text(),'Single')]/input");
	private By errorMessage=By.xpath("//span[@class='borrow__error__text']");
	private By message=By.xpath("//span[@class='borrow__result__text']");
	private By startOver=By.xpath("//button[@class='start-over' and @aria-label='Start over']");
	private By dependents=By.xpath("//select[@title='Number of dependants']");
	private By type=By.xpath("//input[@id='borrow_type_home']");
	private By income=By.xpath("//input[@aria-labelledby='q2q1']");
	private By oIncome=By.xpath("//input[@aria-labelledby='q2q2']");
	private By expenses=By.xpath("//input[@aria-labelledby='q3q1']");
	private By homeloan=By.xpath("//input[@aria-labelledby='q3q2']");
	private By oLoan=By.xpath("//input[@aria-labelledby='q3q3']");
	private By commitment=By.xpath("//input[@aria-labelledby='q3q4']");
	private By limit=By.xpath("//input[@aria-labelledby='q3q5']");
	private By borrow=By.xpath("//button[text()='Work out how much I could borrow']");
	private By borrowAmount=By.xpath("//span[@id='borrowResultTextAmount']");
	
	public Calculator(WebDriver driver) {
		this.driver = driver;
		this.elementUtil = new ElementUtil(driver);
	}
	
	public void clickAppliactionType() {
		elementUtil.doClick(applicationType);
	}
	
	public void clickPropertyType() {
		elementUtil.doClick(type);
	}
	
	public void clickBorrow() {
		elementUtil.doClick(borrow);
	}
	
	public void clickStartOver() {
		elementUtil.doClick(startOver);
		elementUtil.waitForElementVisible(borrow, 10);
	}
	
	public void selectDependent(String dependentNo) {
		elementUtil.doSelectDropDownByVisibleText(dependents, dependentNo);
	}
	
	public void setIncome(String incomeAmount) {
		elementUtil.doSendKeys(income, incomeAmount);
	}
	
	public void setOtherIncome(String incomeAmount) {
		elementUtil.doSendKeys(oIncome, incomeAmount);
	}
	
	public void setExpenses(String expensesAmount) {
		elementUtil.doSendKeys(expenses, expensesAmount);
	}
	
	public void setHomeLoan(String loanAmount) {
		elementUtil.doSendKeys(homeloan, loanAmount);
	}
	
	public void setLoan(String loanAmount) {
		elementUtil.doSendKeys(oLoan, loanAmount);
	}
	
	public void setCommitments(String cAmount) {
		elementUtil.doSendKeys(commitment, cAmount);
	}
	
	public void setCardLimit(String cLimit) {
		elementUtil.doSendKeys(limit, cLimit);
	}
	
	public String getErrorText() {
		elementUtil.waitForElementVisible(errorMessage, 10);
		return elementUtil.doGetText(errorMessage);
	}
	
	public String getBorrowAmountText() {
		boolean b=elementUtil.waitForAttributPresent(message, 20, "aria-live", "assertive");
		System.out.println("#####################");
		System.out.println(b);
		return elementUtil.doGetText(borrowAmount);
	}
	
	
	
	
	
	
	
	
	
}
