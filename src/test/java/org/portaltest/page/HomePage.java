package org.portaltest.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage extends BasePage{

    public WebDriver driver;
    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @Override
    public void validatePage(){
        closeVideo.click();
        Assert.assertTrue(logo.isDisplayed());
    }

    @FindBy(how = How.XPATH, using = "//img[@alt='Euro']")
    public WebElement logo;

    @FindBy(how = How.CSS, using = "body > div.MuiDialog-root > div.MuiDialog-container.MuiDialog-scrollPaper > div > div > svg")
    public WebElement closeVideo;

    @FindBy(how = How.CSS, using = "h5[class='MuiTypography-root jss562 MuiTypography-h5']")
    public WebElement welcomeMessage;
}
