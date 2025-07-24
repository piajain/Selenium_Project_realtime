package Browser_Launch;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstSeleniumProgram { 

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
   
		WebDriverManager.chromedriver().setup();
     WebDriver driver = new ChromeDriver();
     
      //i have added a comment to check the commit function of git
     
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); 
     
     driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
     
     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
     WebElement usernameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']")));
     usernameInput.sendKeys("Admin");
 
     // WebElement Username = driver.findElement(By.xpath("(//input[@class ='oxd-input oxd-input--active'])[1]"));
     
     //(//input[@class='oxd-input oxd-input--active'])[1]
      
    //  Username.sendKeys("Admin");   
      
     
      
      //(//input[@class='oxd-input oxd-input--active'])[1]
       
      
     // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      WebElement Password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Password']")));

    //  WebElement Password = driver.findElement(By.xpath("(//input[@class ='oxd-input oxd-input--active'])[2]"));
       Password.sendKeys("admin123");
       
      WebElement login = driver.findElement(By.xpath("//button[@class = 'oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']"));
      
      login.click();  
      
     
   
    
	}
 
}  
   