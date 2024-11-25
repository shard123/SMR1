package sMR;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Login1 extends Base1
{	
	@BeforeTest
	public void InvokeBrowser()
	{
		Chromesetup();
	}
	
	@Test(priority = 1)
	public void Loginwithvalidcredentional() throws InterruptedException
	{
		driver.findElement(By.cssSelector("#mat-input-0")).sendKeys("North2RSM00001");
		driver.findElement(By.cssSelector("#mat-input-1")).sendKeys("MarutiCNM#@123");
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		
		WebElement captchaElement = driver.findElement(By.cssSelector("input.form-control.captabg"));
	    String captchaText = captchaElement.getAttribute("value");
	    System.out.println("Extracted CAPTCHA text: " + captchaText);
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("(//input[@placeholder=\"Enter the captcha..\"])[1]")).sendKeys(captchaText);
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//*[@type='submit']")).click();
	}
	
//SMR Due Date Report generate with current month 1 to current Date.
	
	@Test(priority = 2)
	public void SMRDUEReports() throws Exception
	{	
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(50));//Explicit wait
		  
		  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//mat-icon[normalize-space()='chevron_right']")));
		  driver.findElement(By.xpath("//mat-icon[normalize-space()='chevron_right']")).click();
		  driver.findElement(By.xpath("//mat-icon[contains(@class, 'arrow-icon')]")).click();
		  driver.findElement(By.xpath("//mat-icon[text()='data_usage']")).click();
		  Thread.sleep(5000);
		  driver.findElement(By.xpath("//img[@alt='calendar']")).click();
		  
		List<WebElement> dataElement = driver.findElements(By.xpath("//td[@class=\"mat-calendar-body-cell-container ng-star-inserted\"]"));
		WebElement element = dataElement.get(0);
		element.click();                                     // click on first date of the month
		LocalDate currentDate = LocalDate.now();
		String currentDay = String.valueOf(currentDate.getDayOfMonth());
		List<WebElement> dayElements = driver.findElements(By.xpath("//td[@class=\"mat-calendar-body-cell-container ng-star-inserted\"]"));
			for (WebElement dayElement : dayElements) 
			{
				if (dayElement.getText().equals(currentDay))
				{
					dayElement.click();  // click on the current day of the month
					break;
				}
			}
		driver.findElement(By.xpath("//span[text()='Generate']")).click();		Thread.sleep(60000);
	}
	
	@Test(priority = 3)
	public void Match() throws InterruptedException 
	{	
		WebElement Total = driver.findElement(By.xpath("(//table[@role=\"table\"]//tr[1])[2]//td[2]"));
		String s1 = Total.getText();//Data Assign Total Value
		System.out.println(s1);
		
		driver.findElement(By.xpath("//button[normalize-space(text())='Dealer Parent Group Wise']")).click();	
		driver.findElement(By.xpath("//span[normalize-space(text())='Generate']")).click();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);//Page Scroll
		
		
	}		
}
