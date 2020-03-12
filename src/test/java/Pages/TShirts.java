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
    private final By QUANTITYUP = By.xpath("//*[@id='fancybox-frame1583601910775']");
    private final By UP = By.xpath("//*[@id='quantity_wanted_p']/a[2]/span");
    private final By ADDTOCART = By.xpath("//*[@id='add_to_cart']/button");
    private final By SIZEDROPDOWN = By.xpath("//*[@id='group_1']");
    private final By CHECKOUT = By.xpath("//div[@class='layer_cart_cart col-xs-12 col-md-6']/div/a/span");
    private final By DRESSPRICE = By.xpath("//*[@id='layer_cart_product_price']");


    public TShirts(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void clickTShirtsCategory() {
        baseFunc.getElement(TSHIRTS).click();
    }


    public void selectAndClickItemTShirts() {
        baseFunc.await();
        WebElement item = baseFunc.getElement(TSHIRTITEM);
        WebElement quick = baseFunc.getElement(QUICKVIEW);
        baseFunc.moveHoverAndClick(item, quick);
    }

    public void increaseQuantity() {
        WebElement framePopUp = baseFunc.getElement(By.xpath("//*[contains(@id,'fancybox-frame')]"));
        baseFunc.selectFrame(framePopUp);
        baseFunc.getElement(UP).click();
    }

    public void selectSize(String itemSize) {
        baseFunc.selectByText(SIZEDROPDOWN, itemSize);
    }

    public void pressAddToCart (){
        baseFunc.getElement(ADDTOCART).click();
    }

    public String getTShirtItemPrice() {
        baseFunc.waitVisibility(DRESSPRICE);
        String priceTest = baseFunc.getElement(DRESSPRICE).getText();
        return priceTest;
    }

    public void checkOut(){
        baseFunc.getElement(CHECKOUT).click();
    }
}
