package org.portaltest.stepdefinition;

import org.testng.Assert;
import org.portaltest.page.Page;
import org.portaltest.utils.BaseUtil;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebElement;

public class GenericSteps extends BaseUtil {

    private  BaseUtil base;

    public GenericSteps(BaseUtil base) {
        this.base = base;
    }

    @And("^I click ([^\"]*) on ([\\S]+)$")
    public void iClickOnElementfromPage(String locatorName, Page page){
        WebElement webElement = getElement(base.driver,locatorName,page);
        webElement.click();
    }

    @And("^I type \"([^\"]*)\" in ([^\"]*) on ([\\S]+)$")
    public void iTypeTextOnElementfromPage(String text, String locatorName, Page page){
        WebElement webElement = getElement(base.driver,locatorName,page);
        webElement.sendKeys(text);
    }

    @And("^I open ([^\"]*)$")
    public void iOpenPortal(Page page){
        base.driver.get("https://eurokids.learnindialearn.in"+page.getPageURLSnippets());
    }

    @And("^I validate ([^\"]*) page was successfully loaded$")
    public void iValidatePageLoad(Page page){
        page.getPageInstance(driver).validatePage();
    }

    @And("^the text at \"([^\"]*)\" should be \"([^\"]*)\" on ([\\S]+)$")
    public void theTextShouldBeExpectedPage(String locatorName, String text, Page page){
        WebElement webElement = getElement(base.driver,locatorName,page);
        Assert.assertTrue(webElement.getText().contains(text),"Expected " + text + " but actual was " + webElement.getText());
    }
}
