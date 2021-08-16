package com.collabera.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {

	private WebDriver driver;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getElement(By locator) {
		WebElement element = driver.findElement(locator);
		return element;
	}

	public void doClick(By locator) {
		getElement(locator).click();
	}

	public String doGetText(By locator) {
		return getElement(locator).getText();
	}

	public String doGetTagValue(By locator, String attribute) {
		return getElement(locator).getAttribute(attribute);
	}

	public void doSendKeys(By locator, String value) {
		WebElement element = getElement(locator);
		element.clear();
		element.sendKeys(value);
	}

	public void doSelectDropDownByVisibleText(By locator, String visibletext) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(visibletext);
	}

	public WebElement waitForElementVisible(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void mouseOver(By locator) {
		Actions actions = new Actions(driver);
		WebElement element = getElement(locator);
		actions.moveToElement(element);
	}

	public void scrollDown(By locator) {
		WebElement element = getElement(locator);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	public void switchToFrame(String id) {
		driver.switchTo().frame(id);
	}

}
