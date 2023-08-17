package TestNG;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.apache.log4j.Logger;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNG {
	
	WebDriver driver;
	ChromeOptions options;
	Logger logger;

	@Test(priority = 1, description= "Manager is adding customer") 
	
	public void AddCustomer() throws InterruptedException, IOException {

		// Setup
		WebDriverManager.chromedriver().setup();
		options = new ChromeOptions();
		driver = new ChromeDriver(options);
		Actions action = new Actions(driver);
		PropertyConfigurator.configure("Log4j.properties");
		logger = Logger.getLogger("AddCustomer");

		// Open URL
		String baseurl = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login";
		driver.get(baseurl);
		driver.manage().window().maximize();
		logger.info("Opened URL");

		// Click Manager Login
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[text()='Bank Manager Login']")));
		WebElement managerLogin = driver.findElement(By.xpath("//button[text()='Bank Manager Login']"));
		action.moveToElement(managerLogin).click().perform();
		logger.info("Manager logged in");

		// Add Customer
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[@ng-class='btnClass1']")));
		WebElement addCustomer = driver.findElement(By.xpath("//button[@ng-class='btnClass1']"));
		action.moveToElement(addCustomer).click().perform();
		logger.info("Manager wants to add customer");

		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait2.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='form-group']//input[@placeHolder='First Name']")));
		WebElement firstName = driver.findElement(By.xpath("//div[@class='form-group']//input[@placeHolder='First Name']"));
		firstName.sendKeys("Nayab");

		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait3.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='form-group']//input[@placeHolder='Last Name']")));
		WebElement lastName = driver.findElement(By.xpath("//div[@class='form-group']//input[@placeHolder='Last Name']"));
		lastName.sendKeys("Gul");

		WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait4.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='form-group']//input[@placeHolder='Post Code']")));
		WebElement postCode = driver.findElement(By.xpath("//div[@class='form-group']//input[@placeHolder='Post Code']"));
		postCode.sendKeys("54000");
		logger.info("Manager has added details of customer");

		WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait5.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//form[@name='myForm']//button")));
		WebElement addCustomer2 = driver.findElement(By.xpath("//form[@name='myForm']//button"));
		action.moveToElement(addCustomer2).click().perform();
		logger.info("Manager has added the customer");

		driver.switchTo().alert().accept();
		logger.info("Customer has been successfully added");

	}

	@Test(priority = 2, description = "Manager is opening account") 
	public void OpenAccount() throws InterruptedException {

		
		Actions action = new Actions(driver);
		PropertyConfigurator.configure("Log4j.properties");
		logger = Logger.getLogger("OpenAccount");

		WebDriverWait wait6 = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait6.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='center']//button[@ng-class='btnClass2']")));
		WebElement openAccount = driver.findElement(By.xpath("//div[@class='center']//button[@ng-class='btnClass2']"));
		action.moveToElement(openAccount).click().perform();
		logger.info("Manager wants to open account");

	

		WebDriverWait wait7 = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait7.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//select[@name='userSelect']")));
		Select customerName = new Select(driver.findElement(By.xpath("//select[@name='userSelect']")));
		customerName.selectByVisibleText("Nayab Gul");

		
		WebDriverWait wait8 = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait8.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//select[@id='currency']")));
		Select currency = new Select(driver.findElement(By.xpath("//select[@id='currency']")));
		currency.selectByIndex(2);
		logger.info("Account details have been added");

		
		WebDriverWait wait9 = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait9.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//form[@name='myForm']//button")));
		WebElement process = driver.findElement(By.xpath("//form[@name='myForm']//button"));
		action.moveToElement(process).click().perform();
		logger.info("Account is processing");
	
		
		driver.switchTo().alert().accept();
		logger.info("Account has successfully opened");
	

		WebDriverWait wait10 = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait10.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[@class='btn home']")));
		WebElement homeButton = driver.findElement(By.xpath("//button[@class='btn home']"));
		action.moveToElement(homeButton).click().perform();
		
	}

	@Test(priority = 3, description= "Customer is depositing amount")
	public void DepositAmount() throws InterruptedException {

		
		Actions action = new Actions(driver);
		PropertyConfigurator.configure("Log4j.properties");
		logger = Logger.getLogger("DepositAmount");


		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[@ng-click='customer()']")));
		WebElement customerLogin = driver.findElement(By.xpath("//button[@ng-click='customer()']"));
		action.moveToElement(customerLogin).click().perform();
		logger.info("Customer wants to login");
		
		
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='form-group']//select")));
		Select user = new Select(driver.findElement(By.xpath("//div[@class='form-group']//select")));
		user.selectByVisibleText("Nayab Gul");

	
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait2.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//form[@name='myForm']//button")));
		WebElement login = driver.findElement(By.xpath("//form[@name='myForm']//button"));
		action.moveToElement(login).click().perform();
		logger.info("Customer logs in");
		


		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait3.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[@ng-class='btnClass2']")));
		WebElement deposit = driver.findElement(By.xpath("//button[@ng-class='btnClass2']"));
		action.moveToElement(deposit).click().perform();
		logger.info("Customer wants to make a deposit");

	
		WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait4.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@type='number']")));
		WebElement depositAmount = driver.findElement(By.xpath("//input[@type='number']"));
		depositAmount.sendKeys("6000");
		logger.info("Customer selects amount to be deposited");

		
		WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait5.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//form[@name='myForm']//button")));
		WebElement deposit2 = driver.findElement(By.xpath("//form[@name='myForm']//button"));
		action.moveToElement(deposit2).click().perform();
		logger.info("Customer deposits amount successfully");

		
	}
	
	@Test (priority = 4, description = "Customer is withdrawing amount") 
	public void WithdrawAmount() throws InterruptedException {
		
		Actions action = new Actions(driver);
		PropertyConfigurator.configure("Log4j.properties");
		logger = Logger.getLogger("WithdrawAmount");

		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//form[@name='myForm']//button")));
		WebElement withdrawal = driver.findElement(By.xpath("//button[@ng-class='btnClass3']"));
		action.moveToElement(withdrawal).click().perform();
		logger.info("Customer wants to withdraw amount");
		
		
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@type='number']")));
		WebElement withdrawAmount = driver.findElement(By.xpath("//input[@type='number']"));
		withdrawAmount.sendKeys("2000");
		logger.info("Customer enters amount to be withdrawn");
		
		
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait2.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//form[@name='myForm']//button")));
		WebElement withdraw = driver.findElement(By.xpath("//form[@name='myForm']//button"));
		action.moveToElement(withdraw).click().perform();
		logger.info("Customer withdraws amount successfully");

	}
	
	
	@Test (priority = 5, description = "Customer is resetting transactions")
	public void ResetTransactions() throws InterruptedException {
		
		Actions action = new Actions(driver);
		PropertyConfigurator.configure("Log4j.properties");
		logger = Logger.getLogger("ResetTransactions");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[@ng-click='transactions()' and @class='btn btn-lg tab']")));
		WebElement transactions = driver.findElement(By.xpath("//button[@ng-click='transactions()' and @class='btn btn-lg tab']"));
		action.moveToElement(transactions).click().perform();
		logger.info("Customer wants to check transaction hisotry");
		
		//Printing table using list method
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table[@class='table table-bordered table-striped']")));
        WebElement table = driver.findElement(By.xpath("//table[@class='table table-bordered table-striped']"));
        
        List <WebElement> headingdata =table.findElements(By.tagName("thead"));
    	for(WebElement heading:headingdata)
    	{
    		List <WebElement> head =heading.findElements(By.tagName("th"));
    		for(WebElement hd:head)
    		{
    			System.out.println(hd.getText()+"\t");
    		}
    	
    		List <WebElement> row =table.findElements(By.tagName("tbody"));
    		for(WebElement rowdata:row)
    		{
    			List <WebElement>rows  = rowdata.findElements(By.tagName("tr"));
    			for(WebElement td:rows)
    			{
    				System.out.println("\n"+td.getText()+"\t");
    			}

    		}
    	}
    	
    	logger.info("print transactions");
    	
    	WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait2.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[@ng-click='reset()' and @class='btn']")));
    	WebElement reset = driver.findElement(By.xpath("//button[@ng-click='reset()' and @class='btn']"));
    	action.moveToElement(reset).click().perform();
    	logger.info("reset transactions");
   
    	
    	WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait3.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[@class='btn logout']")));
		WebElement logout = driver.findElement(By.xpath("//button[@class='btn logout']"));
		action.moveToElement(logout).click().perform();
		logger.info("Customer logs out");
		
		WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait4.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[@class='btn home']")));
		WebElement homeButton = driver.findElement(By.xpath("//button[@class='btn home']"));
		action.moveToElement(homeButton).click().perform();
		
	}
	
	@Test
	(priority = 6 , description="Manager is deleting customer") 
	public void DeleteCustomer() throws InterruptedException
	{
		Actions action = new Actions(driver);
		PropertyConfigurator.configure("Log4j.properties");
		logger = Logger.getLogger("DeleteCustomer");
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[text()='Bank Manager Login']")));
		WebElement managerLogin = driver.findElement(By.xpath("//button[text()='Bank Manager Login']"));
		action.moveToElement(managerLogin).click().perform();
		logger.info("Manager logged in");

		
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='center']//button[@ng-class='btnClass3']")));
		WebElement Customers = driver.findElement(By.xpath("//div[@class='center']//button[@ng-class='btnClass3']"));
		action.moveToElement(Customers).click().perform();
		logger.info("Manager wants to see customers data");
		
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait2.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@placeholder='Search Customer']")));
		WebElement search =driver.findElement(By.xpath("//input[@placeholder='Search Customer']"));
		search.click();
		search.sendKeys("Nayab");
		logger.info("Manager searches for a customer");
		
		WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait4.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[@ng-click='deleteCust(cust)']")));
		WebElement delete = driver.findElement(By.xpath("//button[@ng-click='deleteCust(cust)']"));
		action.moveToElement(delete).click().perform();
		logger.info("Manager deletes customer");
	}
	

@AfterMethod
	  public void Aftermethod(ITestResult result) throws IOException {
			if(ITestResult.FAILURE==result.getStatus())
			{
				   File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				      
				      FileUtils.copyFile(screenshot, new File("C:\\screenshots\\failure.jpg"));
				     
			}
			
}

}
