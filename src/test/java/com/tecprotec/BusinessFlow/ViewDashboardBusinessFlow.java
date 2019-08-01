package com.tecprotec.BusinessFlow;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.tecprotec.Locators.HomePageLocators;
import com.tecprotec.Reporting.Extent_Reporting;
import com.tecprotec.Utilities.WrapperMethods;

public class ViewDashboardBusinessFlow {
	
	WebDriver driver;
	WrapperMethods method = new WrapperMethods();
	
	public  ViewDashboardBusinessFlow(WebDriver driver, String TC_ID) throws Throwable 
	{
		System.out.println("ViewDashboardBusinessFlow() constructor");
		Login_BusinessFlows obj1 = new Login_BusinessFlows();	
		obj1.login(driver, TC_ID);
	
	}
	public void viewDashboard(WebDriver driver, String TC_ID) throws Throwable 
	{
		
		try 
		{
			method.clickButton(driver, HomePageLocators.dashbord, "dashboard");
		
			Extent_Reporting.Log_Pass_with_Screenshot("View Dashboard details", "Pass", driver);
			 JavascriptExecutor js = (JavascriptExecutor) driver;
			 js.executeScript("window.scrollBy(0,50000)");
			 Thread.sleep(500);
			Extent_Reporting.Log_Pass_with_Screenshot("View Dashboard details", "Pass", driver);

		}
		
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		
		}
		}
}
