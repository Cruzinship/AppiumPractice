package com.cydeo.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class CalculatorTests {

    @Test
    public void calculatorAddTest() throws MalformedURLException, Exception {
//DesiredCapabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        //caps.setCapability("deviceName", "Pixel 3"); another way of writing
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 3");
caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
caps.setCapability(MobileCapabilityType.APP,"https://cybertek-appium.s3.amazonaws.com/calculator.apk");


//set URL for the appium server
        URL url = new URL("http://localhost:4723/wd/hub"); //launch
        //launch appiumDriver
        AppiumDriver<MobileElement> driver = new AndroidDriver<MobileElement>(url, caps);

       // System.out.println("driver.getTitle() = " + driver.getTitle());
        System.out.println("driver.getDeviceTime() = " + driver.getDeviceTime());
        Assertions.assertEquals("android", driver.getPlatformName());
        Thread.sleep(4000);
//located AC element on calculator using AccessibilityId("clear")
        MobileElement clearElem = driver.findElement(MobileBy.AccessibilityId("clear"));

        System.out.println("clearElem = " + clearElem);
        Assertions.assertTrue(clearElem.isDisplayed());
        //close the app


    }

}
