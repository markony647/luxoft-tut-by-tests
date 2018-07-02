package com.luxoft.domains.finance.pages;

import com.luxoft.concise_api.ConciseAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class CurrencyPage {

    private WebDriver driver;
    private ConciseAPI conciseAPI;
    private By currencyTable = By.id("tab-best");

    public CurrencyPage(WebDriver driver) {
        this.driver = driver;
        this.conciseAPI = new ConciseAPI(driver);
    }

    public float getNationalBankExchangeRateFor(String currency) {
        WebElement table = driver.findElement(currencyTable);
        By row = By.xpath(String.format("//tr[contains(., '1 %s')]", currency));
        List<WebElement> ratesElements = table.findElement(row).findElements(By.cssSelector("p"));
        return Float.valueOf(ratesElements.get(ratesElements.size() - 1).getText());
    }

}
