package org.portaltest.utils;

import org.portaltest.page.BasePage;
import org.portaltest.page.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseUtil {

    public static WebDriver driver;

    private static Logger logger = Logger.getLogger(BaseUtil.class.getName());

    public WebElement getElement(WebDriver driver, String locatorName, Page targetPageName){
        BasePage pageInstance = targetPageName.getPageInstance(driver);
        WebElement webElement = null;
        Field field;
        try {
            field = pageInstance.getClass().getDeclaredField(locatorName);
            field.setAccessible(true);
            webElement = (WebElement) field.get(pageInstance);
        } catch (Exception e) {
            logger.error("Unable to get value for the field " + locatorName + ". Error received: " + e.getMessage());
        }
        WebDriverWait wait = new WebDriverWait(driver, 25);
        webElement = wait.until(ExpectedConditions.visibilityOf(webElement));
        return webElement;
    }
}
