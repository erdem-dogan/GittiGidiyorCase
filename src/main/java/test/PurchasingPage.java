package test;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PurchasingPage extends BasePage {

    String js = "window.scrollTo(0,document.body.scrollHeight)";
    By save = new By.ByCssSelector("button[class='gg-ui-btn-primary gg-btn post-address gg-ui-btn-fluid post-address-button gg-ui-btn-lg']");
    By messages = new By.ByCssSelector("div[class='gg-input-error-text gg-d-24']");
    By cart = new By.ByCssSelector("a[title='Sepeti Düzenle']");

    public PurchasingPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPurchasingPage(){
        return isDisplayed(cart);
    }

    public boolean isDisplayedErrorMessages(){

        return findElements(messages).size() >= 8;
    }

    public void saveAddress() {
        wait(5, save);
        clickElement(save);
    }

    public void scrollDown() {
        getExecutor().executeScript(js);
    }

    public void editCart() {
        wait(5, cart);
        clickElement(cart);
    }
}
