package test;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FavouritesPage extends BasePage {

    By box = new By.ByCssSelector("label[for='watch-products-item-checkbox-0'] span[class='checkmark']");
    By delete = new By.ByCssSelector("button[class='delete-watch-products robot-delete-all-button']");
    By favourites = new By.ByCssSelector("h1[class]");

    public FavouritesPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnFavouritesPage(){
        return isDisplayed(favourites);
    }

    public void clickBox() {
        wait(5, box);
        clickElement(box);
    }

    public void clickDeleteButton() {
        wait(5, delete);
        clickElement(delete);
    }

}
