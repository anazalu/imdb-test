package base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.example.utils.AllureAttachments;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.ITestResult;

import static com.codeborne.selenide.Selenide.open;
import org.example.pages.*;

public class BaseTest {
    protected HomePage homePage = new HomePage();
    protected TitlePage titlePage = new TitlePage();
    protected NamePage namePage = new NamePage();

    @BeforeClass
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://imdb.com";
        open();
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (!result.isSuccess()) {
            AllureAttachments.attachScreenshot();
        }
    }
}
