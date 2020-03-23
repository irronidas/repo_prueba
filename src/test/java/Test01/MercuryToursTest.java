package Test01;

//import static org.junit.Assert.*;
//import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

//import org.junit.jupiter.api.AfterEach;

import org.testng.annotations.*;
import org.testng.*;
/*
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
*/
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MercuryToursTest {
	private WebDriver Driver;
	By registerlink = By.linkText("REGISTER");
	By registerpage = By.xpath("//img[@src='/images/masts/mast_register.gif']");
	
	By id_element = By.id("email");
	By password_element = By.name("password");
	By confirmar_password_element = By.cssSelector("input[name=confirmPassword]");
	By btn_confirmar = By.name("register");
	
	By user_name = By.name("userName");
	By Password = By.name("password");
	By btn_sinin = By.name("login");
			
	@BeforeClass
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		Driver = new ChromeDriver();
		Driver.manage().window().maximize();
		Driver.get("http://newtours.demoaut.com/");
	}

	@AfterClass
	public void tearDown() throws Exception {
		//Driver.quit();
	}

	@Test
	public void registrar_usuario() throws InterruptedException {
		Driver.findElement(registerlink).click();
		Thread.sleep(2000);
		if(Driver.findElement(registerpage).isDisplayed()){
			Driver.findElement(id_element).sendKeys("jaime");
			Driver.findElement(password_element).sendKeys("1234");
			Driver.findElement(confirmar_password_element).sendKeys("1234");
			Driver.findElement(btn_confirmar).click();
		}
		else{
			System.out.println("Registrar no funciona");
		}
			List<WebElement> fonts = Driver.findElements(By.tagName("font"));
			
			//assertEquals("Note: Your user name is jaime.",fonts.get(5).getText());
			Assert.assertEquals("Note: Your user name is jaime.",fonts.get(5).getText());
	}
	
//	@Test
	//public void login() {
		
		
	}
//}
