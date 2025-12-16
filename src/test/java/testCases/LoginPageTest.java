package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class LoginPageTest  extends BaseClass{
	
	@BeforeTest(groups = "sanity")
	public void setValues() {
		filename = "LoginData";
	}
	
	@Test(dataProvider = "sendData", groups = "sanity")
	public void Verify_LoginPage(String username, String password){
		
		HomePage hp = new HomePage(driver);
		LoginPage lp = new LoginPage(driver);
	//	MyAccountPage ap = new MyAccountPage(driver);
		
		logger.info("Started Verify_LoginPage test case");
		
		try {	
		hp.clickMyAccount();
		hp.clickLogin();
		
		// retrieving the user name and password from the config.properties file
//		lp.setEmail(p.getProperty("email"));   
//		lp.setPassword(p.getProperty("password"));
		
		// Retrieving the data from excel
		lp.setEmail(username);
		lp.setPassword(password);
		
		lp.clickLognbtn();
		
		//ap.isMyAccountDisplayed();
		Assert.assertTrue(true);
		
//		lp.clickLogoutbtn();
		
		}
		catch(Exception e){
			Assert.fail();
		}
	}
}
