package com.veraTarasova.tests;

import com.codeborne.selenide.Configuration;
import com.veraTarasova.page.YandexMainPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.api.parallel.ResourceLock;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Selenide.open;

public class ParallelTest {

    @ValueSource(strings = {
            "qa.guru",
            "selenide",
            "qameta",
            "allure"
    })

    @Execution(value = ExecutionMode.SAME_THREAD)
    @ParameterizedTest(name = "{0} test")
    void yandexSearchTest(String searchQuery) {
        Configuration.startMaximized = true;
        open(YandexMainPage.URL);
        new YandexMainPage().doSearch(searchQuery).searchResults(searchQuery);
    }

    @DisplayName("JDI test")
    @Test
    void yandexSearchTestWithMinimizedWindow() {
        Configuration.startMaximized = false;
        open(YandexMainPage.URL);
        new YandexMainPage().doSearch("JDI").searchResults("JDI");
    }
}
