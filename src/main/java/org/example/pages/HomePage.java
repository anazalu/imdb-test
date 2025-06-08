package org.example.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class HomePage {
    private final SelenideElement homeIcon = $("#home_img_holder");
    private final SelenideElement searchBar = $("#suggestion-search");
    /*
    The very first search result (#react-autowhatever-navSuggestionSearch--item-0) is not actually a movie title, it would not satisfy further requirements ("top cast section")
    Video evidence: https://drive.google.com/file/d/1jTrK0BzyUbm4qSArtMtQuhE3EftZS0NT/view?usp=sharing
    */
    private final SelenideElement firstTitle = $("#react-autowhatever-navSuggestionSearch--item-1 div.searchResult__constTitle");

    @Step("Check if home page title is visible")
    public boolean homePageIsVisible() {
        return homeIcon.isDisplayed();
    }

    @Step("Search for text: {searchText}")
    public void searchText(String searchText) {
        searchBar.setValue(searchText);
    }

    @Step("Retrieve movie title name")
    public String getTextOfFirstTitle() {
        return firstTitle.getText();
    }

    @Step("Go to movie title page")
    public void goToTitlePage() {
        firstTitle.click();
    }
}
