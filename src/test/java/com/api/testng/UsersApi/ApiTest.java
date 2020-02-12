package com.api.testng.UsersApi;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@SuppressWarnings("deprecation")
public class ApiTest {
	private WebDriver driver;
	
	@BeforeTest
	public void setUp() throws Exception {
		  driver = new FirefoxDriver();
		  //  baseUrl = "https://5alive.moviuscorp.net/";
		    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  }


	@AfterTest
	public void tearDown() throws Exception {
		 driver.close();
	}

	@Test
	public void test() throws IOException {
		driver.get("https://5alive.moviuscorp.net:8021/adk/services/messaging/addressassignments?device_number=916362907347&sip_password=J93cu5f");	
	 WebElement webElement=driver.findElement(By.xpath("(//*[contains(text(),'Success')])[1]"));
	 String text = webElement.getText();
	 //ApiResponse weatherApiResponse=new ApiResponse();
	 //String ExpectedString=weatherApiResponse.GetResponse();
	 Assert.assertTrue(text.equals("Success"));
	 System.out.println("Test sucesss");
	}

}
