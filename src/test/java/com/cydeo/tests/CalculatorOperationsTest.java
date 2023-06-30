package com.cydeo.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorOperationsTest {
    AppiumDriver<MobileElement> driver;

    @BeforeEach
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 3");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        caps.setCapability(MobileCapabilityType.APP, "https://cybertek-appium.s3.amazonaws.com/calculator.apk");

        URL url = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver<MobileElement>(url, caps);
    }

    /**
     * 4 + 5 = 9
     */

    @Test
    public void addTest() {
        //locate 4 ,plus, 5, equals, and result
        MobileElement four = driver.findElement(By.id("com.google.android.calculator:id/digit_4"));
        four.click();

        MobileElement plus = driver.findElement(MobileBy.AccessibilityId("plus"));
        plus.click();

        MobileElement five = driver.findElement(By.id("com.google.android.calculator:id/digit_5"));
        five.click();

        MobileElement equals = driver.findElement(MobileBy.AccessibilityId("equals"));
        equals.click();

        MobileElement result = driver.findElement(MobileBy.id("com.google.android.calculator:id/result_final"));

        String actualResult = result.getText();
        System.out.println("actualResult = " + actualResult);
        int expectedResult = 9;

        Assertions.assertEquals(expectedResult, Integer.parseInt(actualResult));
    }

    /**
     * 15 / 5 = 3
     */

    @Test
    public void divideTest(){
        MobileElement one = driver.findElement(MobileBy.id("com.google.android.calculator:id/digit_1"));
        one.click();

        MobileElement five = driver.findElement(By.id("com.google.android.calculator:id/digit_5"));
        five.click();

        MobileElement divisionSign = driver.findElement(MobileBy.AccessibilityId("divide"));

        divisionSign.click();

        five.click();

        MobileElement equals = driver.findElement(MobileBy.AccessibilityId("equals"));
        equals.click();

        MobileElement result = driver.findElement(MobileBy.id("com.google.android.calculator:id/result_final"));

        String actualResult = result.getText();
        System.out.println("actualResult = " + actualResult);

        int expectedResult = 3;

        Assertions.assertEquals(expectedResult, Integer.parseInt(actualResult));



    }

    @AfterEach
    public void cleanUp() {
       driver.closeApp();
    }
}
