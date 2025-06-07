package tests;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class UnrelatedAdditionalTest extends BaseTest {
    @Epic("Additional Test for Demonstration of Reporting")
    @Feature("Home Page")
    @Story("Home Page is displayed")
    @Severity(SeverityLevel.NORMAL)
    @Test(testName = "Home", description = "Short sample test", groups = "Full regression")
    public void homePageTest() {
        open("/");
        Assert.assertTrue(homePage.homePageIsVisible(), "Home page not loaded.");
    }
}
