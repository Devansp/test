package com.flipkart.project7.FlipkartProject;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class BasicTest {

//	static String value = "Books";
//	static String search = "ponniyin selvan";
//static String select="ponniyin selvan book";

	public static void main(String[] args) throws InterruptedException, IOException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\devaa\\eclipse-workspace\\FlipkartProject\\target\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebElement findElement = driver.findElement(By.xpath("//select[@name='url']"));
		String value = XLXXReader.particularData("amazon", 1, 0);
		
		Select s = new Select(findElement); // System.out.println(s.isMultiple());

		List<WebElement> options = s.getOptions(); // ListIterator<WebElement> l = options.listIterator();

		for (int i = 0; i < options.size(); i++) {

			String actual = options.get(i).getText();

//System.out.println(actual);
			if (value.equals(actual)) {
				s.selectByVisibleText(actual);
			}
		}
		
		
		String search = XLXXReader.particularData("amazon", 1, 1);
		WebElement findElement2 = driver
				.findElement(By.xpath("//select[@name='url']/ancestor::div[3]/following-sibling::div/div/input"));
		findElement2.sendKeys(search);
		Thread.sleep(3000);

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
}
 
	
