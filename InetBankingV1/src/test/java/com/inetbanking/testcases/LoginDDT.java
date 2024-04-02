package com.inetbanking.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.ExcelHandling;

public class LoginDDT extends BaseClass {
	Logger log;
	@Test(dataProvider="LoginData")
	public void loginDDT(String user,String pwd) throws InterruptedException {
	   
	    log = LogManager.getLogger("LoginDDT");
		log.debug("Entered Url");
	    LoginPage lp=new LoginPage(driver);
	    lp.sendUserid(user);
	    log.debug("Entered username");
		lp.sendPassword(pwd);
		log.debug("Entered password");
	    lp.clickOnLoginButton();
	    log.debug("clicked On LoginButton");
	    
	    if(isAlertPresent()==true) {
	    	driver.switchTo().alert().accept();
	    	driver.switchTo().defaultContent();
	    	Assert.assertTrue(false);
	    }else {
	    	Assert.assertTrue(true);
	    	lp.clickOnLogoutButton();
	    	Thread.sleep(5000);
	    	driver.switchTo().alert().accept();
	    	driver.switchTo().defaultContent();
	    }
	}
	
	
	@DataProvider(name="LoginData")
	public String [] [] getData(){
		int rowNum=ExcelHandling.getRowNumber("Sheet1");
		int colcount=ExcelHandling.getCellNumber("Sheet1", 1);
		
		String [] [] logindata=new String [rowNum] [colcount];
		
		for(int i=1; i<=rowNum; i++) {
			
			for(int j=0; j<colcount; j++) {
				 logindata [i-1] [j]=ExcelHandling.readData1("Sheet1", i, j);
			}
		}
		return logindata;
	}

	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
