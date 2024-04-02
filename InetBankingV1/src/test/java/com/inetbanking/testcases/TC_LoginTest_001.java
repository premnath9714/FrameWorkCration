package com.inetbanking.testcases;


import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.logging.log4j.*;
import com.inetbanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass{
	Logger log;	
	@Test
	public void loginTest() throws InterruptedException {
	    //log = LogManager.getLogger(TC_LoginTest_001.class.getName());
	    log = LogManager.getLogger("TC_LoginTest_001");
		
		log.debug("Entered Url");
	    LoginPage lp=new LoginPage(driver);
	    lp.sendUserid(username);
	    log.debug("Entered username");
		lp.sendPassword(password);
		log.debug("Entered password");
	    lp.clickOnLoginButton();
	    log.debug("clicked On LoginButton");
		Thread.sleep(2000);
		System.out.println(lp.getActualTitleText());
		if(lp.getActualTitleText().equalsIgnoreCase("Guru99 Bank Manager HomePage")) {
			
			Assert.assertTrue(true);
			log.info("Test Case Passed");
			
		}else {
			
			Assert.assertTrue(false);
			log.error("Test case failed");

		}
	}

}
