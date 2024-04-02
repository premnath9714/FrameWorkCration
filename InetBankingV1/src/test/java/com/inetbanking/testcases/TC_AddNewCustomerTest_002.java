package com.inetbanking.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddNewCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

import net.bytebuddy.utility.RandomString;

public class TC_AddNewCustomerTest_002 extends BaseClass {
	
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
		AddNewCustomerPage addNewCustomerPage=new AddNewCustomerPage(driver);
	//	Thread.sleep(4000);
		addNewCustomerPage.clickOnNewCustomerLink();
		addNewCustomerPage.sendCustomerName("Premnath");
		addNewCustomerPage.sendAddress("Pune");
		addNewCustomerPage.sendCity("Hyd");
		addNewCustomerPage.sendState("MH");
		addNewCustomerPage.sendPinno("413606");
		addNewCustomerPage.sendTelephoneno("8381067443");
		addNewCustomerPage.sendpassword("prem@1234");
		addNewCustomerPage.senddob("01", "04", "1997");
		String emails=randomAlphanumericString(10)+"@gmail.com";
		addNewCustomerPage.sendemailid(emails);
		addNewCustomerPage.clickOnNewSubmitButton();
		
	}
	
     public String randomAlphanumericString(int i) {
		// TODO Auto-generated method stub
		String randomString1 = randomAlphanumericString(10);
		return randomString1;
		}
	
}
