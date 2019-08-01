package com.tecprotec.Tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.tecprotec.BusinessFlow.Login_BusinessFlows;
import com.tecprotec.Reporting.Report_Setup;
import com.tecprotec.Utilities.Common_Functions;
import com.tecprotec.Utilities.Driver_Setup;



public class LoginTest {
public WebDriver driver;
	
	@Parameters({ "browserType", "appURL", "tcID" })
	@Test
	public void loginTests(String browserType, String appURL, String TC_ID) throws Throwable{
		try
		{	
			Common_Functions objCommonFunctions = new Common_Functions();	
			Driver_Setup objDriver_Setup = new Driver_Setup();
			Login_BusinessFlows objLoginFlow=new Login_BusinessFlows();
			
			Report_Setup.InitializeReport(TC_ID);
			driver = objDriver_Setup.initializeTestBaseSetup(browserType, appURL, TC_ID);
			objCommonFunctions.startRecording();
			
			//calling login method
		
			if (TC_ID.contains("verify Login with Valid LoginID & Password")) 
			{
				objLoginFlow.LoginWithValidData(driver, TC_ID);
			}
			
			/*else if (TC_ID.contains("Login with Invalid UserName & Password")) {
				objLoginFlow.LoginWithInValidData(driver, TC_ID);
			}
			
			
			else if (TC_ID.contains("Login with Blank Data")) {
				objLoginFlow.LoginWithBlank(driver, TC_ID);
				
			}*/
			else if (TC_ID.contains("Login with Blank Data")) 
			{
				System.out.println("Black data test case");
				objLoginFlow.LoginWithBlackData(driver, TC_ID);
			}
			
			else if (TC_ID.contains("verify Login with Mobile Number")) 
			{
				System.out.println("Login with mobile number");
				objLoginFlow.LoginWithBlackData(driver, TC_ID);
			}
			
			
			else {
				System.out.println("No test case found or Error in Datasheet");

			}

			Report_Setup.extent.endTest(Report_Setup.test);
			Report_Setup.extent.flush();
			objCommonFunctions.stopRecording();
			driver.close();
		}
		catch (Exception e) {

			Common_Functions commonFunctions = new Common_Functions();
			commonFunctions.stopRecording();
			Report_Setup.extent.endTest(Report_Setup.test);
			Report_Setup.extent.flush();
			driver.close();
			System.out.println("TC_Login_ Error");
		}
		}
	
	@AfterTest
	void close_driver() {
	driver.quit();

	}
}