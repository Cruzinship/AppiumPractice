package com.cydeo.tests;

import com.cydeo.utils.ConfigurationReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;

public class EtsyChromeTest extends WebTestBase {
    @BeforeEach
    public void startOfEach() {
        driver.get("https://www.etsy.com");
    }

    @Test
    public void etsySearchTest() throws InterruptedException {

        WebElement searchField = driver.findElement(By.name("search_query"));
        searchField.sendKeys("wooden spoon" + Keys.ENTER);
        //print number of results
        WebElement results = driver.findElement(By.xpath("//span[contains(text(),'results,')]"));
        System.out.println("results.getText() = " + results.getText());
    }

    @Test
    public void loginTest() throws Exception{
        String email = ConfigurationReader.getProperty("email");
        String password = ConfigurationReader.getProperty("password");

        WebElement signIn = driver.findElement(By.xpath("//span[contains(text(),'Sign in')]/..")); //When doing contains for a text you need to use ,
        signIn.click();

        WebElement userNameField = driver.findElement(By.id("join_neu_email_field"));
        userNameField.sendKeys(email + Keys.ENTER);

   Thread.sleep(3000);

        WebElement PasswordWordField = driver.findElement(By.id("join_neu_password_field"));
        PasswordWordField.sendKeys(password + Keys.ENTER);
/*
        WebElement loginButton = driver.findElement(By.name("submit"));
        loginButton.click();

 */
    }
}
