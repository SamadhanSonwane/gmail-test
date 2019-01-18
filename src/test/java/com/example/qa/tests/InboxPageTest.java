package com.example.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.qa.base.TestBase;
import com.example.qa.pages.HomePage;
import com.example.qa.pages.InboxPage;
import com.example.qa.pages.SigninEmailPage;
import com.example.qa.pages.SigninPasswordPage;
import com.example.qa.util.TestUtil;

public class InboxPageTest extends TestBase{

	HomePage homePage;
	SigninEmailPage signinEmailPage;
	SigninPasswordPage signinPasswordPage;
	InboxPage inboxPage;
	
	String sheetName = "accounts";
	
	public InboxPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		homePage = new HomePage();
		signinEmailPage = homePage.clickSignIn();
	}
	
	@DataProvider(name="testData")
	public Object[][] getAccountsTestData(){
		Object[][] testData = TestUtil.getTestData(sheetName);
		return testData;
	}

	@Test(priority=1, dataProvider="testData")
	public void findEmailTest(String email, String password, String searchTerm){
		
		signinEmailPage.writeEmail(email);
		signinPasswordPage = signinEmailPage.clickNext();
		signinPasswordPage.writePassword(password);
		
		inboxPage = signinPasswordPage.clickNext();
		boolean emailFound = inboxPage.findEmail(searchTerm);
		Assert.assertTrue(emailFound);
	}

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
