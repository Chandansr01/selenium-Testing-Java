package MyTestCases;


import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BaseClass {
			public static String capture(WebDriver driver) {
				File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				File destinationFilePath = new File("src/../Screenshots/" + System.currentTimeMillis()+".png");
				String absolutePathLocation = destinationFilePath.getAbsolutePath();
				try {
					FileHandler.copy(srcFile, destinationFilePath);
				}catch(IOException e) {
					e.printStackTrace();
				}
				return absolutePathLocation;
			}
			
			public String baseUrl = "http://localhost:3000/login";
			public String userName = "chandan";
			public String password = "chandan";
			
			ExtentReports extent = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter("ExtentTestFile.html");
			public static WebDriver driver;
			
			@BeforeClass
			public void setup()
			{	spark.config().setTheme(Theme.DARK);
				spark.config().setDocumentTitle("My Test Report");
				extent.attachReporter(spark);
				
				System.setProperty("webdriver.chrome.driver", "D:\\TestAutomation\\projss\\Drivers\\chromedriver.exe");
				driver = new ChromeDriver();
			}
			
			@AfterClass
			public void teardown(){
				extent.flush();
				driver.quit();
				
			}
			
}
	