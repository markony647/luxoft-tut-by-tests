package com.luxoft.tests;

import org.junit.Test;

public class CurrencyConverterTests extends TestBase {

    String[] expectedMenus = {"Курсы валют", "Банки", "Заявки на РКО", "Дадут ли вам кредит?",
                              "Кредиты", "Вклады", "Облигации", "Карточки", "Платежи",
                              "Калькуляторы", "Ещё", "Новости"};


    @Test
    public void testCurrencyConverterWork() {
        app.financePage.visit();
        float usdRate = app.currencyPage.getNationalBankExchangeRateFor("USD");
        app.menuPage.assertTitlesAre(expectedMenus);
        app.menuPage.assertMenuItemHasLabelNew("Облигации");
        app.converterPage.assertAmountIs(usdRate, "BYN");
        app.converterPage.convert(100, "USD");
        app.converterPage.assertAmountIs(usdRate * 100, "BYN");
    }
}
