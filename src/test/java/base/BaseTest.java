package base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.BeforeClass;

import static com.codeborne.selenide.Selenide.open;
import org.example.pages.*;

public class BaseTest {
    protected HomePage homePage = new HomePage();

    @BeforeClass
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://imdb.com";
        open();
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }
}
