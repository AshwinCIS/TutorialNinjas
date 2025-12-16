package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage{

	public RegisterPage(WebDriver driver) {
		super(driver);
	}
	
	//locators
	
	@FindBy(xpath="//input[@name=\"firstname\"]")
	WebElement firstname;
	
	@FindBy(xpath="//input[@name=\"lastname\"]")
	WebElement lastname;
	
	@FindBy(xpath="//input[@name=\"email\"]")
	WebElement email;
	
	@FindBy(xpath="//input[@name=\"telephone\"]")
	WebElement telephone;
	
	@FindBy(xpath="//input[@name=\"password\"]")
	WebElement password;
	
	@FindBy(xpath="//input[@name=\"confirm\"]")
	WebElement confirm;
	
	@FindBy(xpath="//input[@name=\"agree\"]")
	WebElement agreecb;
	
	@FindBy(xpath="//input[contains(@class, 'btn btn-primary')]")
	WebElement continuebtn;
	
	@FindBy(xpath="//h1[contains(text(), 'Your Account Has Been Created!')]")
	WebElement confirmationmsg;
	
	
	//Action methods
	
	public void setFirstName(String fname) {
		waitForVisibility(firstname);
		firstname.sendKeys(fname);
	}
	
	public void setLastName(String lname) {
		lastname.sendKeys(lname);
	}
	
	public void setEmail(String mailid) {
		email.sendKeys(mailid);
	}
	
	public void setTelephone(String phone) {
		telephone.sendKeys(phone);
	}
	
	public void setPassword(String pwd) {
		password.sendKeys(pwd);
	}
	
	public void setcPassword(String pwd) {
		confirm.sendKeys(pwd);
	}
	
	public void clickAgreeCB() {
		if(!agreecb.isSelected()) {
			agreecb.click();
		}
	}
	
	public void clickContinueBtn() {
		continuebtn.click();
	}
	
	public String getConfirmationMsg() {
		waitForVisibility(confirmationmsg);
		return confirmationmsg.getText();
	}
	
	
	

}
