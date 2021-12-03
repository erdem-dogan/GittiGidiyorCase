package page;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import test.*;


public class Test_Gitti_Gidiyor extends BaseTest {
    String kullaniciAdi = "erdemindolumaili@gmail.com";
    String kullaniciSifre = "erdem123";
    String searchPC = "Bilgisayar";
    String searchBag = "Çanta";
    HomePage homePage = null;
    LoginPage loginPage = null;
    SearchBox searchBox = null;
    ProductsPage productsPage = null;
    ProductsDetailPage productsDetailPage = null;
    CartPage cartPage = null;
    PurchasingPage purchasingPage = null;
    FavouritesPage favouritesPage = null;

    @Test
    @Order(1)
    public void open_main_page() {
        homePage = new HomePage(driver);
        Assertions.assertTrue(homePage.isHomePage(), "Not on HomePage!");
        homePage.hoverElement();
        homePage.clickElement();
    }

    @Test
    @Order(2)
    public void do_login() {
        loginPage = new LoginPage(driver);
        Assertions.assertTrue(loginPage.isLoginPage(), "Not on LoginPage!");
        loginPage.doLogin(kullaniciAdi, kullaniciSifre);
    }

    @Test
    @Order(3)
    public void do_pc_search() {
        searchBox = new SearchBox(driver);
        Assertions.assertTrue(searchBox.isSearchBox(), "Not on Search Box!");
        searchBox.doSearch(searchPC);
    }

    @Test
    @Order(4)
    public void do_add_products_to_favorites() {
        productsPage = new ProductsPage(driver);
        Assertions.assertTrue(productsPage.isProductsPage(), "Not on Product Page!");
        productsPage.doScrollDown();
        productsPage.doAddFavorite();
        driver.navigate().back();
        Assertions.assertTrue(homePage.isHomePage(), "Not on Home Page!");
    }

    @Test
    @Order(5)
    public void do_bag_search() {
        searchBox = new SearchBox(driver);
        Assertions.assertTrue(searchBox.isSearchBox(), "Not on Search Box!");
        searchBox.doSearch(searchBag);
        Assertions.assertTrue(productsPage.isProductsPage(), "Not on Products Page!");
    }

    @Test
    @Order(6)
    public void do_choose_bag() {
        productsPage = new ProductsPage(driver);
        productsPage.doChooseProduct();
        productsDetailPage = new ProductsDetailPage(driver);
        Assertions.assertTrue(productsDetailPage.isProductsDetailPage(), "Not on Products Detail Page!");
    }

    @Test
    @Order(7)
    public void do_add_to_cart() {
        productsDetailPage.closeCookies();
        productsDetailPage.addToCart();
        productsDetailPage.goToCart();
    }

    @Test
    @Order(8)
    public void do_increase_amount() {
        cartPage = new CartPage(driver);
        Assertions.assertTrue(cartPage.isCartPage(), "Not on Cart Page!");
        cartPage.increaseAmount();
    }

    @Test
    @Order(9)
    public void do_check_out() {
        cartPage.checkOut();
        purchasingPage = new PurchasingPage(driver);
        Assertions.assertTrue(purchasingPage.isPurchasingPage(), "Not on Purchasing Page!");
    }

    @Test
    @Order(10)
    public void do_add_address() {
        purchasingPage.saveAddress();
        Assertions.assertTrue(purchasingPage.isDisplayedErrorMessages(), "Not Displayed Error Messages!");
    }

    @Test
    @Order(11)
    public void do_edit_cart() {
        purchasingPage.scrollDown();
        purchasingPage.editCart();
    }

    @Test
    @Order(12)
    public void do_add_second_product() {
        cartPage.addSecondProduct();
    }

    @Test
    @Order(13)
    public void go_to_favourites_page() {
        favouritesPage = new FavouritesPage(driver);
        cartPage.goToMainPage();
        homePage.hoverMyAccount();
        homePage.selectFavorites();
        Assertions.assertTrue(favouritesPage.isOnFavouritesPage(), "Not on favourites Page!");
        favouritesPage.clickBox();
        favouritesPage.clickDeleteButton();
    }

    @Test
    @Order(14)
    public void do_open_tab() {
        homePage.openTab(url);
    }

    @Test
    @Order(15)
    public void do_log_out() {
        homePage.hoverMyAccount();
        homePage.logOut();
        Assertions.assertTrue(homePage.isLogOuted(), "Can not Log Out!");
        driver.close();
    }
}
