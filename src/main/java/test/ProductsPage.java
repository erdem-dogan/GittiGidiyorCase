package test;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

    String js = "window.scrollTo(0,document.body.scrollHeight)";
    By favorites = new By.ByCssSelector("div[data-cy='product-favorite']");
    By products = new By.ByCssSelector("li[class='sc-1nx8ums-0 dyekHG']");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProductsPage() {
        return isDisplayed(favorites);
    }

    public void doScrollDown() {
        getExecutor().executeScript(js);
    }

    public void doAddFavorite() {
        wait(5, favorites);
        clickElementsRandomly(favorites);
    }

    public void doChooseProduct() {
        wait(5, products);
        clickElementsSeven(products);
    }
}
