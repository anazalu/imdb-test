package tests;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

@Epic("Additional Sample Test for Populating Reports")
public class UnrelatedAdditionalTest extends BaseTest {
    @Feature("Home Page")
    @Story("Home Page is displayed")
    @Severity(SeverityLevel.MINOR)
    @Test(testName = "Home", description = "Short sample test", groups = "Full regression")
    public void homePageTest() {
        open("/");
        Assert.assertTrue(homePage.homePageIsVisible(), "Home page not loaded.");
    }
}
