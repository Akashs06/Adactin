package Adactin.com.TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = ".\\src\\test\\java\\feature" , 
glue = {"Adactin.com.StepDefination" ,"Hooks"},
tags = "@TC101" , dryRun = false,monochrome = true,stepNotifications = true, 
plugin = {"html:target\\Report\\Adactin.html","json:target\\Report\\Adactin_Json.json"})
public class RunnerClass {


}
//"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"

