package com.shoppersStack.genericUtility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class WebdriverUtility {
	
	Select sel;
	File temp;
	File dest;
	JavaUtility javauti=new JavaUtility();
	
	public void selectByValue(WebElement element,String value) {
		sel=new Select(element);
		sel.selectByValue(value);
	}
	
	public void screenshotWebpage(WebDriver driver) throws IOException {
		TakesScreenshot ts=(TakesScreenshot) driver;
		temp = ts.getScreenshotAs(OutputType.FILE);
		dest=new File(FrameWorkConstants.screenShotPath+javauti.localDateTime()+".png");
		FileHandler.copy(temp, dest);
	}
	
	public void screenshotWebelement(WebElement element) throws IOException {
		temp = element.getScreenshotAs(OutputType.FILE);
		dest=new File(FrameWorkConstants.screenShotPath+javauti.localDateTime()+".png");
		FileHandler.copy(temp, dest);
	}

}
