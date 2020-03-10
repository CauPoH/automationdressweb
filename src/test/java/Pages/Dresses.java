package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Dresses {

    private BaseFunc baseFunc;

    private final By DRESSES = By.xpath("//*[@id='block_top_menu']/ul/li[2]");
    private final By CONTINUESHOPPING = By.xpath(".//span[contains(@class, 'continue btn btn-default button exclusive-medium')]");
    private final By SIZEDROPDOWN = By.id("group_1");
    private final By ADDTOCART = By.xpath("//*[@id='add_to_cart']/button");
    private final By DRESSPRICE = By.xpath("//*[@class='ajax_block_products_total']");

    public Dresses(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void clickDressesCategory() {
        baseFunc.getElement(DRESSES).click();
    }

    public void selectAndClickItemDresses(int dressItem) {
        baseFunc.getElement(By.xpath("//*[@id='center_column']/ul/li[" + dressItem + "]")).click();
        baseFunc.getElement(By.xpath(".//ul[contains(@class, 'product_list grid row')]/li[" + dressItem + "]//a[contains(@class, 'button ajax_add_to_cart_button btn btn-default')]")).click();
    }


    public String getDress1ItemPrice() {
        // baseFunc.getElement(DRESSPRICE).getText();
        baseFunc.await();
        String priceTest = baseFunc.getElement(DRESSPRICE).getText();
        return priceTest;
    }


    public void continueSopping() {
        baseFunc.getElement(CONTINUESHOPPING).click();
    }

    public void selectDressAndColor(int dressItem, int dressColor) {
        baseFunc.getElement(By.xpath("//*[@id='center_column']/ul/li[" + dressItem + "]")).click();
        baseFunc.getElement(By.xpath("//ul[contains(@class, 'product_list grid row')]/li[" + dressItem + "]//ul[contains(@class, 'color_to_pick_list clearfix')]/li[" + dressColor + "]/a")).click();
    }

    public String selectSize(String itemSize) {
        baseFunc.selectByText(SIZEDROPDOWN, itemSize);
        return itemSize;
    }

    public void pressAddToCart() {
        baseFunc.await();
        baseFunc.getElement(ADDTOCART).click();
    }

    public String getDress2ItemPrice() {
        String dress2Price = baseFunc.getElement(DRESSPRICE).getText();
        return dress2Price;
    }
}
