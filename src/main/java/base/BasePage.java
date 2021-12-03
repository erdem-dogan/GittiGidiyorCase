package base;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class BasePage {
    WebDriver driver;
    JavascriptExecutor executor;
    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    public List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }

    public void clickElement(By locator) {
        WebElement element = driver.findElement(locator);
        element.click();
    }

    public void clickElementsRandomly(By locator) {
        Random random = new Random();
        List<WebElement> products = findElements(locator);
        for (int i = 0; i < 4; i++) {
            int number = random.nextInt(products.size());
            try {
                products.get(number).click();
                products.remove(number);
            } catch (Exception exception) {
                executor.executeScript("arguments[0].click();", products.get(number));
            }
        }
    }

    public void selectElement(By locator, String value) {
        Select select = new Select(driver.findElement(locator));
        select.selectByVisibleText(value);
    }

    public void clickElementsSeven(By locator) {
        WebElement element = driver.findElements(locator).get(6);
        element.click();
    }

    public void sendKey(By locator, String value) {
        WebElement element = driver.findElement(locator);
        element.click();
        element.clear();
        element.sendKeys(value);
    }

    public JavascriptExecutor getExecutor() {
        executor = ((JavascriptExecutor) driver);
        return executor;
    }

    public Actions getActions() {
        return new Actions(driver);
    }

    public void hoverElement(By locator) {
        getActions().moveToElement(driver.findElement(locator)).build().perform();
    }

    public boolean isDisplayed(By locator) {
        return findElement(locator).isDisplayed();
    }

    public void wait(int i, By locator) {
        wait = new WebDriverWait(driver, i);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void switchTo(String value){
        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to(value);
    }
}
