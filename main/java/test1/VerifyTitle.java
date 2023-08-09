package test1;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyTitle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		   WebDriverManager.chromedriver().setup();
	       ChromeOptions options = new ChromeOptions();
	       
	       ChromeDriver driver = new ChromeDriver(options);
	       
	       String baseurl = "https://www.google.com";
	       driver.get(baseurl);
	       String actualTitle= driver.getTitle();
	       
	       System.out.print(actualTitle);
	       if (actualTitle.equals("Google")) {
	    	   System.out.println(" Test Passed");
	       } else {
	    	   System.out.println(" Test failed");
	       }
	       
	       driver.close();

	}

}
