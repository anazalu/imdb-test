package org.example.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.title;

public class TitlePage {
    private final SelenideElement topCastHeader = $x("//span[text()=\"Top cast\"]");
    private final ElementsCollection topCastList = $$x("//a[@data-testid=\"title-cast-item__actor\"]");

    @Step("Handle privacy overlay")
    public void handlePrivacyOverlayIfPresent() {
        SelenideElement acceptButton = $("button[data-testid=\"accept-button\"]");
        if (acceptButton.should(Condition.appear, Duration.ofSeconds(5)).exists()) {
            acceptButton.click();
        }
    }

    @Step("Retrieve page title")
    public String getPageTitleText() {
        return title();
    }

    @Step("Verify Top Cast is displayed")
    public boolean topCastIsDisplayed() {
        return topCastHeader.isDisplayed();
    }

    @Step("Validate minimal number of members: {expectedMemberCount}")
    public boolean verifyMinimalNumberOfTopCastMembers(int expectedMemberCount) {
        int actualMemberCount = topCastList.size();
        return actualMemberCount > expectedMemberCount;
    }

    @Step("Retrieve name of member {memberOrderNumber}")
    public String getMemberName(int memberOrderNumber) {
        int zeroIndexedMemberNo = memberOrderNumber - 1;
        return topCastList.get(zeroIndexedMemberNo).getText();
    }

    @Step("Go to the page of member {memberOrderNumber}")
    public void goToMemberPage(int memberOrderNumber) {
        topCastList.get(memberOrderNumber - 1).should(Condition.appear, Duration.ofSeconds(5)).click();
    }
}
