package Pages;


import org.openqa.selenium.By;

public class ShoppingCart {
    private BaseFunc baseFunc;

    private final By TOTALPRICE = By.xpath("//*[@id='total_product']");
    private final By CHECKOUT = By.xpath("//a[@class='button btn btn-default standard-checkout button-medium']/span");
    private final By COMMENTFIELD = By.xpath("//*[@id='ordermsg']/textarea");
    private final By ADDRESSCHECKOUT = By.xpath("//*[@id='center_column']/form/p/button/span");
    private final By TERMSCHECKBOX = By.id("cgv");
    private final By SHIPPINGPRICE = By.xpath("//div[@class='delivery_option_price']");
    private final By SHIPPINGCHECKOUT = By.xpath("//*[@id='form']/p/button/span");
    private final By TOTALPRICEWITHSHIPPING = By.id("total_price");
    private final By WIREPAYMENT = By.xpath("//a[@class='bankwire']");
    private final By TOTALAMOUNT = By.id("amount");
    private final By CONFIRMORDER = By.xpath("//*[@id='cart_navigation']/button");
    private final By COMPLETETEXT = By.xpath("//*[@id='center_column']/div/p/strong");

    public ShoppingCart(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public String getTotalPriceToCompare(){
        String priceTest =baseFunc.getElement(TOTALPRICE).getText();
        return priceTest;
    }

    public void pressProceedToCheckOut(){
        baseFunc.getElement(CHECKOUT).click();
    }

    public void addOrderComment(String comment){
        baseFunc.sendKeys(COMMENTFIELD,comment);
    }

    public void pressAddressCheckOut(){
        baseFunc.getElement(ADDRESSCHECKOUT).click();
    }

    public void pressTermsCheckBox(){
        baseFunc.getElement(TERMSCHECKBOX).click();
    }

    public void getShippingPrice(){
        baseFunc.getElement(SHIPPINGPRICE).getText();
    }

    public void pressShippingCheckOut(){
        baseFunc.getElement(SHIPPINGCHECKOUT).click();
    }

    public String getTotalPriceWithShipping(){
        String priceWithShipping = baseFunc.getElement(TOTALPRICEWITHSHIPPING).getText();
        return priceWithShipping;
    }

    public void payByWire(){
        baseFunc.getElement(WIREPAYMENT).click();
    }

    public String getTotalAmount(){
        String totalAmount = baseFunc.getElement(TOTALAMOUNT).getText();
        return totalAmount;
    }

    public void confirmOrder(){
        baseFunc.getElement(CONFIRMORDER).click();
    }

    public String completeMessageText(){
        String messageText = baseFunc.getElement(COMPLETETEXT).getText();
        return messageText;
    }
}
