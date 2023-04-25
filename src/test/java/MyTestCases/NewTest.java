package MyTestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class NewTest {
  WebDriver driver;
  @Test
  public void testcase1() {
	  ChromeOptions opt=new ChromeOptions();
	  System.setProperty("webdriver.chrome.driver", "D:\\TestAutomation\\projss\\Drivers\\chromedriver.exe");
		opt.addArguments("--remote-allow-origins=*");
		WebDriver driver=new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.google.com/");
		System.out.println("google.com launched successfully!");
  }
  
  
  
}
