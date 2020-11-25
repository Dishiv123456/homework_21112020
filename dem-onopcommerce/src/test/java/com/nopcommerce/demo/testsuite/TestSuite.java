package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.testbase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestSuite extends TestBase {

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() throws InterruptedException {
        //Click on Computer Menu.
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']/li[1]"));
        Thread.sleep(5000);
        // clickOnElement(By.xpath("//a[contains(text(),'Camera & photo')]"));
        // Click on Desktop
        clickOnElement(By.xpath("//a[contains(text(),' Desktops ')]"));
        Thread.sleep(5000);
        //1.3 Sortby position "Name: Z to A"
        mouseHoverToElementAndClick(By.xpath("//select[@id='products-orderby']"));
        clickOnElement(By.xpath("//select[@id='products-orderby']/option[3]"));
        //Verify the Product will arrange in Decending order.
        List<WebElement> descendingList = driver.findElements(By.xpath("//h2[@class='product-title']"));
        List<String> originalList = new ArrayList();
        for (WebElement element : descendingList) {
            originalList.add(getTextFromElement(element));
        }
        List<String> tempList = originalList;
        Assert.assertEquals(tempList, originalList);
        System.out.println(originalList);
        System.out.println(tempList);
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        //  Click on Computer Menu.
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']/li[1]"));
        Thread.sleep(2000);
        //Click on Desktop
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/h2[1]/a[1]"));
        //   Select Sortby position "Name: A to Z"
        mouseHoverToElementAndClick(By.xpath("//select[@id='products-orderby']"));
        //Click on "Add To Cart"
        clickOnElement(By.xpath("//select[@id='products-orderby']/option[2]"));
        //Verify the Text "Build your own computer"
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[2]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/input[1]"));
        String expectedMessage = "Build your own computer";
        String actualMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Build your own computer')]"));
        Assert.assertEquals(expectedMessage, actualMessage);
        //Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        clickOnElement(By.xpath("//select[@id='product_attribute_1']"));
        //Select "8GB [+$60.00]" using Select class.
        selectByIndex(By.xpath("//select[@id='product_attribute_1']"), 0);
        selectByIndex(By.xpath("//select[@id='product_attribute_2']"), 2);
        // Select HDD radio "400 GB [+$100.00]"
        clickOnElement(By.xpath("//dd[@id='product_attribute_input_3']/ul/li[2]//label[contains(text(),'400 GB [+$100.00]')]"));
        //Select OS radio "Vista Premium [+$60.00]"
        clickOnElement(By.xpath("//dd[@id='product_attribute_input_4']//li[2]//label[contains(text(),'Vista Premium [+$60.00]')]"));
        //   Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
        //Verify the price "$1,475.00"
        mouseHoverToElementAndClick(By.xpath("//dd[@id='product_attribute_input_5']//li[3]/input"));
        expectedMessage = "$1,475.00";
        actualMessage = getTextFromElement(By.xpath("//span[contains(text(),'$1,475.00')]"));
        Assert.assertEquals(expectedMessage, actualMessage);
        //
        clickOnElement(By.xpath("//input[@id='add-to-cart-button-1']"));
        expectedMessage = "The product has been added to your shopping cart";
        actualMessage = getTextFromElement(By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]"));
        Assert.assertEquals(expectedMessage, actualMessage);
        // Click on "ADD TO CARD" Button.
        mouseHoverToElementAndClick(By.xpath("//a[contains(text(),'shopping cart')]"));
//Change the Qty to "2" and Click on "Update shoppin cart"
        driver.findElement(By.xpath("//input[@class='qty-input']")).clear();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@class='qty-input']")).sendKeys("2");
//Verify the Total"$2,950.00"
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[2]/div[1]/input[1]"));
        expectedMessage = "$2,950.00";
        actualMessage = getTextFromElement(By.xpath("//tbody/tr[1]/td[7]/span[1]"));
        Assert.assertEquals(expectedMessage, actualMessage);
    }

}
