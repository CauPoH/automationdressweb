import Pages.*;
import org.apache.logging.log4j.core.tools.picocli.CommandLine;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.text.DecimalFormat;

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
        mainPage.login("test@inbox.lv", "Password123");

        //**Dresses**//
        Dresses dresses = new Dresses(baseFunc);
        //go to dress page
        dresses.clickDressesCategory();
        //choose dress1 item 2 (full price)
        dresses.selectAndClickItemDresses(2);
        //get dress1 price, print, turn to double
        String dress1PriceValue = dresses.getDress1ItemPrice().substring(1);
        System.out.println("Dress1 price:" + dress1PriceValue);
        Double dress1PriceToSum = Double.parseDouble(dress1PriceValue);
        //press continue shopping
        dresses.continueSopping();
        //choose dress item 3 and color 4 (discount price)
        dresses.selectDressAndColor(3, 4);
        //select size L
        dresses.selectSize("L");
        //add to cart
        dresses.pressAddToCart();
        //get dress2 price, print, turn to double
        String dress2PriceValue = dresses.getDress2ItemPrice().substring(1);
        System.out.println("Dress2 price:" + dress2PriceValue);
        Double dress2PriceToSum = Double.parseDouble(dress2PriceValue);
        //press continue shopping
        dresses.continueSopping();

        //**TShirts**//
        TShirts tShirts = new TShirts(baseFunc);
        //go to T-Shirts page
        tShirts.clickTShirtsCategory();
        //choose t-shirt item by quickview
        tShirts.selectAndClickItemTShirts();
        //change frame and increase quantity
        tShirts.increaseQuantity();
        //choose size
        tShirts.selectSize("M");
        //add to cart
        tShirts.pressAddToCart();
        //exit from frame
        baseFunc.returnToDefaultFrame();
        //get TShirt price, print, turn to double
        String tShirtPriceValue = tShirts.getTShirtItemPrice().substring(1);
        System.out.println("Tshirt price:" + tShirtPriceValue);
        Double tShirtPriceToSum = Double.parseDouble(tShirtPriceValue);
        //proceed to checkout
        tShirts.checkOut();

        //**ShoppingCart**//
        ShoppingCart shoppingCart = new ShoppingCart(baseFunc);
        //get total price in summary, turn it to double
        String totalPriceValue = shoppingCart.getTotalPriceToCompare().substring(1);
        Double totalPriceToCompare = Double.parseDouble(totalPriceValue);
        //compare counted and total price from summary
        Double countedSum = dress1PriceToSum + dress2PriceToSum + tShirtPriceToSum;
        Double roundCountedSum = Math.round(countedSum * 100.0)/100.0;
        Assertions.assertEquals(totalPriceToCompare, roundCountedSum, "Item price sum not matching");
        //press proceed to check out
        shoppingCart.pressProceedToCheckOut();
        //add order comment
        shoppingCart.addOrderComment("Please send as fast as it possible");
        //press proceed to check out in address form
        shoppingCart.pressAddressCheckOut();
        //fill terms checkbox
        shoppingCart.pressTermsCheckBox();
        //save shipping price
        shoppingCart.getShippingPrice();
        //press proceed to check out in shipping form
        shoppingCart.pressShippingCheckOut();
        //get total price with shipping
        String totalPriceWithShippingToCompare = shoppingCart.getTotalPriceWithShipping();
        //choose payment by wire
        shoppingCart.payByWire();
        //get total amount before confirmation
        String totalAmountToCompare = shoppingCart.getTotalAmount();
        //check if total price correct
        Assertions.assertEquals(totalAmountToCompare, totalPriceWithShippingToCompare, "Final price not matching");
        //confirm order
        shoppingCart.confirmOrder();
        //check order complete text
        Assertions.assertEquals(shoppingCart.completeMessageText(), "Your order on My Store is complete.", "Message text not matching!");

        //close browser
        baseFunc.closeBrowser();

    }

}
