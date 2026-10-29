package Com.Driver;

import java.net.URL;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class DriverFactory {

//	public static AndroidDriver createDriver(String deviceName,String udid,
//			String appiumUrl, int systemPort,String appPackage,
//			String appActivity) throws Exception {
//
//	    UiAutomator2Options options = new UiAutomator2Options();
//
//	    options.setPlatformName("Android");
//	    options.setDeviceName(deviceName);
//	    options.setUdid(udid);
//	    options.setAutomationName("UiAutomator2");
//        options.setCapability("appium:adbExecTimeout",60000);
//	    options.setSystemPort(systemPort);
//	    options.setAppPackage(appPackage);
//	    options.setAppActivity(appActivity);
//	    
//
//	    return new AndroidDriver(
//	        new URL(appiumUrl),
//	        options
//	    );
//	}
	
	
	
	 
	
	 
	private static AndroidDriver driver;
	public static AndroidDriver createDriver(String deviceName, String udid,
	String appiumUrl, int systemPort,
	String appPackage, String appActivity) throws Exception {
	UiAutomator2Options options = new UiAutomator2Options();
	options.setPlatformName("Android");
	options.setDeviceName(deviceName);
	options.setUdid(udid);
	options.setAutomationName("UiAutomator2");
	options.setCapability("appium:adbExecTimeout", 60000);
	options.setSystemPort(systemPort);
	options.setAppPackage(appPackage);
	options.setAppActivity(appActivity);
	driver = new AndroidDriver(new URL(appiumUrl), options);
	return driver;
	}
	 
	public static AndroidDriver getDriver() {
	return driver;
	}
	}


	

