package com.amazon.runner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

//import cucumber.api.CucumberOptions;
//import cucumber.api.junit.Cucumber;
//
//@RunWith(Cucumber.class)
//@CucumberOptions(features = "src\\test\\java\\com\\amazon\\feature\\Amazon.feature", 
//glue = "com.amazon.stepdefnition")


@RunWith(Cucumber.class)
@CucumberOptions(features ="src\\test\\java\\com\\amazon\\feature\\Amazon.feature",
glue="com.amazon.stepdefnition" ) 




public class Runner {

	
	public static WebDriver driver;			//null										// instance to static  variable
	
	@BeforeClass
	public static void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\devaa\\eclipse-workspace\\AmazonProject\\chrome105\\chromedriver.exe");
		driver = new ChromeDriver();    							//local changing to instance 
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public static void teardown() {
		
		
		driver.close();
	}
	
	
	
	
}
