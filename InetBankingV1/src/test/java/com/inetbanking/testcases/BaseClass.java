package com.inetbanking.testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readConfig=new ReadConfig();
	
	public String baseURL=readConfig.getApplicationURL();
	public String username=readConfig.getUsername();
	public String password=readConfig.getPassword();
	public static WebDriver driver;
	public Logger log;
	
	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) {

		if (br.equalsIgnoreCase("chrome")) {

//			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + readConfig.getChromepath());
//            driver = new ChromeDriver();
            ChromeOptions opt=new ChromeOptions();
            opt.addExtensions(new File("./Extensions/AdBlock — best ad blocker 5.21.0.0.crx"));
          //  opt.addArguments("--incognito");
            driver = new ChromeDriver(opt);
		} else if (br.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + readConfig.getfireFoxpath());
			driver = new FirefoxDriver();
		} else if (br.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + readConfig.getmsedgepath());
			driver = new EdgeDriver();
		}
		driver.get(baseURL);
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

	}
	
	public static void takeSS(String filename) 
	{
		String path = ".\\Screenshots\\";
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File des = new File(path + filename+System.currentTimeMillis()+".png");
		try 
		{
			FileHandler.copy(src, des);
		} 
		catch (IOException e) 
		{
			System.out.println("File not found");
			e.printStackTrace();
		}
	}
//	@AfterClass
//	public void tearDown() {
//		
//		driver.quit();
//	}

}
