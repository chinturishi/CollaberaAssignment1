package com.collabera.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.collabera.utils.ElementUtil;
import com.collabera.utils.Variables;

public class MyStore {

	private WebDriver driver;
	private ElementUtil elementUtil;
	
	private By signIn=By.xpath("//a[contains(text(),'Sign in')]");
	private By item= By.xpath("//ul[@id='homefeatured']/li[1]/descendant::div[@class='product-image-container']");
	private By addtocart= By.xpath("//ul[@id='homefeatured']/li[1]/descendant::a[@title='Add to cart']");
	private By price= By.id("our_price_display");
	private By itemName= By.xpath("//p[@id='product_reference']/preceding::h1");
	private By cart=By.name("Submit");
	private By checkOut=By.xpath("//a[@title='Proceed to checkout']");
	private By pcheckOut=By.xpath("//p[@class='cart_navigation clearfix']/a[@title='Proceed to checkout']");
	private By proceedAddress=By.name("processAddress");
	private By processCarrier=By.name("processCarrier");
	private By terms= By.id("cgv");
	private By productName=By.xpath("//p[@class='product-name']/a");
	private By productPrice=By.xpath("//td[@class='cart_unit']/span[contains(@id,'product_price')]/span");
	
	public MyStore(WebDriver driver) {
		this.driver = driver;
		this.elementUtil = new ElementUtil(driver);
	}
	
	public Login clickSignIn() {
		elementUtil.doClick(signIn);
		return new Login(driver);
	}
	
	public void selectItem() {
		elementUtil.waitForElementVisible(item, 10);
		elementUtil.doClick(item);
	}
	
	public void clickAddtoCart() {
		elementUtil.waitForElementVisible(cart, 10);
		Variables.price=elementUtil.doGetText(price);
		Variables.itemName=elementUtil.doGetText(itemName);
		elementUtil.doClick(cart);
	}
	public void clickCheckOut() {
		elementUtil.waitForElementVisible(checkOut, 10);
		elementUtil.doClick(checkOut);
	}
	
	public void clickProceedToCheckOut() {
		elementUtil.waitForElementVisible(pcheckOut, 10);
		elementUtil.doClick(pcheckOut);
	}
	
	public void clickProceedToAddress() {
		elementUtil.waitForElementVisible(proceedAddress, 10);
		elementUtil.doClick(proceedAddress);
	}
	
	public void selectTerms() {
		elementUtil.doClick(terms);
	}
	
	public void clickProcessCarrier() {
		elementUtil.doClick(processCarrier);
	}
	
	public String  getProductPrice() {
		return elementUtil.doGetText(productPrice);
	}
	public String  getProductName() {
		return elementUtil.doGetText(productName);
	}
	
	
}
