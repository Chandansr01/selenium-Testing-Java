package MyPageObjects;



import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;



public class createTest{
	WebDriver ldriver;
	public createTest(WebDriver rdriver){
		ldriver = rdriver;
		
		PageFactory.initElements(rdriver,this);
	}
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
	
	@FindBy(id = "navbarComp")
	WebElement navcomp;
	
	@FindBy(id = "5")
	WebElement fashioncat;
	
	@FindBy(id = "createbutton")
	WebElement createbutton;
	
	@FindBy(id = "fileInput")
	WebElement fileInput;
	
	@FindBy(name = "title")
	WebElement Title;
	@FindBy(id = "desc")
	WebElement desc;
	
	@FindBy(id = "publish")
	WebElement publish;
	
	@FindBy(id = "logoutbutton")
	WebElement logoutbutton;
	
	public void confirmOnHomePage(){
		try{
			Thread.sleep(2000);
		}catch (InterruptedException e) {
	        e.printStackTrace();
	        System.out.println("we encountered an unexpected error!!");
	    }
		System.out.println("We are on the Home page.");
	}
	

	public void goToCreatePage(ExtentTest test) {
		try{
			Actions action = new Actions(ldriver);
			Thread.sleep(2000);
			action.moveToElement(fashioncat).click(fashioncat).build().perform();
			Thread.sleep(2000);
			action.moveToElement(createbutton).click(createbutton).build().perform();
			Thread.sleep(2000);
			
			test.info(" 200 Create page is loaded");
			
			fileInput.sendKeys("C:\\Users\\Chandan\\Pictures\\wallpapers\\1149777.jpg");
			System.out.println("we uploaded file");
			Thread.sleep(10000);
			Title.sendKeys("Selenium testing");
			System.out.println("we uploaded file");
			test.info(" 200 Image uploaded");
			
			desc.sendKeys("This is some random text being written by selenium and the image is also being uploaded. Thank You!");
			System.out.println("we uploaded file");
			test.addScreenCaptureFromPath(capture(ldriver));
			action.moveToElement(publish).click(publish).build().perform();
			Thread.sleep(2000);
			test.pass(" 200 We have published the blog");
			
		}catch (InterruptedException e) {
	        e.printStackTrace();
	        System.out.println("we encountered an unexpected error!!");
	    }
	}
//	
//	
	public void deleteBlog(ExtentTest test) {
		try{
			Actions action = new Actions(ldriver);
			action.sendKeys(Keys.PAGE_DOWN).build().perform();
			Thread.sleep(4000);
			action.moveToElement(fashioncat).click(fashioncat).build().perform();
			test.addScreenCaptureFromPath(capture(ldriver));
			test.pass(" 200 BLog was created in correct category");
			Thread.sleep(4000);
		}catch (InterruptedException e) {
	        e.printStackTrace();
	        System.out.println("we encountered an unexpected error!!");
	    }
		
	}
	
	public void logout(ExtentTest test) {
		try{
			Actions action = new Actions(ldriver);
			action.moveToElement(logoutbutton).click(logoutbutton).build().perform();
			test.info("Clicked the logout button.");
			test.addScreenCaptureFromPath(capture(ldriver));
			Thread.sleep(1000);
			String URL = ldriver.getCurrentUrl();
			test.fail("404 The url does not exist");
			Assert.assertEquals(URL, "http://localhost:8080/logout" );
		}catch (InterruptedException e) {
	        e.printStackTrace();
	        System.out.println("we encountered an unexpected error!!");
	    }
		
	}
}
