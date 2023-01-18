package com.veraTarasova.page;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class YandexResultsPage {

    private ElementsCollection searchResults = $$(".serp-item");

    public void searchResults (String expected) {
        searchResults.shouldBe(CollectionCondition.sizeGreaterThan(0))
                .get(1)
                .shouldHave(Condition.text(expected));
    }
}
