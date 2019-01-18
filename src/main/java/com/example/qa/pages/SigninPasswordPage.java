package com.example.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.example.qa.base.TestBase;

public class SigninPasswordPage extends TestBase {

	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//span[contains(text(), 'Next')]")
	WebElement next;
	
	public SigninPasswordPage(){
		PageFactory.initElements(driver, this);
	}

	public String validateSigninPageTitle(){
		return driver.getTitle();
	}
	
	public void writePassword(String pwd){
		password.clear();
		password.sendKeys(pwd);
	}
	
	public InboxPage clickNext(){
		next.click();
		return new InboxPage();
	}
}
