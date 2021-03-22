package com.qualitystreamtutorial;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {
	
private WebDriver driver;

@Before

public void setUp() {
	
	System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.google.com/");	
}

@Test

public void testGooglePage() {
	WebElement searchbox = driver.findElement(By.name("q"));
	
	searchbox.clear();
	
	searchbox.sendKeys("quality-stream Introducción a la Automatización de Pruebas de Software");
	searchbox.submit();
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	assertEquals("quality-stream Introducción a la Automatización de Pruebas de Software - Buscar con Google", driver.getTitle());
	
}

@After
public void tearDown()  {
	driver.quit();

}
		

}
