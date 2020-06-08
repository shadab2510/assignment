package com.gradeup;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class CapabilityTest {
	@Test
	public AndroidDriver<AndroidElement> Capability() throws MalformedURLException
	
	{  
		
	
		File f= new File("src/main/resources");
		File fs= new File(f, "co.gradeup.android.apk");
		DesiredCapabilities dc = new DesiredCapabilities();
	
	dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
	dc.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
	AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL ("http://127.0.01:4723/wd/hub"),dc);	
	
	return driver;
	}
	
	
	
	

}
