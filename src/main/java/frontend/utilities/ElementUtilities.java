package frontend.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;


import java.time.Duration;

public class ElementUtilities {
    private static Duration wait = Duration.ofSeconds(60);
    private static WebDriver webDriver;

    public static void setWebDriver(WebDriver webDriver){
        ElementUtilities.webDriver = webDriver;
    }

    private static void waitForElementVisibility(By webElement){
        WebDriverWait webDriverWait = new WebDriverWait(webDriver,wait);
        webDriverWait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(webElement)));
    }

    private static void waitForElementClickable(WebElement webElement){
        WebDriverWait webDriverWait = new WebDriverWait(webDriver,wait);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    private static void waitForNewWindow(){
        WebDriverWait webDriverWait = new WebDriverWait(webDriver,wait);
        webDriverWait.until(ExpectedConditions.numberOfWindowsToBe(2));
    }

    public static void clickElement(By element){
        WebElement webElement = webDriver.findElement(element);
        waitForElementClickable(webElement);
        webElement.click();
    }

    public static void fillElement(By element, String input) {
        WebElement webElement = webDriver.findElement(element);
        webElement.sendKeys(input);
    }

    public static void navigateToURL(String url){
        webDriver.get(url);
    }

    public static void switchToFrame(By frame){
        WebElement webElement = webDriver.findElement(frame);
        webDriver.switchTo().frame(webElement);
    }

    public static void switchToPreviousFrame(){
        webDriver.switchTo().defaultContent();
    }

    public static void switchWindow(String originalWindow){
        waitForNewWindow();
        for (String windowHandle : webDriver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                webDriver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    public static String getOriginalWindow() {
        return webDriver.getWindowHandle();

    }

    public static void clickElementWithJavaScript(By element){
        WebElement webElement = webDriver.findElement(element);
        waitForElementClickable(webElement);
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", webElement);
    }
}
