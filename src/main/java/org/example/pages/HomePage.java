package org.example.pages;

import io.qameta.allure.Step;

import org.openqa.selenium.WebElement;
import static com.codeborne.selenide.Selenide.$;

public class HomePage {
    private final WebElement pageTitle = $("a[aria-label=\"Home\"]");
    private final WebElement searchBar = $("#suggestion-search");

    @Step("Check if home page title is visible")
    public boolean homePageIsVisible() {
        return pageTitle.isDisplayed();
    }

    @Step("Click on the search bar")
    public void clickSearchBar() {
        searchBar.click();
    }
}
