package org.example.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import org.openqa.selenium.WebElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class HomePage {
    private final SelenideElement pageTitle = $("#home_img_holder");
    private final SelenideElement searchBar = $("#suggestion-search");
    private final SelenideElement firstSearchResult = $("#react-autowhatever-navSuggestionSearch--item-1 div.searchResult__constTitle");

    @Step("Check if home page title is visible")
    public boolean homePageIsVisible() {
        return pageTitle.isDisplayed();
    }

    @Step("Search for text: {searchText}")
    public void searchText(String searchText) {
        searchBar.setValue(searchText);
    }

    public String getTextOfFirstResult() {
        return firstSearchResult.getText();
    }

    public void goToSearchResultPage() {
        firstSearchResult.click();
    }
}

//        $("a[href='/login']").click();
//        $("#email").setValue("user@example.com");
//        $("#password").setValue("password").pressEnter();
//        $(".welcome-message").shouldHave(text("Welcome"));
