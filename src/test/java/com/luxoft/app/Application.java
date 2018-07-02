package com.luxoft.app;

import com.luxoft.domains.finance.pages.ConverterPage;
import com.luxoft.domains.finance.pages.CurrencyPage;
import com.luxoft.domains.finance.pages.FinancePage;
import com.luxoft.domains.finance.pages.MenuPage;
import com.luxoft.domains.main.pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Application {

    private WebDriver driver;
    public MainPage mainPage;
    public FinancePage financePage;
    public MenuPage menuPage;
    public CurrencyPage currencyPage;
    public ConverterPage converterPage;

    public Application() {
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        financePage = new FinancePage(driver);
        menuPage = new MenuPage(driver);
        currencyPage = new CurrencyPage(driver);
        converterPage = new ConverterPage(driver);
    }

    public void quit() {
        driver.quit();
    }
}
