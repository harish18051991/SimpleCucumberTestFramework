package org.portaltest.page;

import org.openqa.selenium.WebDriver;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

public enum Page {
    LOGIN_PAGE("/login", LoginPage.class),
    HOME_PAGE("", HomePage.class);
    private static Logger logger = Logger.getLogger(Page.class.getName());

    private String pageURLSnippets;
    private Class pageClass;

    Page(String pageURLSnippets, Class pageClass) {
        this.pageURLSnippets = pageURLSnippets;
        this.pageClass = pageClass;
    }

    public BasePage getPageInstance(WebDriver driver){
        try {
            Constructor<?> explicitConstructor = this.pageClass.getConstructor(WebDriver.class);
            return (BasePage) explicitConstructor.newInstance(driver);
        } catch (Exception e) {
            return new BasePage();
        }
    }

    public String getPageURLSnippets() {
        return this.pageURLSnippets;
    }
}
