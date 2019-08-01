package com.tecprotec.Locators;

public class Customerlocators {
public static String selCustomer = "//a[contains(text(),'Customer')]";
public static String inpFilter = "//input[@placeholder='Filter']";
public static String addCustomer ="//i[@class='fa fa-plus']";
public static String customerDetailsPage ="//h5[@id='customerModalLabel']";

public static String inpCustomerName="//input[@formcontrolname='name']";
public static String inpCustomermobile="//input[@formcontrolname='mobile']";
public static String inpCustomerEmail="//input[@formcontrolname='email']";
public static String inpimeinumber="//input[@formcontrolname='imei']";
public static String selBrand="//select[@formcontrolname='brand']";
public static String selModel="//select[@formcontrolname='model']";
public static String inpPrice="//input[@formcontrolname='purchasePrice']";
public static String btnSubmit="//span[contains(text(),'Submit')]";

public static String modelLists="//select[@formcontrolname='model']/option";

//filter data
public static String filterData="//tr[@class='mat-row ng-star-inserted']/td";
}
