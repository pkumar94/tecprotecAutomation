package com.tecprotec.BusinessFlow;

import org.openqa.selenium.WebDriver;

import com.tecprotec.Locators.EditUserLocators;
import com.tecprotec.Utilities.Excel_Handling;
import com.tecprotec.Utilities.WrapperMethods;

public class EditUserBusinessFlow 

{	
	WebDriver driver;
	WrapperMethods method = new WrapperMethods();
	
	public  EditUserBusinessFlow(WebDriver driver, String TC_ID) throws Throwable 
	{
		System.out.println("EditUserBusinessFlow() constructor");
		Login_BusinessFlows obj1 = new Login_BusinessFlows();	
		obj1.LoginWithValidData(driver, TC_ID);
	
	}
	
	public void EditProfile(WebDriver driver, String TC_ID) throws Throwable 
	{
		//edit profile
		method.Clickbtn(driver, EditUserLocators.btnEdit, "EditButton");
				
		//name
		String excelName = Excel_Handling.Get_Data(TC_ID, "EditName");
		String excelEditContact = Excel_Handling.Get_Data(TC_ID, "EditContact");
		String excelEditEmail = Excel_Handling.Get_Data(TC_ID, "EditEmail");
		String excelEditAdd = Excel_Handling.Get_Data(TC_ID, "EditAdd");

		System.out.println("Entering name");
		method.Clickbtn(driver, EditUserLocators.inpName, "Name");
		method.inputText(driver, EditUserLocators.inpName,excelName , "EditName");
		
		method.Clickbtn(driver, EditUserLocators.inpNumber, "EditContact");
		method.inputText(driver, EditUserLocators.inpNumber,excelEditContact , "EditContact");
		
		method.Clickbtn(driver, EditUserLocators.inpEmail, "email");
		method.inputText(driver, EditUserLocators.inpEmail,excelEditEmail , "EditEmail");
		
		method.Clickbtn(driver, EditUserLocators.inpAdd, "edit add.");
		method.inputText(driver, EditUserLocators.inpAdd,excelEditAdd , "EditAdd");

		method.Clickbtn(driver, EditUserLocators.btnSubmit, "submit button");
		
		
		
	}
	
	}

