package com.tecprotec.BusinessFlow;



import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.tecprotec.Locators.HomePageLocators;
import com.tecprotec.Locators.ProductLocators;
import com.tecprotec.Reporting.Extent_Reporting;
import com.tecprotec.Utilities.Excel_Handling;
import com.tecprotec.Utilities.WrapperMethods;

public class ProductBusinessFlow 
{
	WebDriver driver;
	WrapperMethods method = new WrapperMethods();

	
	public  ProductBusinessFlow(WebDriver driver, String TC_ID) throws Throwable 
	{
		System.out.println("ProductBusinessFlow() constructor");
		Login_BusinessFlows obj1 = new Login_BusinessFlows();	
		obj1.login(driver, TC_ID);
	
	}
	public void selectProduct(WebDriver driver, String TC_ID) throws Throwable 
	{
		
		try {
			
			method.Clickbtn(driver, HomePageLocators.btnProduct, "Product");	
			Extent_Reporting.Log_Pass_with_Screenshot("Products", "view Products", driver);
			String Excelproduct = Excel_Handling.Get_Data(TC_ID, "Product");
			System.out.println("Product name:: " +Excelproduct);
			
			List<WebElement> productList = method.findElementsInList(driver, ProductLocators.productList, "product list value");
			
			
			for(WebElement list : productList) 
			{
				String attValue=list.getAttribute("class");
				
				 System.out.println("Attribute value is ::" +attValue);
				 if (attValue.contains(Excelproduct)) 
					 
				 {
					System.out.println("Selecting propremium product");
					method.Clickbtn(driver, ProductLocators.selProductPropremium, "propremium");
					Extent_Reporting.Log_with_Screenshot("product selected", driver);
					System.out.println(" propremium Selected successfully");
				 }
				 
				 
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		}
	
}
