package org.portaltest.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = {"src/test/resources/features"} , plugin = {"json:target/cucumber.json","html:target/site/cucumber-pretty"}, glue = "org/portaltest/stepdefinition")
public class TestRunner  extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
