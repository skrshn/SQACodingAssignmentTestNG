package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import testBase.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Random;

public class CommonMethods extends TestBase {
    public static void sendText(WebElement element, String textToSend) {
        element.clear();
        element.sendKeys(textToSend);
    }

    public static String getText(WebElement element) {
        return element.getText();
    }

    public static WebDriverWait getWait() {
        WebDriverWait wait = new WebDriverWait(BrowserFactory.getDriver(), Duration.ofSeconds(Constants.EXPLICIT_WAIT));
        return wait;
    }

    public static void waitForClickability(WebElement element) {
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void click(WebElement element) {
        waitForClickability(element);
        element.click();
    }
    public static long getRandomLongNumber(){
        return new Random().nextLong(999999999999999L);
    }
    public static JavascriptExecutor getJSExecutor() {
        JavascriptExecutor js = (JavascriptExecutor) BrowserFactory.getDriver();
        return js;
    }

    public static void highlightText(WebElement element) {
        getJSExecutor().executeScript("arguments[0].style.background='yellow'", element);
    }
    public static void jsScrollDown() {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)", "");
    }

    public static void jsScrollUp() {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-500)", "");
    }

    public static String getTimeStamp(String pattern) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    public static void takeScreenShot(String fileName) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        if (ts != null) {
            File sourceFile = ts.getScreenshotAs(OutputType.FILE);
            File destFile = new File(Constants.SCREENSHOT_FILEPATH + fileName + getTimeStamp("yyyy-MM-dd-HH-mm-ss") + ".png");
            try {
                FileUtils.copyFile(sourceFile, destFile);
                Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath() + "' height='100' width='250'/> </a>");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
