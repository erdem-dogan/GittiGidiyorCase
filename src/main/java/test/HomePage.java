package test;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    By loginHoverLocator = new By.ByCssSelector("div[data-cy=\"header-user-menu\"]");
    By loginButtonLocator = By.xpath("//a[@data-cy='header-login-button']");
    By uniqueHomePage = new By.ByCssSelector("button[class='style__StyledTab-v9cpf6-1 hOhuLq']");
    By myAccount = new By.ByCssSelector("div[data-cy='header-user-menu']");
    By favourites = new By.ByCssSelector("a[title='Favorilerim']");
    By logOut = new By.ByCssSelector("a[title='Çıkış']");


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isHomePage() {
        return isDisplayed(uniqueHomePage);
    }

    public boolean isLogOuted() {
        hoverElement(loginHoverLocator);
        wait(5, loginButtonLocator);
        return isDisplayed(loginButtonLocator);
    }

    public void hoverElement() {
        wait(5, loginHoverLocator);
        hoverElement(loginHoverLocator);
    }

    public void clickElement() {
        wait(5, loginButtonLocator);
        clickElement(loginButtonLocator);
    }

    public void hoverMyAccount() {
        wait(5, myAccount);
        hoverElement(myAccount);
    }

    public void selectFavorites() {
        wait(5, favourites);
        clickElement(favourites);
    }

    public void openTab(String value) {
        switchTo(value);
    }

    public void logOut() {
        wait(5, logOut);
        clickElement(logOut);
    }
}
