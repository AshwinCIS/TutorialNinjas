package testBase;


import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import utilities.ReadExcel;

public class BaseClass {

    public WebDriver driver;
    public Logger logger;
    public Properties p;
    public String filename;
    
    @BeforeClass(groups = {"sanity","regression"})
    @Parameters({"browser"})
    public void setup(String brwsr) throws IOException {
    	
    	logger = LogManager.getLogger(this.getClass()); // for log
    	
    	FileReader file = new FileReader("./src//test//resources//config.properties"); // reading the file
    	p = new Properties();
    	p.load(file);
    	
    	if(brwsr.equalsIgnoreCase("chrome")) {		// for choosing the desired browser
    		driver = new ChromeDriver();
    	} 
    	else if(brwsr.equalsIgnoreCase("safari")){
    		driver = new SafariDriver();
    	}
    	else {
    		System.out.println("Invalid browser");
    	}
    	
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(p.getProperty("siteURL"));
    }

    @AfterClass(groups = {"sanity","regression"})
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
    
    @DataProvider
    public String[][] sendData() throws IOException {
    	return ReadExcel.readData(filename);
    }
}
