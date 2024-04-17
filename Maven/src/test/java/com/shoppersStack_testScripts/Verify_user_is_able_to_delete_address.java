package com.shoppersStack_testScripts;

import org.testng.annotations.Test;

import com.shoppersStack.genericUtility.BaseTest;
import com.shoppersStack.pom.MyAddressPage;
import com.shoppersStack.pom.MyProfilePage;

public class Verify_user_is_able_to_delete_address extends BaseTest{
	
	@Test
	public void deleteAddress() throws InterruptedException {
		
		homePage.getAccountBtn().click();
		homePage.getMyProfileBtn().click();
		
		MyProfilePage profilePage=new MyProfilePage(driver);
		profilePage.getMyAddressBtn().click();
		
		MyAddressPage addressPage=new MyAddressPage(driver);
		addressPage.getDeleteBtn().click();
		Thread.sleep(2000);
		addressPage.getYesBtn().click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		
				
	}
	

}
