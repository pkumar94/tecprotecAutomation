package com.tecprotec.BusinessFlow;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.tecprotec.Locators.Customerlocators;
import com.tecprotec.Locators.ProductLocators;
import com.tecprotec.Reporting.Extent_Reporting;
import com.tecprotec.Utilities.Excel_Handling;
import com.tecprotec.Utilities.WrapperMethods;

public class CustomerBusinessFlow
{
	WebDriver driver;
	WrapperMethods method = new WrapperMethods();
	
	public CustomerBusinessFlow(WebDriver driver, String TC_ID) throws Throwable 
	{
		System.out.println("CustomerBusinessFlow() constructor");
		Login_BusinessFlows obj1 = new Login_BusinessFlows();	
		obj1.login(driver, TC_ID);
	
	}
	
	public void createCustomer(WebDriver driver, String TC_ID) throws Throwable 
	{
		System.out.println("Creating customer");
		method.Clickbtn(driver, Customerlocators.selCustomer, "Customer tab");
		Thread.sleep(200);
		Extent_Reporting.Log_with_Screenshot("Customer tab selected", driver);
		method.Clickbtn(driver, Customerlocators.addCustomer, "add button");
		Extent_Reporting.Log_with_Screenshot("customer Form", driver);
		//input name
		
	String excelName = Excel_Handling.Get_Data(TC_ID, "Name");
	String excelMobile = Excel_Handling.Get_Data(TC_ID, "Mobile");
	String excelEmail = Excel_Handling.Get_Data(TC_ID, "Email");
	String excelIMEINo = Excel_Handling.Get_Data(TC_ID, "imei number");
	String excelBrand= Excel_Handling.Get_Data(TC_ID, "Brand");
	String excelModel = Excel_Handling.Get_Data(TC_ID, "Model");
	String excelPrice = Excel_Handling.Get_Data(TC_ID, "price");
	
	method.Clickbtn(driver, Customerlocators.inpCustomerName, "customer name");
	method.inputText(driver, Customerlocators.inpCustomerName , excelName, "Name");
	
	method.Clickbtn(driver, Customerlocators.inpCustomermobile, "customer mobile");
	method.inputText(driver, Customerlocators.inpCustomermobile , excelMobile, "Mobile");
	
	method.Clickbtn(driver, Customerlocators.inpCustomerEmail, "customer mobile");
	method.inputText(driver, Customerlocators.inpCustomerEmail , excelEmail, "Mobile");
	
	method.Clickbtn(driver, Customerlocators.inpimeinumber, "customer mobile");
	method.inputText(driver, Customerlocators.inpimeinumber , excelIMEINo, "Mobile");
	
	method.selectDropBoxByVisibleText(driver, Customerlocators.selBrand, excelBrand, "brand");
	Thread.sleep(200);
	
	method.Clickbtn(driver, Customerlocators.selModel, "model");
	
	method.selectDropBoxByVisibleText(driver, Customerlocators.selModel, excelModel, "model");
	
	
	method.Clickbtn(driver, Customerlocators.inpPrice, "Price");
	method.inputText(driver, Customerlocators.inpPrice , excelPrice, "Price");
	
	method.Clickbtn(driver, Customerlocators.btnSubmit, "Submit button");
	System.out.println("Customer created successfully");
	
	}
	
	public void filterCustomer(WebDriver driver, String TC_ID) throws Throwable 
	{
		try
		{
			method.Clickbtn(driver, Customerlocators.selCustomer, "Customer tab");
			Thread.sleep(200);
			Extent_Reporting.Log_with_Screenshot("Customer tab selected", driver);
			Thread.sleep(200);
			method.Clickbtn(driver, Customerlocators.inpFilter, "filter");
			
			method.inputText(driver, Customerlocators.inpFilter, Excel_Handling.Get_Data(TC_ID, "filter"), "filter");
		
			Extent_Reporting.Log_Pass_with_Screenshot("Filtering customer", "Pass", driver);
			
			List<WebElement> customerDetails = method.findElementsInList(driver, Customerlocators.filterData, "customer data");

			for (WebElement data : customerDetails) 
			{
				System.out.println("customer data::");
				System.out.println(data.getText());
			}
			
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	}
	
