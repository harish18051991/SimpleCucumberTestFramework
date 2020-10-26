package org.portaltest.stepdefinition;

import org.portaltest.utils.BaseUtil;
import io.cucumber.java.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.portaltest.page.HomePage;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


public class Hook extends BaseUtil {

    private BaseUtil base;

    public Hook(BaseUtil base) {
        this.base = base;
    }

    @Before
    public void InitializeTest(Scenario scenario) {
        System.out.println("Opening Chrome browser");

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        options.setExperimentalOption("prefs", prefs);
        base.driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @After
    public void TearDownTest(Scenario scenario) {
        HomePage homePage = new HomePage(driver);
        if(homePage.logoutBtn.isDisplayed())
            homePage.logoutBtn.click();
        System.out.println("Closing the browser");
        base.driver.quit();
    }

}
