package com.luxoft.domains.main.pages;

import com.luxoft.test_data.TestData;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void visit() {
        driver.get(TestData.protocol + TestData.baseDomain);
    }
}
