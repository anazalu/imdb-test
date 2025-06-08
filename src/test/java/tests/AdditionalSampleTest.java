package tests;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

@Epic("Additional Sample Test for Populating Reports")
public class AdditionalSampleTest extends BaseTest {
    @Feature("Dummy Test 2")
    @Severity(SeverityLevel.MINOR)
    @Test(testName = "Test 2", description = "Short sample test", groups = "Full regression")
    public void homePageTest() {
        Assert.assertTrue(true);
    }
}
