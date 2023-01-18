package com.veraTarasova.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class YandexMainPage {

    public static final String URL = "http://ya.ru";

    private SelenideElement searchInput = $(".search3__input");
    private SelenideElement submitButton = $("button[type='submit']");

    public YandexResultsPage doSearch(String query) {
        searchInput.setValue(query);
        searchInput.click();
        return new YandexResultsPage();
    }
}
