package com.luxoft.domains.finance.pages;

import com.luxoft.concise_api.ConciseAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.support.ui.ExpectedConditions.attributeToBe;

public class ConverterPage {

    private WebDriver driver;
    private ConciseAPI conciseAPI;
    private By converterTable = By.className("converterRows");


    public ConverterPage(WebDriver driver) {
        this.driver = driver;
        conciseAPI = new ConciseAPI(driver);
    }

    public void convert(int sum, String currency) {
        WebElement amountInput = getAmountInputElementFor(currency);
        amountInput.clear();
        amountInput.sendKeys(String.valueOf(sum));
    }

    public void assertAmountIs(float sum, String currency) {
        conciseAPI.assertThat(attributeToBe(getAmountInputElementFor(currency), "value", String.valueOf(sum)));
    }

    private WebElement getAmountInputElementFor(String currency) {
        return driver.findElement(converterTable).
                findElement(By.cssSelector(String.format("[data-currency=%s]", currency)));
    }
}
