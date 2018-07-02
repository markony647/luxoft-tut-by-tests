package com.luxoft.domains.finance.pages;

import com.luxoft.concise_api.ConciseAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import static org.openqa.selenium.support.ui.ExpectedConditions.attributeToBe;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement;

public class MenuPage {

    private WebDriver driver;
    private ConciseAPI conciseAPI;

    private By menuItems = By.cssSelector("ul.b-nav-list>li>a");

    public MenuPage(WebDriver driver) {
        this.driver = driver;
        this.conciseAPI = new ConciseAPI(driver);
    }

    public void assertTitlesAre(String... titles) {
        List<WebElement> menus = driver.findElements(menuItems);
        int index = 0;
        for (String title : titles) {
            conciseAPI.assertThat(textToBePresentInElement(menus.get(index), title));
            index++;
        }
    }

    public void assertMenuItemHasLabelNew(String menuItem) {
        WebElement label = driver.findElement(conciseAPI.findByText(menuItem)).findElement(By.cssSelector("span"));
        conciseAPI.assertThat(attributeToBe(label, "class", "main_menu_item_label"));
        conciseAPI.assertThat(textToBePresentInElement(label, "новый"));
    }
}
