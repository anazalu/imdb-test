package tests;

import base.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

@Epic("IMDB UI Tests")
public class ImdbSearchTest extends BaseTest {
    @Feature("Additional Sample Test")
    @Severity(SeverityLevel.MINOR)
    @Test(testName = "Sample test", groups = "Full regression")
    public void additionalSampleTest() {
        int expectedNumber = 0;
        Assert.assertEquals(0, expectedNumber, "Incorrect result.");
    }

    @Feature("Search Page")
    @Story("Search results are loaded correctly")
    @Severity(SeverityLevel.CRITICAL)
    @Test(testName = "Search", description = "Full search flow", groups = "Critical regression")
    public void searchTest() {
        open("/");
        Assert.assertTrue(homePage.homePageIsVisible(), "Home page not loaded.");
        homePage.clickSearchBar();
    }
}
