package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@id=\"input-email\"]")
	WebElement txtemail;
	
	@FindBy(xpath="//input[@id=\"input-password\"]")
	WebElement txtpassword;
	
	@FindBy(xpath="//input[@class=\"btn btn-primary\"]")
	WebElement lognbtn;
	
	
	public void setEmail(String email) {
		waitForVisibility(txtemail);
		txtemail.sendKeys(email);
	}
	
	public void setPassword(String password) {
		waitForVisibility(txtpassword);
		txtpassword.sendKeys(password);
	}
	
	public void clickLognbtn() {
		lognbtn.click();
	}
	

}
