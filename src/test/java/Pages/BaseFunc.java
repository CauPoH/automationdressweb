package Pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaseFunc {
    private WebDriver driver;

    public BaseFunc() {
        System.setProperty("webdriver.chrome.driver", "c:/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void await() {
        driver.manage().timeouts().implicitlyWait(9, TimeUnit.SECONDS);
    }

    public void goToUrl(String url) {
        if (url.startsWith("http://") || url.startsWith("https://")) {  // "||" means OR

        } else {
            url = "http://" + url;
        }
        driver.get(url);
    }

    public void selectByValue(By locator, String value) {
        Select select = new Select(driver.findElement(locator));
        select.selectByValue(value);
    }

    public WebElement getElement(By locator) {
        return driver.findElement(locator);  //funkcija poiska elementa
    }


    public void fieldFill(By locator, String text) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public List<WebElement> getListElements(By locator) {
        return driver.findElements(locator);
    }

    public void selectByText(By locator, String text) {
        Select select = new Select(driver.findElement(locator));
        select.selectByVisibleText(text);
    }

    public void moveHoverAndClick(WebElement elementToMove, WebElement elementToClick) {
        Actions action = new Actions(driver);
        action.moveToElement(elementToMove).click(elementToClick).build().perform();
    }

    public void moveHover(WebElement elementToMove) throws InterruptedException {
        Actions action = new Actions(driver);
        action.moveToElement(elementToMove).wait();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }

    public void closeBrowser() {
        Assertions.assertNotNull(driver, "There is no opened windows");
        driver.close();
    }

}

