package test1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyInput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		   WebDriverManager.chromedriver().setup();
	       ChromeOptions options = new ChromeOptions();
	       
	       ChromeDriver driver = new ChromeDriver(options);
	       
	       String baseurl = "https://omayo.blogspot.in/";
	       driver.get(baseurl);
	       driver.findElement(By.id("ta1")).sendKeys("Nayab Gul");
	
	       driver.findElement(By.xpath("//div[@id='HTML11']//div[@class='widget-content']//textarea")).clear();
	       driver.findElement(By.xpath("//div[@id='HTML11']//div[@class='widget-content']//textarea")).sendKeys("I am friendly and outgoing");
	       
	       driver.findElement(By.xpath("//form[@name='form1']//input[@type='text']")).sendKeys("Nayab");
	       driver.findElement(By.xpath("//form[@name='form1']//input[@type='password']")).sendKeys("Nayab");
	       driver.findElement(By.xpath("//form[@name='form1']//button[@value='LogIn']")).click();
	       
	       driver.switchTo().defaultContent();
	       driver.switchTo().frame("iframe1");
	       driver.switchTo().defaultContent();
	       driver.switchTo().frame("iframe2");
	       driver.switchTo().defaultContent();
	       
	       driver.findElement(By.xpath("//form[@name='login']//input[@name='userid']")).sendKeys("NayabGul");
	       driver.findElement(By.xpath("//form[@name='login']//input[@name='pswrd']")).sendKeys("NayabGul");
	       driver.findElement(By.xpath("//form[@name='login']//input[@value='Login']")).click();
	       
	       driver.switchTo().alert().accept();
	       driver.close();
	}

}


