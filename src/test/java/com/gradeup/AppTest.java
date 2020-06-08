package com.gradeup;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class AppTest extends CapabilityTest {
	@Test
	public void EndToEndTest() throws MalformedURLException, InterruptedException {
		AndroidDriver<AndroidElement> driver = Capability();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.findElementByXPath("//android.widget.TextView[@text='SSC & Railway']").click();
		
		driver.findElementsByClassName("android.widget.RadioButton").get(0).click();
		
		

		driver.findElementById("co.gradeup.android:id/topBtn").click();
		
		//Already have an account? LOGIN
		//android.widget.TextView
		driver.findElementByXPath("//android.widget.TextView[@text='Already have an account? LOGIN']").click();
		
		driver.findElementByXPath("//android.widget.EditText[@text='Email']").sendKeys("shoaib.anwar3718@gmail.com");
		driver.findElementByXPath("//android.widget.EditText[@text='Password']").sendKeys("371825");
		driver.findElementByXPath("//android.widget.TextView[@text='LOGIN']").click();
	
		/*
		 * driver.findElementById("co.gradeup.android:id/register_button").click();
		 * 
		 * driver.pressKey(new KeyEvent(AndroidKey.BACK));
		 */
		
		WebDriverWait w = new WebDriverWait(driver, 4);
		  
		  w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='SSC & Railway']")));
		  //driver.findElementById("co.gradeup.android:id/facebook_button").click();
		  
		
			/*
			 * WebDriverWait w = new WebDriverWait(driver, 4);
			 * 
			 * w.until(ExpectedConditions.visibilityOfElementLocated(By.id(
			 * "co.gradeup.android:id/facebook_button")));
			 * driver.findElementById("co.gradeup.android:id/facebook_button").click();
			 */
		  
			/*
			 * WebDriverWait w1 = new WebDriverWait(driver, 4);
			 * w1.until(ExpectedConditions.visibilityOfElementLocated(By.
			 * xpath("//android.widget.TextView[@text='SSC & Railway']")));
			 */

		driver.findElementByXPath("//android.widget.TextView[@text='SSC & Railway']").click();
		driver.findElementById("co.gradeup.android:id/plusIcon").click();

		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"CTET & Teaching Jobs\"));").click();

		// to click on Turn on and go back to HomePage
		driver.findElementByXPath("//android.widget.TextView[@text='TURN ON']").click();
		driver.findElementById("co.gradeup.android:id/backImgView").click();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));

		// to verify the course text
		String ActualCourseText = driver.findElementByXPath("//android.widget.TextView[@text='CTET & Teaching Jobs']").getText();
		String ExpectedCourseText = "CTET & Teaching Jobs";
		Assert.assertEquals(ActualCourseText, ExpectedCourseText);

		// click on Classroom at bottom
		driver.findElementByXPath("//android.widget.TextView[@text='Classroom']").click();
		
		//to click on View Course

		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"VIEW COURSE\").instance(0))").click();
		
		// click on Start Trial
		driver.findElementByXPath("//android.widget.TextView[@text='START FREE TRIAL']").click();

		// to view the price
		String priceText=driver.findElementById("co.gradeup.android:id/batchPrice").getText();
		System.out.println(priceText);
		
		// to get the course Name we selected
		System.out.println(driver.findElementsByClassName("android.widget.TextView").get(0).getText());

	}

	

}
