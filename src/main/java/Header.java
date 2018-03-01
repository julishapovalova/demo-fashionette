import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class Header {


    @FindBy(css = "")
    private SelenideElement bagsNavigator;

    @FindBy(css = "")
    private SelenideElement designerNavigator;

    @FindBy(css = "")
    private SelenideElement fitsNavigator;

    @FindBy(css = "")
    private SelenideElement saleNavigator;

    @FindBy(css = "")
    private SelenideElement newNavigator;

    @FindBy(css = "")
    private SelenideElement seachButton;

//    @FindBy(css = "header__user-icon")
//    private SelenideElement loginButton;

    @FindBy(css = "")
    private SelenideElement phoneData;


    private SelenideElement logo=$(".logo-claim");
    private SelenideElement loginButton=$(".header__user-icon");

    public Header(){
        loginButton.shouldBe(Condition.visible);
    }

    public LoginPage goToLoginPage(){
        loginButton.click();
        return page(LoginPage.class);
    }


}
