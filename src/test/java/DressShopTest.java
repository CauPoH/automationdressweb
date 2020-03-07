import Pages.BaseFunc;
import Pages.Dresses;
import Pages.MainPage;
import Pages.TShirts;
import org.apache.logging.log4j.core.tools.picocli.CommandLine;
import org.junit.jupiter.api.Test;

public class DressShopTest {

@Test
    public void ShopTest () throws InterruptedException {

    //open Browser and maximaze
    BaseFunc baseFunc = new BaseFunc();
    //go to url
    baseFunc.goToUrl("http://automationpractice.com/");
    //select Sing in
    MainPage mainPage = new MainPage(baseFunc);
    mainPage.clickSignIn();
    //fill email and password, then click Sign in
    mainPage.login("daf-xf@inbox.lv", "password21");
    //go to dress page
    Dresses dresses = new Dresses(baseFunc);
    dresses.clickDressesCategory();
    //choose dress item 2 (full price)
    dresses.selectAndClickItemDresses(2);
    //press continue shopping
    dresses.continueSopping();
    //choose dress item 3 and color 4 (discount price)
    dresses.selectDressAndColor(3,4);
    //select size L
    dresses.selectSize("L");
    //add to cart
    dresses.pressAddToCart();
    //press continue shopping
    dresses.continueSopping();
    //go to T-Shirts page
    TShirts tShirts = new TShirts(baseFunc);
    tShirts.clickTShirtsCategory();
    //choose t-shirt item 1
    tShirts.selectAndClickItemTShirts();
    //increase quantity
    tShirts.increaseQuantity();

    //close browser
    //baseFunc.closeBrowser();






}

}
