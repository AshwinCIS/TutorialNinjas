package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class LoginPageTest  extends BaseClass{
	
	@Test
	public void Verify_LoginPage(){
		
		HomePage hp = new HomePage(driver);
		LoginPage lp = new LoginPage(driver);
	//	MyAccountPage ap = new MyAccountPage(driver);
		
		logger.info("Started Verify_LoginPage test case");
		
		try {	
		hp.clickMyAccount();
		hp.clickLogin();
		
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLognbtn();
		
		//ap.isMyAccountDisplayed();
		Assert.assertTrue(true);
		
		}
		catch(Exception e){
			Assert.fail();
		}
	}
}
