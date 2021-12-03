package base;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import page.TestResultLogger;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(TestResultLogger.class)

public class BaseTest {
    public WebDriver driver = null;
    public String url = "https://www.gittigidiyor.com/";

    @BeforeAll
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.get(url);
    }

    @AfterAll
    public void tearDown() {
        driver.quit();
    }
}
