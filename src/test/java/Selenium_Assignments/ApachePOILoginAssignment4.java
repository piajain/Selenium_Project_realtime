package Selenium_Assignments;

	import java.io.File;
	import java.io.FileInputStream;
	import java.time.Duration;

	import org.apache.poi.ss.usermodel.*;
	import org.openqa.selenium.*;
	import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
 
	public class ApachePOILoginAssignment4 {

	    WebDriver driver;
  
	    @BeforeTest
	    public void setup() {
	        System.setProperty("webdriver.chrome.driver", "/Users/apple/Downloads/chromedriver-mac-x64/chromedriver");
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    }
 // Test ANnotation has been added
	    @Test
	    public void loginUsingExcel() throws Exception {
	        // Load Excel file
	        FileInputStream fis = new FileInputStream(new File("/Users/apple/Desktop/POI_Excel.xlsx"));
	       
	        Workbook workbook = WorkbookFactory.create(fis);
	        Sheet sheet = workbook.getSheetAt(0);

	        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
	            // Open the login page each time
	            driver.get("http://demo.guru99.com/V4/");

	            Row row = sheet.getRow(i);
	            String username = row.getCell(0).getStringCellValue();
	            String password = row.getCell(1).getStringCellValue();

	            // Enter username and password
	            driver.findElement(By.name("uid")).clear();
	            driver.findElement(By.name("uid")).sendKeys(username);

	            driver.findElement(By.name("password")).clear();
	            driver.findElement(By.name("password")).sendKeys(password);

	            // Click Login
	            driver.findElement(By.name("btnLogin")).click();

	            // Handle the alert if it appears
	            try {
	            	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
	            	 wait.until(ExpectedConditions.alertIsPresent()); // Wait for alert

	                Alert alert = driver.switchTo().alert();
	                System.out.println("Alert message: " + alert.getText());
	                alert.accept(); // click OK
	            } catch (NoAlertPresentException e) {
	                System.out.println("No alert present after login");
	            }

	            // Wait for a short time before next iteration (optional)
	            Thread.sleep(2000);
	        }

	        workbook.close();
	        fis.close();
	    }

	    @AfterTest
	    public void tearDown() {
	        driver.quit();
	    }
	}

 

