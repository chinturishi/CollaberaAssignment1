package com.collabera.hooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.collabera.factory.DriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {

	private DriverFactory driverFactory;
	private WebDriver driver;
	private Properties properties;
	
	@Before(order = 0)
	public void getProperty() {
		driverFactory = new DriverFactory();
		properties = driverFactory.init_prop();
		System.out.println(properties);
	}
	
	@Before(order = 1)
	public void launchBrowser() {
		driver = driverFactory.init_driver(properties);
	}
	
	@After(order = 0)
	public void quitBrowser() {
		if(driver!=null)
			driver.quit();
	}
	
	@After(order = 1)
	public void tearDown(Scenario scenario) {
		if(scenario.isFailed()) {
			String screenshotName=scenario.getName().replaceAll(" ", "-");
			byte[] sourcPath=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcPath, "image/png", screenshotName);
		}
	}
}
