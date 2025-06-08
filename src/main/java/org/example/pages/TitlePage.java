package org.example.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.title;

public class TitlePage {
    private final SelenideElement pageTitle = $("");

    public String getPageTitleText() {
        return title();
    }

}



//        $("a[href='/login']").click();
//        $("#email").setValue("user@example.com");
//        $("#password").setValue("password").pressEnter();
//        $(".welcome-message").shouldHave(text("Welcome"));
