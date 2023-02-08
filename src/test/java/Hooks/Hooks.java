package Hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import Adactin.com.Baseclass.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends BaseClass{
	
	
	@Before
	public void beforeHooks() {
		System.out.println("Before Hooks");
	}
	@After
	public void afterHooks(Scenario scenario) {
		TakesScreenshot sh = (TakesScreenshot) driver;
		byte[] screenshotAs = sh.getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshotAs, "image/png", "screenshot");
		
	}
	

}
