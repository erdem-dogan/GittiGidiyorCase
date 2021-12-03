package test;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsDetailPage extends BasePage {

    By addToCart = new By.ByCssSelector("button[id='add-to-basket']");
    By closeCookies = new By.ByCssSelector("div[class='gg-ui-button gg-ui-btn-secondary policy-alert-v2-buttons']");
    By goToCart = new By.ByCssSelector("a[class='gg-ui-btn-default padding-none']");
    By isCartPage = new By.ById("sellerExplanationHeaderBtn");

    public ProductsDetailPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProductsDetailPage(){
        return isDisplayed(isCartPage);
    }

    public void closeCookies() {
        wait(5, closeCookies);
        clickElement(closeCookies);
    }

    public void addToCart() {
        wait(5, addToCart);
        clickElement(addToCart);
    }

    public void goToCart() {
        wait(5, goToCart);
        clickElement(goToCart);
    }

}
