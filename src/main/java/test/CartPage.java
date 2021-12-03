package test;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    By amountId = new By.ByCssSelector("select[class='amount']");
    By continueButton = new By.ByCssSelector("input[class='gg-d-24 gg-ui-btn-primary gg-ui-btn-lg btn-pay']");
    By secondProduct = new By.ByCssSelector("ul[class='clearfix recommendation-products horizontal-slider'] > li:nth-child(5) > div > a[class='gg-ui-btn-default btn-add-to-basket']");
    By mainPage = new By.ByCssSelector("a[class='logo_gg imglink logo-small']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isCartPage(){
        return isDisplayed(continueButton);
    }

    public void increaseAmount() {
        wait(5, amountId);
        selectElement(amountId, "2");
    }

    public void checkOut() {
        wait(5, continueButton);
        clickElement(continueButton);
    }

    public void addSecondProduct() {
        wait(5, secondProduct);
        clickElement(secondProduct);
    }

    public void goToMainPage() {
        wait(5, mainPage);
        clickElement(mainPage);
    }

}
