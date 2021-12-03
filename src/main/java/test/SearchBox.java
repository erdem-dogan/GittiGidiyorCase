package test;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchBox extends BasePage {

    By textBox = new By.ByCssSelector("input[data-cy='header-search-input']");
    By searchButton = new By.ByCssSelector("button[data-cy='search-find-button']");

    public SearchBox(WebDriver driver) {
        super(driver);
    }

    public boolean isSearchBox() {
        return isDisplayed(textBox);
    }

    public void doSearch(String value) {
        wait(5,textBox);
        sendKey(textBox, value);
        clickElement(searchButton);
    }


}
