package test;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    By ePosta = new By.ById("L-UserNameField");
    By sifre = new By.ById("L-PasswordField");
    By girisYap = new By.ById("gg-login-enter");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoginPage() {
        return isDisplayed(ePosta);
    }

    public void doLogin(String ePosta, String sifre) {
        wait(5, this.ePosta);
        sendKey(this.ePosta, ePosta);
        sendKey(this.sifre, sifre);
        clickElement(girisYap);
    }


}
