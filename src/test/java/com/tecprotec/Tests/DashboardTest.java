package com.tecprotec.Tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.tecprotec.BusinessFlow.ViewDashboardBusinessFlow;
import com.tecprotec.Reporting.Report_Setup;
import com.tecprotec.Utilities.Common_Functions;
import com.tecprotec.Utilities.Driver_Setup;

public class DashboardTest
{public WebDriver driver;

@Parameters({ "browserType", "appURL", "tcID" })
@Test
public void viewDashboard(String browserType, String appURL, String TC_ID) throws Throwable{
	try
	{	
		Common_Functions objCommonFunctions = new Common_Functions();	
		Driver_Setup objDriver_Setup = new Driver_Setup();
		Report_Setup.InitializeReport(TC_ID);
		driver = objDriver_Setup.initializeTestBaseSetup(browserType, appURL, TC_ID);
		objCommonFunctions.startRecording();
		
		ViewDashboardBusinessFlow objDashboardFlow=new ViewDashboardBusinessFlow(driver,TC_ID);
		objDashboardFlow.viewDashboard(driver, TC_ID);
		
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
		System.out.println("TC Error");
	}
	}

@AfterTest
void close_driver() {
driver.quit();

}

}
