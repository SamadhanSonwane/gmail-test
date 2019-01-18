package com.example.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.example.qa.base.TestBase;

public class SigninEmailPage extends TestBase {
	
	@FindBy(xpath="//input[@type='email']")
	WebElement email;
	
	@FindBy(xpath="//span[contains(text(), 'Next')]")
	WebElement next;
	
	public SigninEmailPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String validateSigninPageTitle(){
		return driver.getTitle();
	}
	
	public void writeEmail(String emailId){
		email.clear();
		email.sendKeys(emailId);
	}
	
	public SigninPasswordPage clickNext(){
		next.click();
		return new SigninPasswordPage();
	}

}
