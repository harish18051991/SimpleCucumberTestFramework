package org.portaltest.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BasePage {
    public void validatePage(){
    }

    @FindBy(how = How.XPATH, using = "//div[@title='Logout']")
    public WebElement logoutBtn;
}
