package com.example.qa.pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.example.qa.base.TestBase;

public class InboxPage extends TestBase {
	
	@FindAll({@FindBy(xpath="//tr[@class='zA yO']/td[6]")})
	List<WebElement> subjectsBodies;

	public InboxPage(){
		PageFactory.initElements(driver, this);
	}
	
	public boolean findEmail(String searchString){
		Iterator<WebElement> itr = subjectsBodies.iterator();
		
		while(itr.hasNext()){
			WebElement subjectBody = itr.next();
			String subjectBodyString = subjectBody.getText();
			
			if(subjectBodyString.contains(searchString)){
				// System.out.println(subjectBodyString);
				return true;
			}
		}
		return false;
	}
}
