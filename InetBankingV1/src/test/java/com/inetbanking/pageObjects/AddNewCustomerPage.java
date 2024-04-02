package com.inetbanking.pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomerPage {
	
	WebDriver ldriver;

	public AddNewCustomerPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	  @FindBy(xpath="//input[@name='name']")
	  private WebElement customerName;
	  
	  @FindBy(xpath="//input[@name='password']")
	  private WebElement password;
	   
	  @FindBy(xpath="//input[@name='emailid']")
	  private WebElement emailid;
	
	  @FindBy(xpath="//div[@id='card']//div[@id='dismiss-button']")
      private WebElement dismissButton;
	
      @FindBy(xpath="//a[text()='New Customer']")
      private WebElement newCustomerlink;
      
      @FindBy(xpath="//textarea[@name='addr']")
	  private WebElement address;
      
      @FindBy(xpath="//input[@name='city']")
	  private WebElement city;
      
      @FindBy(xpath="//input[@name='state']")
	  private WebElement state;
      
      @FindBy(xpath="//input[@name='pinno']")
	  private WebElement pinno;
      
      @FindBy(xpath=" //input[@name='telephoneno']")
   	  private WebElement telephoneno;
    
      
      @FindBy(xpath="//input[@name='sub']")
   	  private WebElement submitBtn;
      
      @FindBy(xpath="//input[@id='dob']")
   	  private WebElement dob;
    
      public void clickOnNewCustomerLink() {
    	  newCustomerlink.click();
      }
      
      public void clickOnNewSubmitButton() {
    	  submitBtn.click();
      }
      
      public void clickOnDismissButton() {
    	  dismissButton.click();
      }
      
      public void sendCustomerName(String custName) {
    	  newCustomerlink.sendKeys(custName);
      }
      
      public void sendAddress(String Address) {
    	  address.sendKeys(Address);
      }
      
      public void sendCity(String City) {
    	  city.sendKeys(City);
      }
      
      public void sendState(String State) {
    	  state.sendKeys(State);
      }
      
      public void sendPinno(String pinnos) {
    	  pinno.sendKeys(pinnos);
      }
      
      public void sendTelephoneno(String Telephoneno) {
    	  telephoneno.sendKeys(Telephoneno);
      }
      
      public void sendemailid(String Emailid) {
    	  emailid.sendKeys(Emailid);
      }
      
      public void sendpassword(String  Password) {
    	  password.sendKeys(Password);
      }
      
      public void senddob(String dd,String mm,String yyyy ) {
    	  dob.sendKeys(dd);
    	  dob.sendKeys(mm);
    	  dob.sendKeys(yyyy);
      }
     
      public void escapeKey(WebDriver ldriver) {
    	  Actions act=new Actions(ldriver);
    	  act.sendKeys(Keys.ESCAPE).perform();
      }

}
