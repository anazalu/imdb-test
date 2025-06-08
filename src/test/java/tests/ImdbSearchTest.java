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

    @Feature("Search Page Test")
    @Story("Ensure search results are loaded correctly")
    @Severity(SeverityLevel.CRITICAL)
    @Test(testName = "Search", description = "Full search flow", groups = "Critical regression")
    public void searchTest() {
        open("/");
        Assert.assertTrue(homePage.homePageIsVisible(), "Home page not loaded.");
        homePage.searchText("QA");
        String expectedTitle = homePage.getTextOfFirstTitle();
        homePage.goToTitlePage();
        String actualTitle = titlePage.getPageTitleText();
        titlePage.handlePrivacyOverlayIfPresent();
        Assert.assertTrue(actualTitle.contains(expectedTitle), "Title mismatch. Expected: " + expectedTitle + "; Actual: " + actualTitle);
        Assert.assertTrue(titlePage.topCastIsDisplayed(), "Top Cast section is not loaded.");
        Assert.assertTrue(titlePage.verifyMinimalNumberOfTopCastMembers(3));
        String expectedName = titlePage.getMemberName(3);
        Assert.assertEquals(titlePage.getMemberName(3), "Winona Ryder", "Name mismatch.");
        titlePage.goToMemberPage(3);
        String actualName = namePage.getPageTitleText();
        Assert.assertTrue(actualName.contains(expectedName), "Top Cast member name mismatch.");
    }

    @Feature("Dummy Test 1")
    @Severity(SeverityLevel.MINOR)
    @Test(testName = "Test 1", description = "Short sample test", groups = "Full regression")
    public void homePageTest() {
        Assert.assertTrue(true);
    }
}
