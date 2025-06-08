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

    private static final int MEMBER_NO = 3;
    private static final String SEARCH_TEXT = "QA";

    @Feature("Search Page Test")
    @Story("Ensure search results are loaded correctly")
    @Severity(SeverityLevel.CRITICAL)
    @Test(testName = "Search", description = "Full search flow", groups = "Critical regression")
    public void searchTest() {
        open("/");
        Assert.assertTrue(homePage.homePageIsVisible(), "Home page not loaded.");

        homePage.searchText(SEARCH_TEXT);
        String expectedTitle = homePage.getTextOfFirstTitle();
        homePage.goToTitlePage();
        String actualTitle = titlePage.getPageTitleText();
        titlePage.handlePrivacyOverlayIfPresent();
        Assert.assertTrue(actualTitle.contains(expectedTitle), "Title mismatch. Expected: " + expectedTitle + "; Actual: " + actualTitle);
        Assert.assertTrue(titlePage.topCastIsDisplayed(), "Top Cast section is not loaded.");
        Assert.assertTrue(titlePage.verifyMinimalNumberOfTopCastMembers(MEMBER_NO));

        String expectedName = titlePage.getMemberName(MEMBER_NO);
        titlePage.goToMemberPage(MEMBER_NO);
        String actualName = namePage.getPageTitleText();
        Assert.assertTrue(actualName.contains(expectedName), "Top Cast member name mismatch.");
    }
}
