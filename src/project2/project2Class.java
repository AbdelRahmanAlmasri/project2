package project2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class project2Class {
	WebDriver driver = new ChromeDriver();

	@BeforeTest
	
	public void mySetup() {
		
driver.get("https://www.saucedemo.com/");
		
		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		driver.manage().window().maximize();
		
		List<WebElement> addtoCartButtons = driver.findElements(By.className("btn_primary"));
		List<WebElement> nameCartButtons = driver.findElements(By.className("inventory_item_name"));
		List<WebElement> itemPrice = driver.findElements(By.className("inventory_item_price"));
				for(int i = 0 ;i<addtoCartButtons.size();i+=2) {
					addtoCartButtons.get(i).click();
					String productName	=nameCartButtons.get(i).getText();
					System.out.println(
						nameCartButtons.get(i).getText() + " was added and the price is " + itemPrice.get(i).getText());
	}
	}
	
	@Test()
	
	public void myTest() {}
	
	
	@AfterTest
	
	public void myAfter() {}
}
