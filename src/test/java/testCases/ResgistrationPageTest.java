package testCases;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.*;

import pageObjects.HomePage;
import pageObjects.RegisterPage;


public class ResgistrationPageTest extends BaseClass{
	
	@Test
	public void Verify_RegistrationPage() {
		HomePage hp = new HomePage(driver);
		RegisterPage rp = new RegisterPage(driver);
		
		//Navigating to registration page
		hp.clickMyAccount();
		hp.clickRegister();
		
		
		//Entering details in registration page form
		rp.setFirstName("Ajay");
		rp.setLastName("Kumar");
		rp.setEmail("ajaykumar@gmail.com");
		rp.setTelephone("1234567890");
		rp.setcPassword("password");
		rp.setcPassword("password");
		
		
	}

}
