package Pages;

import org.openqa.selenium.By;

public class MainPage {

    private BaseFunc baseFunc;

    private final By SIGNIN = By.xpath(".//div[contains(@class, 'header_user_info')]/a");
    private final By AUTHENTIFICATIONEMAIL = By.id("email");
    private final By AUTHENTIFICATIONPASSWORD = By.id("passwd");
    private final By SIGNINBUTTON = By.id("SubmitLogin");


    public MainPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void clickSignIn() {
        //Select button
        baseFunc.await();
        baseFunc.getElement(SIGNIN).click();
    }

    public void login (String email, String password){
        baseFunc.fieldFill(AUTHENTIFICATIONEMAIL, email);
        baseFunc.await();
        baseFunc.fieldFill(AUTHENTIFICATIONPASSWORD, password);
        baseFunc.await();
        baseFunc.getElement(SIGNINBUTTON).click();
    }
}
