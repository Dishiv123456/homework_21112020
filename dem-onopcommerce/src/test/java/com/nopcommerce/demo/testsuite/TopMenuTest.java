package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.testbase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TopMenuTest extends TestBase {
    public void selectMenu(String menu) {

        List<WebElement> topMenu = driver.findElements(By.xpath("//ul[@class='top-menu notmobile']/li"));
// for each used used to get all elements from topmenu
        for (WebElement element : topMenu) {

            if (element.getText().contains(menu)) {

                clickOnElement(By.xpath("//div/ul[@class='top-menu notmobile']//a[contains(text(),'" + menu + "')]"));
                break;
            }
        }
    }

    @org.testng.annotations.Test
    public void verifyPageNavigation() throws InterruptedException {
        String expectedMessage, actualMessage;
        selectMenu("Computers");
        Thread.sleep(3000);
      //  clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));
        expectedMessage = "Computers";
        actualMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Computers')]"));
        Assert.assertEquals(expectedMessage, actualMessage);
        Thread.sleep(3000);
        selectMenu("Electronics");
        //clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/a[1]"));
        expectedMessage = "Electronics";
        actualMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Electronics')]"));
        Assert.assertEquals(expectedMessage, actualMessage);
        Thread.sleep(3000);
        selectMenu("Apparel");
        //clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[3]/a[1]"));
        expectedMessage = "Apparel";
        actualMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Apparel')]"));
        Assert.assertEquals(expectedMessage, actualMessage);

        selectMenu("Digital Downloads");
        //clickOnElement(By.xpath("//div[6]/div[2]/ul[1]/li[4]"));
        expectedMessage = "Digital downloads";
        actualMessage = getTextFromElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[4]"));
        Assert.assertEquals(expectedMessage, actualMessage);

        selectMenu("Books");
        //clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[5]/a[1]"));
        expectedMessage = "Books";
        actualMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Books')]"));
        Assert.assertEquals(expectedMessage, actualMessage);

        selectMenu("Jewelry");
        //clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[6]/a[1]"));
        expectedMessage = "Jewelry";
        actualMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Jewelry')]"));
        Assert.assertEquals(expectedMessage, actualMessage);

        selectMenu("Gift Cards");
        //clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[7]/a[1]"));
        expectedMessage = "Gift Cards";
        actualMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Gift Cards')]"));
        Assert.assertEquals(expectedMessage, actualMessage);
    }
}
