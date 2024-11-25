package sMR;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base1 
{
public WebDriver driver;
	public void Chromesetup()
	{		
		WebDriverManager.chromedriver().setup();  //open Chrome Driver
		driver= new ChromeDriver();
		driver.get("https://dealercrm.co.in/login");
		driver.manage().window().maximize();
	}
}
