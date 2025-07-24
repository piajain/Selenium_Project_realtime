package Selenium_Assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Assignment3 {
	
WebDriver driver;
	@BeforeTest
	public void setup() {
		
		System.setProperty("Webdriver.chrome.driver", "/Users/apple/Downloads/chromedriver-mac-x64");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 
		 
	}
	
	
	@Test(dataProvider = "loginData")
	public void loginTest(String username, String password) throws InterruptedException {
		
		 driver.get("https://demo.guru99.com/test/login.html");
		 
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(username);
     
     
     driver.findElement(By.id("passwd")).clear();
     driver.findElement(By.id("passwd")).sendKeys(password);;
     
     
     
     WebElement signin = driver.findElement(By.id("SubmitLogin"));
     
     signin.click();
     
     Thread.sleep(2000);
     
	}
		
	/*public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
   
		WebDriverManager.chromedriver().setup();
     WebDriver driver = new ChromeDriver();
     
      
     
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); 
     
     driver.get("https://demo.guru99.com/test/login.html");
     
	}
	
	public void */
     
     @DataProvider(name = "loginData")
     public Object[][] getLoginData() {
         return new Object[][] {
             {"Priya", "priya@123"},
            
             {"sowmya", "sowmya@123"}
         };
     }
         @AfterTest
         public void teardown() {
             driver.quit();
         }
		
	}
	
