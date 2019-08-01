package com.tecprotec.BusinessFlow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.tecprotec.Locators.HomePageLocators;
import com.tecprotec.Locators.LoginPageLocators;
import com.tecprotec.Reporting.Extent_Reporting;
import com.tecprotec.Utilities.Excel_Handling;
import com.tecprotec.Utilities.WrapperMethods;

import junit.framework.Assert;

public class Login_BusinessFlows {
	WebDriver driver;
	WrapperMethods method = new WrapperMethods();

	public void LoginWithValidData(WebDriver driver, String TC_ID) throws Throwable 
	{
		
		try {
			String userNameExcelVal=Excel_Handling.Get_Data(TC_ID, "UserName");
			String passExcelVal=Excel_Handling.Get_Data(TC_ID, "Password");

			Thread.sleep(500);
			method.Clickbtn(driver, LoginPageLocators.btnLoginWithID, "sign In button");
			
			System.out.println("entering username");
			method.inputText(driver, LoginPageLocators.inpLoginId, userNameExcelVal, "Login ID");
			Extent_Reporting.Log_Pass_with_Screenshot("entering username", "Entered", driver);
			Thread.sleep(700);
			//input password
			System.out.println("entering password");
			method.Clickbtn(driver, LoginPageLocators.inpPassword, "Password");
			method.inputText(driver, LoginPageLocators.inpPassword, passExcelVal, "password");
			Extent_Reporting.Log_Pass_with_Screenshot("entering Password", "Password entered", driver);
			method.Clickbtn(driver, LoginPageLocators.btnSubmit, "click on submit");
			Thread.sleep(1000);
			

			System.out.println("Selecting captcha");
			
			//captcha select manualy by putting wait
	
		
			method.Clickbtn(driver, LoginPageLocators.btnSignIn,"signIn");
			
			
			
			//validation for valid user
			String homePage = method.getInputTextValue(driver, HomePageLocators.dashbord, "dashboard");
			if (homePage.equals("Dashboard")) 
			{
				System.out.println("User is on Home page");
				Extent_Reporting.Log_Pass_with_Screenshot("Login successfully", "Login with :"+userNameExcelVal, driver);
				System.out.println("Login successfully");	
			}
			
			//assertion
		
			method.Clickbtn(driver, LoginPageLocators.userLink, "user");			
			String userNameText = method.getInputTextValue(driver, LoginPageLocators.getuserNameText, "Username");
			System.out.println("username ::"+userNameText);
			
			System.out.println("Assertion check");
			Assert.assertEquals(Excel_Handling.Get_Data(TC_ID, "Username"), userNameText);
			System.out.println("Assertion passed");
			
		}
		
		catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}	
		
	}
	

	public void LoginWithBlackData(WebDriver driver, String TC_ID) throws Throwable 
	{
		
		try {
			String userNameExcelVal=Excel_Handling.Get_Data(TC_ID, "UserName");
			String passExcelVal=Excel_Handling.Get_Data(TC_ID, "Password");

			Thread.sleep(500);
			method.Clickbtn(driver, LoginPageLocators.btnLoginWithID, "sign In button");
			
			System.out.println("entering username");
			method.inputText(driver, LoginPageLocators.inpLoginId, userNameExcelVal, "Login ID");
			Extent_Reporting.Log_Pass_with_Screenshot("entering username", "Entered", driver);
			Thread.sleep(500);
			
			//input password
			System.out.println("entering password");
			method.Clickbtn(driver, LoginPageLocators.inpPassword, "Password");
			method.inputText(driver, LoginPageLocators.inpPassword, passExcelVal, "password");
			Extent_Reporting.Log_Pass_with_Screenshot("entering Password", "Password entered", driver);
			
			Thread.sleep(1000);
		
			//validation for blank
			
			String errLoginID= method.getInputTextValue(driver, LoginPageLocators.loginIDErr, "blank userID");
			System.out.println("userId error::" +errLoginID);
			
			
			/*String errPassword = method.getInputTextValue(driver, LoginPageLocators.passwordErr, "blank password");
			System.out.println("Password error::"+errPassword);*/
			
			if (errLoginID.equals("Please enter login Id")) 
			{
				System.out.println("Validation");
				System.out.println("No data enter in login ID field");
				Extent_Reporting.Log_Pass_with_Screenshot("Black data", "Pass", driver);			
			}
			
		
	 }
		
		catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}	
		
	}
	
	public void LoginWithMobileNumber(WebDriver driver, String TC_ID) throws Throwable 
	{
		
		try {
			String mobileExcelVal=Excel_Handling.Get_Data(TC_ID, "Mobile number");
			

			Thread.sleep(500);
			method.Clickbtn(driver, LoginPageLocators.btnLoginWithMobile, "sign In button");
			
			System.out.println("entering username");
			method.inputText(driver, LoginPageLocators.inpLoginId, mobileExcelVal, "mobile number");
			Extent_Reporting.Log_Pass_with_Screenshot("entering username", "Entered", driver);
			Thread.sleep(500);
			
			//input password
			System.out.println("entering OTP");
			method.Clickbtn(driver, LoginPageLocators.inpOTP, "OTP");
			method.inputText(driver, LoginPageLocators.inpOTP, "123456", "otp");
			Extent_Reporting.Log_Pass_with_Screenshot("entering otp", "OTP entered", driver);
			
			Thread.sleep(1000);
			method.Clickbtn(driver, LoginPageLocators.btnSubmit, "click on submit");
			Thread.sleep(1000);
			
			//captcha select manualy by putting wait

			method.Clickbtn(driver, LoginPageLocators.btnSignIn,"signIn");

			
		
	 }
		
		catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}	
		
	}
	public void login(WebDriver driver, String TC_ID) throws Throwable 
	{
		
		try {
			String userNameExcelVal=Excel_Handling.Get_Data(TC_ID, "UserName");
			String passExcelVal=Excel_Handling.Get_Data(TC_ID, "Password");

			Thread.sleep(500);
			method.Clickbtn(driver, LoginPageLocators.btnLoginWithID, "sign In button");
			
			System.out.println("entering username");
			method.inputText(driver, LoginPageLocators.inpLoginId, userNameExcelVal, "Login ID");
			Extent_Reporting.Log_Pass_with_Screenshot("entering username", "Entered", driver);
			Thread.sleep(700);
			//input password
			System.out.println("entering password");
			method.Clickbtn(driver, LoginPageLocators.inpPassword, "Password");
			method.inputText(driver, LoginPageLocators.inpPassword, passExcelVal, "password");
			Extent_Reporting.Log_Pass_with_Screenshot("entering Password", "Password entered", driver);
			method.Clickbtn(driver, LoginPageLocators.btnSubmit, "click on submit");
			Thread.sleep(1000);

			
			//captcha select manualy by putting wait
	
			method.Clickbtn(driver, LoginPageLocators.btnSignIn,"signIn");
			
			
			
			//validation for valid user
			String homePage = method.getInputTextValue(driver, HomePageLocators.dashbord, "dashboard");
			if (homePage.equals("Dashboard")) 
			{
				System.out.println("User is on Home page");
				Extent_Reporting.Log_Pass_with_Screenshot("Login successfully", "Login with :"+userNameExcelVal, driver);
				System.out.println("Login successfully");	
			}
			
		}
		
		catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}	
		
	}
	
	public void logout(WebDriver driver, String TC_ID) throws Throwable 
	{
		
		try 
		{
			System.out.println("Logout");
			method.Clickbtn(driver, LoginPageLocators.btnLogout, "Logout button");
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		}
	
}
