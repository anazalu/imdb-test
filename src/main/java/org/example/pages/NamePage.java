package org.example.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.title;

public class NamePage {
    @Step("Retrieve page title")
    public String getPageTitleText() {
        return title();
    }
}
