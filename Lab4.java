package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab4 {

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		   WebDriverManager.chromedriver().setup();
	       ChromeOptions options = new ChromeOptions();
	       ChromeDriver driver = new ChromeDriver(options);
	       
	   
	       String baseurl = "https://omayo.blogspot.in/";
	       driver.get(baseurl);
	       driver.manage().window().maximize();
	       
	       Actions action = new Actions(driver);
	       
	       
	       //click try it and button will be disabled
	       WebElement tryit = driver.findElement(By.xpath("//button[text()='Try it']"));
	       WebElement DisableButton = driver.findElement(By.xpath("//button[@id='myBtn']"));
	       action.moveToElement(tryit).click().perform();
	       
	       
	       WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	       wait.until(ExpectedConditions.attributeToBe(DisableButton,"disabled", "true"));
	       
	       if(DisableButton.getAttribute("disabled").equals("true")) {
	    	   System.out.print("My Button Disabled");
	       } else {
	    	   System.out.print("My Button Enabled");
	       }
	       System.out.println();
	       
	       //Double Click Here
	       WebElement dbl_click = driver.findElement(By.xpath("//button[@ondblclick='dblclickAlert()']"));
	       action.doubleClick(dbl_click).perform();
	       
	       
	       //Enable My Option
	       WebElement checkThis = driver.findElement(By.xpath("//p[text()='The above Mr Option will be enabled in 10 seconds after clicking on below Check this button']//following-sibling::button"));
	       WebElement myOption = driver.findElement(By.xpath("//input[@id='dte']"));
	       action.moveToElement(checkThis).click().perform();
	       
	       WebDriverWait wait2 = new WebDriverWait(driver,Duration.ofSeconds(12));
	       wait2.until(ExpectedConditions.elementToBeClickable(myOption));
	       
	       if(myOption.isEnabled()) {
	    	   System.out.print("My Option Enabled");
	       } else {
	    	   System.out.print("My Option Disabled");
	       }
	       action.moveToElement(myOption).click().perform();
	       System.out.println();
	      
	       //Click Double Click
	       WebElement double_click = driver.findElement(By.xpath("//p[@id='testdoubleclick']"));
	       action.doubleClick(double_click).perform();
	       
	       //Click DropDown Button
	       WebElement dropdown_button = driver.findElement(By.xpath("//button[@class='dropbtn']"));
	       action.moveToElement(dropdown_button).click().perform();
	       WebElement dropdown = driver.findElement(By.xpath("//div[@id='myDropdown']"));
	       WebDriverWait wait3 = new WebDriverWait(driver,Duration.ofSeconds(5));
	       wait3.until(ExpectedConditions.visibilityOf(dropdown));
	       
	       if(dropdown.isDisplayed()) {
	    	   System.out.print("Dropdown Displayed");
	       } else {
	    	   System.out.print("Dropdown not Displayed");
	       }
	       System.out.println();
	       

	}

}
