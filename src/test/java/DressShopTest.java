import Pages.*;
import org.apache.logging.log4j.core.tools.picocli.CommandLine;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

public class DressShopTest {

    @Test
    public void ShopTest() {

        //open Browser and maximize
        BaseFunc baseFunc = new BaseFunc();
        //go to url
        baseFunc.goToUrl("http://automationpractice.com/");
        //select Sing in
        MainPage mainPage = new MainPage(baseFunc);
        mainPage.clickSignIn();
        //fill email and password, then click Sign in
        mainPage.login("daf-xf@inbox.lv", "password21");

        //**Dresses**//
        Dresses dresses = new Dresses(baseFunc);
        //go to dress page
        dresses.clickDressesCategory();
        //choose dress1 item 2 (full price)
        dresses.selectAndClickItemDresses(2);
        //get dress1 price
        // WebElement dress1Price = dresses.getDress1ItemPrice();
        System.out.println("Dress1 price:" + dresses.getDress1ItemPrice());
        //press continue shopping
//        dresses.continueSopping();
//        //choose dress item 3 and color 4 (discount price)
//        dresses.selectDressAndColor(3, 4);
//        //select size L
//        dresses.selectSize("L");
//        //add to cart
//        dresses.pressAddToCart();
//        //get dress2 price
//        dresses.getDress2ItemPrice();
//        //press continue shopping
//        dresses.continueSopping();
//
//        //**TShirts**//
//        TShirts tShirts = new TShirts(baseFunc);
//        //go to T-Shirts page
//        tShirts.clickTShirtsCategory();
//        //choose t-shirt item by quickview
//        tShirts.selectAndClickItemTShirts();
//        //change frame and increase quantity
//        tShirts.increaseQuantity();
//        //choose size
//        tShirts.selectSize("M");
//        //add to cart
//        tShirts.pressAddToCart();
//        //exit from frame
//        baseFunc.returnToDefaultFrame();
//        //proceed to checkout
//        tShirts.checkOut();
//
//        //**ShoppingCart**//
//        ShoppingCart shoppingCart = new ShoppingCart(baseFunc);
//        //get total price in summary
//        shoppingCart.getTotalPriceToCompare();
//        //press proceed to check out
//        shoppingCart.pressProceedToCheckOut();
//        //add order comment
//        shoppingCart.addOrderComment("Please send as fast as it possible");
//        //press proceed to check out in address form
//        shoppingCart.pressAddressCheckOut();
//        //fill terms checkbox
//        shoppingCart.pressTermsCheckBox();
//        //save shipping price
//        shoppingCart.getShippingPrice();
//        //press proceed to check out in shipping form
//        shoppingCart.pressShippingCheckOut();
//        //get total price with shipping
//        String totalPriceWithShippingToCompare = shoppingCart.getTotalPriceWithShipping();
//        //choose payment by wire
//        shoppingCart.payByWire();
//        //get total amount before confirmation
//        String totalAmountToCompare = shoppingCart.getTotalAmount();
//        //check if total price correct
//        Assertions.assertEquals(totalAmountToCompare, totalPriceWithShippingToCompare, "Final price not matching");
//        //confirm order
//        shoppingCart.confirmOrder();
//        //check order complete text
//        Assertions.assertEquals(shoppingCart.completeMessageText(), "Your order on My Store is complete.", "Message text not matching!");
//
//        //close browser
//        baseFunc.closeBrowser();

    }

}
