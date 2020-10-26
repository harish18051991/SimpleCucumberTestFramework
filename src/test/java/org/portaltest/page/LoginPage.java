package org.portaltest.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.NAME, using = "username")
    public WebElement username;

    @FindBy(how = How.NAME, using = "password")
    public WebElement password;

    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    public WebElement loginBtn;

    @FindBy(how = How.XPATH, using = "//span[@class='jss164'][contains(normalize-space(),'Student')]")
    public WebElement stdntTab;
}
