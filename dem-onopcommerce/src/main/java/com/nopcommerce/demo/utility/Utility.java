package com.nopcommerce.demo.utility;

import com.nopcommerce.demo.basepage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.Random;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Utility extends BasePage {
    /**
     * this method will click on element
     *
     * @param by
     */
    public void clickOnElement(By by) {
        driver.findElement(by).click();
    } //1

    public void clickOnElement(WebElement element) {
        element.click();
    }  //2

    //this method will send text to element
    public void sendTextToElement(By by, String text) {    //3
        driver.findElement(by).sendKeys(text);

    }

    public void sendTextToElement(WebElement element, String text) {  //4
        element.sendKeys(text);

    }

    //this method will get text on element
    public String getTextFromElement(By by) {  //5
        return driver.findElement(by).getText();

    }

    public String getTextFromElement(WebElement element) {  //6

        return element.getText();
    }

    //this method is to select by value
    public void selectBYValue(By by, String value) {  //7
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(value);
    }

    public void selectByValue(WebElement element, String value) {  //8
        Select select = new Select(element);
        select.selectByVisibleText(value);
    }
    //this method is to select by index

    public void selectByIndex(By by, int index) {  //9
        Select select = new Select(driver.findElement(by));
        select.selectByIndex(index);
    }

    public void selectByIndex(WebElement element, int index) {  //10
        Select select = new Select(element);
        select.selectByIndex(index);
    }

    //this method is to select by String
    public void selectByString(By by, String string) {   //11
        Select select = new Select(driver.findElement(by));
        select.selectByValue(string);
    }

    private void selectByString(WebElement element, String string) {  //12
        Select select = new Select(element);
        select.selectByValue(string);

    }

    //wait till click on element
    public void waitUntilElementToBeClickable(By by, int timeOut) {  //13
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(by)));

    }

    public void waitUntilElementToBeClickable(WebElement element, int timeOut) {  //14
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.elementToBeClickable(element));

    }

    //click till element located
    public void waitUntilVisibilityOfElementLocated(By by, int timeout) {  //15
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitUntilVisibilityOfElementLocated(WebElement element, int timeout) {  //16
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        //   wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    //fluent wait method
    public void fluentWait(int timeout) {  //17
        FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofSeconds(timeout))
                .ignoring(Exception.class);
    }

    //action mouse hover to element
    public void mouseHoverToElement(By by) {  //18
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).perform();
    }

    public void mouseHoverToElement(WebElement webElement) {  //19
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement).perform();
    }

    //action mouse hover to element and click;
    public void mouseHoverToElementAndClick(By by) {  //20
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).click().perform();
    }

    public void mouseHoverToElementAndClick(WebElement webElement) {  //21
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement).click().perform();
    }

    //scroll down
    public void scrollDown(By by) {   //22
        WebElement element = driver.findElement(by);
        JavascriptExecutor jse;
        jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,800)");

    }

    //random string
    public String getRandomString() {   //23
        Random random = new Random();
        String randomString = random.toString();
        return randomString;
    }

    //random in numeric
    public int getRandomNumeric() {  //24
        Random random = new Random();
        int number = random.nextInt();
        return number;
    }

    //drag and drop
    public void draggableAndDroppable(By drag, By drop) {  //25
        WebElement draggable = driver.findElement(drag);
        WebElement droppable = driver.findElement(drop);
        Actions actions = new Actions(driver);
        actions.dragAndDrop(draggable, droppable).perform();

    }

    public void draggableAndDroppable(WebElement drag, WebElement drop) {  //26
        WebElement draggable = drag;
        WebElement droppable = drop;
        Actions actions = new Actions(driver);
        actions.dragAndDrop(draggable, droppable).perform();

    }
}
