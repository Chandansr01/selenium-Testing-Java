package MyPageObjects;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
	WebDriver ldriver;
	public LoginPage(WebDriver rdriver){
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	@FindBy(name = "username")
	WebElement txtUserName;
	
	@FindBy(name = "password")
	WebElement txtPassword;
	
	@FindBy(tagName = "button")
	WebElement btnLogin;
	
	public void setUserName(String Uname) {
		txtUserName.sendKeys(Uname);
	}
	
	public void setUserPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	
	public void clickSubmit() {
		try{
			Thread.sleep(1000);
			btnLogin.click();
//			Thread.sleep(5000);
		}catch (InterruptedException e) {
	        e.printStackTrace();
	        System.out.println("we encountered an unexpected error!!");
	    }
		
	}
}
