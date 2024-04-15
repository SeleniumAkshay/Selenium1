package com.shoppersStack_testScripts;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.shoppersStack.genericUtility.BaseTest;
import com.shoppersStack.genericUtility.ListenersUtility;
import com.shoppersStack.pom.AddressFormPage;
import com.shoppersStack.pom.MyAddressPage;
import com.shoppersStack.pom.MyProfilePage;
@Listeners(ListenersUtility.class)
public class Verify_User_is_able_to_add_address_Test extends BaseTest{

	@Test
	public void addAddress() throws IOException {
		
		homePage.getAccountBtn().click();
		homePage.getMyProfileBtn().click();
//		test.log(Status.INFO, "In my profile page");
		
		MyProfilePage myProfilePage=new MyProfilePage(driver);
		myProfilePage.getMyAddressBtn().click();
//		test.log(Status.INFO, "In my address page");
		
		MyAddressPage myAddressPage=new MyAddressPage(driver);
		myAddressPage.getAddAddressBtn().click();
//		test.log(Status.INFO, "In my address form page");
		
		AddressFormPage addressFormPage=new AddressFormPage(driver);
		addressFormPage.getNameTf().sendKeys(file.readExcelData("Sheet2", 1, 0));
		addressFormPage.getHouseTf().sendKeys(file.readExcelData("Sheet2", 1, 1));
		addressFormPage.getStreetTf().sendKeys(file.readExcelData("Sheet2", 1, 2));
		addressFormPage.getLandmarkTf().sendKeys(file.readExcelData("Sheet2", 1, 3));
		
		webdriverUtil.selectByValue(addressFormPage.getCountryDD(), file.readPropertyData("country"));
		webdriverUtil.selectByValue(addressFormPage.getStateDD(), file.readPropertyData("state"));
		webdriverUtil.selectByValue(addressFormPage.getCityDD(), file.readPropertyData("city"));
		
		addressFormPage.getPincodeTf().sendKeys(file.readExcelData("Sheet2", 1, 4));
		addressFormPage.getPhoneNumberTf().sendKeys(file.readExcelData("Sheet2", 1, 5));
		addressFormPage.getAddAddressBtn().click();
//		test.log(Status.INFO, "Address added");
		
		
		
	}

}
