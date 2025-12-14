package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.HomePage;
import pageObjects.RegisterPage;
import testBase.BaseClass;


public class ResgistrationPageTest extends BaseClass{
	
	@Test
	public void Verify_RegistrationPage() {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		HomePage homepg = new HomePage(driver); 
		RegisterPage regpg = new RegisterPage(driver);
		
		
		logger.info("Started Verify_RegistrationPage test");
		
		//try {
		//Navigating to registration page
		homepg.clickMyAccount();
		homepg.clickRegister();
		
		logger.info("Entering the details in the registartion page");
		//Entering details in registration page form
		regpg.setFirstName(randomstring());
		regpg.setLastName(randomstring());
		regpg.setEmail(randomstring()+"@gmail.com");
		regpg.setTelephone("1234567890");
		regpg.setPassword("password");
		regpg.setcPassword("password");
		regpg.clickAgreeCB();
		regpg.clickContinueBtn();
	
		logger.info("Validating the confirmation message");
		String confmsg = regpg.getConfirmationMsg();
		
		if(confmsg.equals("Your Account Has Been Created!")) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
			logger.error("Test failed");
			logger.debug("Debug logs");
		}
//	}
//		catch(Exception e){
//			Assert.fail();
//		}
		
	}
	
	public String randomstring() {
		String generatedstring = RandomStringUtils.randomAlphabetic(5);
		return generatedstring;
	}

}
