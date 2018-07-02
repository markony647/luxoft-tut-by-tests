package com.luxoft.domains.finance.pages;

import com.luxoft.concise_api.ConciseAPI;
import com.luxoft.test_data.TestData;
import org.openqa.selenium.WebDriver;

public class FinancePage {

    private WebDriver driver;
    private ConciseAPI conciseAPI;

    public FinancePage(WebDriver driver) {
        this.driver = driver;
        this.conciseAPI = new ConciseAPI(driver);
    }

    public void visit() {
        driver.get(TestData.protocol + "finance." + TestData.baseDomain);
    }
}
