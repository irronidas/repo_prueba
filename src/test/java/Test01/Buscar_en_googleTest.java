package Test01;


import org.testng.annotations.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;

/*
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.*;
//import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
//import static org.junit.Assert.assertEquals;
*/
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Buscar_en_googleTest {
	private WebDriver Driver;
		
		@BeforeTest
		public void setup() {
			//DesiredCapabilities caps = new DesiredCapabilities();
			System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
			Driver = new ChromeDriver();
			Driver.manage().window().maximize();
			Driver.get("http://google.cl");
	
		}
		
		@Test
		public void Testgoole() {
			WebElement buscar = Driver.findElement(By.name("q"));
			buscar.clear();
			buscar.sendKeys("Ikki");
			buscar.submit();
			Driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
			
		   assertEquals("Ikki - Buscar con Google", Driver.getTitle());
		}
		
		@AfterClass
		public void TearDown(){
			Driver.close();
		}
		
	}
