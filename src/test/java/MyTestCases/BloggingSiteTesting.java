package MyTestCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import MyPageObjects.LoginPage;
import MyPageObjects.createTest;

public class BloggingSiteTesting extends BaseClass{
			@Test
			public void TestCase1() {
				Logger logger;
				logger = LogManager.getLogger(BloggingSiteTesting.class);
				ExtentTest test = extent.createTest("simply logging in").assignAuthor("CHandan");
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				driver.get(baseUrl);
				
				logger.info("URL is opened");
				LoginPage lp = new LoginPage(driver);
				test.info("I am Logging in...");
				lp.setUserName(userName);
				logger.info("Username entered successfully");
				lp.setUserPassword(password);
				logger.info("Password entered successfully");
				test.pass("We are succesfully Logged in!");
//				test.addScreenCaptureFromPath(capture(driver));
				lp.clickSubmit();
			}
			@Test
			public void TestCase2() {
				Logger logger;
				logger = LogManager.getLogger(BloggingSiteTesting.class);
				createTest nav = new createTest(driver);
				ExtentTest test = extent.createTest("Confirm On Home Page").assignAuthor("Harsh");
					nav.confirmOnHomePage();
					test.info(" 200   Navbar is accessible");
					test.addScreenCaptureFromPath(capture(driver));
					test.pass(" 200 We are on Home Page");
					logger.info("Second test case completed!");
					
			}
			@Test
			public void TestCase3() {
				Logger logger;
				logger = LogManager.getLogger(BloggingSiteTesting.class);
				createTest nav = new createTest(driver);
				ExtentTest test = extent.createTest("Create Page").assignAuthor("Chandan");
				nav.goToCreatePage(test);
//				test.info(" 200 Create button is clicked");
//				test.addScreenCaptureFromPath(capture(driver));
				logger.info("Third test case completed!");
				
			}
			@Test
			public void TestCase4() {
				Logger logger;
				logger = LogManager.getLogger(BloggingSiteTesting.class);
				createTest nav = new createTest(driver);
				ExtentTest test = extent.createTest("Revisit Fashion Page").assignAuthor("Harsh");
				nav.deleteBlog(test);
				logger.info("Fourth test case completed!");
				
			}
			@Test
			public void TestCase5() {
				Logger logger;
				logger = LogManager.getLogger(BloggingSiteTesting.class);
				createTest nav = new createTest(driver);
				ExtentTest test = extent.createTest("Logout Page").assignAuthor("Harsh");
				nav.logout(test);
				logger.info("All test case completed!");
				
			}
}


