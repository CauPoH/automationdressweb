package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TShirts {
    private BaseFunc baseFunc;

    private final By TSHIRTS = By.xpath("//*[@id='block_top_menu']/ul/li[3]/a");
    private final By QUICKVIEW = By.xpath("//a[@class='quick-view']");
    private final By TSHIRTITEM = By.xpath("//*[@id='center_column']/ul/li/div");
    private final By QUANTITYUP = By.xpath("//*[@id='quantity_wanted_p']/a[2]");
    private final By UP = By.xpath("//*[@id='quantity_wanted_p']/a[2]/span");


    public TShirts(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void clickTShirtsCategory(){
        baseFunc.getElement(TSHIRTS).click();
    }


    public void selectAndClickItemTShirts() {
        baseFunc.await();
        WebElement item = baseFunc.getElement(TSHIRTITEM);
        WebElement quick = baseFunc.getElement(QUICKVIEW);
        baseFunc.moveHoverAndClick(item, quick);
    }

    public void increaseQuantity() throws InterruptedException {
        WebElement plus = baseFunc.getElement(QUANTITYUP);
        WebElement plusup = baseFunc.getElement(UP);


        baseFunc.moveHover(plusup);
        //baseFunc.moveHoverAndClick(plusup,plusup);
    }


}
