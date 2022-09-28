package com.amazon.stepdefinition;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.amazon.runner.Runner;
import com.flipkart.project7.FlipkartProject.XLXXReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;


public class StepDefinition {


	WebDriver driver= Runner.driver;     			 // null 												//instance variable
	
	@Given("^user Lanuch The Website$")
	public void user_Lanuch_The_Website() throws Throwable {
		driver.get("https://www.amazon.in/");
		//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		
	}

	@When("^user Select The Product From DropDown$")
	public void user_Select_The_Product_From_DropDown() throws Throwable {
	
		WebElement findElement = driver.findElement(By.xpath("//select[@name='url']"));
		String value = XLXXReader.particularData("amazon", 1, 0);
		
		Select s = new Select(findElement); // System.out.println(s.isMultiple());

		List<WebElement> options = s.getOptions(); // ListIterator<WebElement> l = options.listIterator();

		for (int i = 0; i < options.size(); i++) {

			String actual = options.get(i).getText();

			if (value.equals(actual)) {
				s.selectByVisibleText(actual);
			}
		}

		
		
	}

	@When("^user Search The Product$")
	public void user_Search_The_Product() throws Throwable {
		
		String search = XLXXReader.particularData("amazon", 1, 1);
		WebElement findElement2 = driver
				.findElement(By.xpath("//select[@name='url']/ancestor::div[3]/following-sibling::div/div/input"));
		findElement2.sendKeys(search);
		
		
		
		
	}

	@When("^user Select The Product From Suggestions$")
	public void user_Select_The_Product_From_Suggestions() throws Throwable {
	
		List<WebElement> searchoptions = driver
				.findElements(By.xpath("//div[@class='autocomplete-results-container']/child::div"));
		int count = searchoptions.size();
//WebElement item= searchoptions.get(2);
//System.out.println(item.getText());
	
		for (int i = 0; i < searchoptions.size(); i++) {
			int svalue = count - 2;
			WebElement q = driver.findElement(
					By.xpath("//div[@class='autocomplete-results-container']/child::div["+svalue+"]/div/div"));
			q.click();
			break;
		}

		System.out.println("Completed");

		
	}

//	@Then("^user Click The Search Button$")
//	public void user_Click_The_Search_Button() throws Throwable {
//	
//	}


	
	
	
	
	
	
	
	
}
