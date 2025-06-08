package org.example.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class HomePage {
    private final SelenideElement homeIcon = $("#home_img_holder");
    private final SelenideElement searchBar = $("#suggestion-search");
    // The very first search result (#react-autowhatever-navSuggestionSearch--item-1) is not actually a movie title, it would not satisfy further requirements ("top cast section")
    private final SelenideElement firstTitle = $("#react-autowhatever-navSuggestionSearch--item-1 div.searchResult__constTitle");

    @Step("Check if home page title is visible")
    public boolean homePageIsVisible() {
        return homeIcon.isDisplayed();
    }

    @Step("Search for text: {searchText}")
    public void searchText(String searchText) {
        searchBar.setValue(searchText);
    }

    @Step("Retrieve title name")
    public String getTextOfFirstResult() {
        return firstTitle.getText();
    }

    @Step("Go to title page")
    public void goToSearchResultPage() {
        firstTitle.click();
    }
}
