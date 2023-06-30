package com.cydeo.tests;

import com.cydeo.pages.CalculatorPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorPOMTest {

    CalculatorPage calculatorPage = new CalculatorPage();

    /**
     * 5 * 8 = 40
     */
    @Test
    public void multiplyTest() {
        calculatorPage.clickDigit(5);
        calculatorPage.multiply();
        calculatorPage.clickDigit(8);
        calculatorPage.equals.click();
        String actualResult = calculatorPage.result.getText();
        System.out.println(actualResult);

        int expectedResult = 40;
        assertEquals(expectedResult, Integer.parseInt(actualResult));


    }
}
