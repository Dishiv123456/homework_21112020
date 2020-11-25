package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.testbase.TestBase;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class RegistrationTest extends TestBase {


    @Test
    public void verifyThatUserIsOnRegistrationPage() throws InterruptedException {
        clickOnElement(By.xpath("//a[@class='ico-register']"));
        Thread.sleep(5000);
        clickOnElement(By.xpath("//label[contains(text(),'Male')]"));
        Thread.sleep(5000);
        sendTextToElement(By.id("FirstName"), "ram");
        Thread.sleep(5000);
        sendTextToElement(By.id("LastName"), "krishna");
        sendTextToElement(By.xpath("//form[1]//select[1]"), "10");
        sendTextToElement(By.xpath("//form[1]//select[2]"), "01");
        sendTextToElement(By.xpath("//form[1]//select[3]"), "2020");
//        Random randomGenerator = new Random(); //random object
//        int randomInt = randomGenerator.nextInt(1000);
       int number= getRandomNumeric();
        sendTextToElement(By.id("Email"), "ramkrishna" + number+ "@yahoo.com");
        sendTextToElement(By.xpath("//input[@id='Company']"), "PrimeTesting");
        clickOnElement(By.xpath("//label[contains(text(),'Newsletter:')]"));
        sendTextToElement(By.id("Password"), "123456");
        sendTextToElement(By.id("ConfirmPassword"), "123456");
        clickOnElement(By.id("register-button"));
        String expected = "Your registration completed";
        String actualResult= getTextFromElement(By.xpath("//div[contains(text(),'Your registration completed')]"));
        Assert.assertEquals(expected, actualResult);
    }

}
