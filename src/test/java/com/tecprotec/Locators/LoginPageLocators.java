package com.tecprotec.Locators;

public class LoginPageLocators 
{
public static String btnLoginWithID = "//a[contains(text(),'Sign In With Login Id')]";
public static String btnLoginWithMobile="//a[contains(text(),'Sign In With Mobile Number')]";
public static String inpLoginId="//input[@formcontrolname='loginId']";
public static String inpPassword="//input[@formcontrolname='password']";
public static String btnSubmit="(//span[text()='Submit'])[1]";
public static String btnClose="(//span[text()='Close'])[1]";
public static String getTextCaptcha="//label[@class='rc-anchor-center-item rc-anchor-checkbox-label']/span";
public static String checkCaptcha="//span[@role='checkbox']";
public static String btnSignIn="//span[contains(text(),'Sign In')]";

public static String iframexpath ="//iframe[@role='presentation']";

public static String loginIDErr="(//mat-error[@role='alert'])[1]";
public static String passwordErr="//mat-error[@id='mat-error-2']";

public static String inpOTP="//input[@formcontrolname='otp']";

public static String userLink ="//a[@href='/profile']";
public static String getuserNameText="(//h3[contains(text(),'Profile')]//following::div[5]/div/div/div/div)[2]";
public static String btnLogout="//a[@class='btn-logout']";
}
