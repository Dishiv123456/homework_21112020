package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.testbase.TestBase;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class LoginTest extends TestBase {

    @Test
    public void userShouldNavigateToLoginPage() {
        clickOnElement(By.className("ico-login"));
        String expectedMessage = "Welcome, Please Sign In!";
        String actualMessage = getTextFromElement(By.xpath("//h1[text()='Welcome, Please Sign In!']"));
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void userShouldBeAbleToLogInWithValidCredential() throws InterruptedException {
        clickOnElement(By.xpath("//a[@class='ico-register']"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//label[contains(text(),'Male')]"));
        Thread.sleep(2000);
        sendTextToElement(By.id("FirstName"), "ram");
        Thread.sleep(2000);
        sendTextToElement(By.id("LastName"), "krishna");
        sendTextToElement(By.xpath("//form[1]//select[1]"), "10");
        sendTextToElement(By.xpath("//form[1]//select[2]"), "01");
        sendTextToElement(By.xpath("//form[1]//select[3]"), "2020");
        Random randomGenerator = new Random(); //random object
        int randomInt = randomGenerator.nextInt(1000);
        String email = "ramkrishna" + randomInt + "@yahoo.com";
        sendTextToElement(By.id("Email"), email);
        sendTextToElement(By.xpath("//input[@id='Company']"), "PrimeTesting");
        clickOnElement(By.xpath("//label[contains(text(),'Newsletter:')]"));
        sendTextToElement(By.id("Password"), "123456");
        sendTextToElement(By.id("ConfirmPassword"), "123456");
        clickOnElement(By.id("register-button"));
        String expected = "Your registration completed";
        String actualResult = getTextFromElement(By.xpath("//div[contains(text(),'Your registration completed')]"));
        Assert.assertEquals(expected, actualResult);
        Thread.sleep(5000);
        clickOnElement(By.className("ico-logout"));
        Thread.sleep(5000);
        clickOnElement(By.className("ico-login"));
       Thread.sleep(5000);
        sendTextToElement(By.xpath("//input[@id='Email']"), email);
        Thread.sleep(5000);
        sendTextToElement(By.xpath("//input[@id='Password']"), "123456");
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/div[3]/input[1]"));
        String expectedMessage = "Welcome to our store";
        String actualMessage = getTextFromElement(By.xpath("//h2[contains(text(),'Welcome to our store')]"));
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void useShouldGetErrorMessageWithInvalidCredential() throws InterruptedException {
        clickOnElement(By.className("ico-login"));
        Thread.sleep(5000);
        sendTextToElement(By.xpath("//input[@id='Email']"), "vpatel1789@gmail.com");
        Thread.sleep(5000);
        sendTextToElement(By.xpath("//input[@id='Password']"), "456456");
        Thread.sleep(5000);
        clickOnElement(By.xpath("/html[1]/body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/div[3]/input[1]"));
        String expectedMessage = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";
        String actualMessage = getTextFromElement(By.xpath("//div[contains(text(),'Login was unsuccessful. Please correct the errors and try again.')]"));
        Assert.assertEquals(expectedMessage, actualMessage);
    }
}


