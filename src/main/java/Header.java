import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class Header {


    private SelenideElement bagsNavigator = $("*[data-flyout-target=taschen]");

    private SelenideElement designerNavigator = $("*[data-flyout-target=designermarken]");

    private SelenideElement fitsNavigator = $("*[data-flyout-target=passend-zur-tasche]");

    private SelenideElement saleNavigator = $("*[title=Sale]");

    private SelenideElement newNavigator = $("[title=New]");

    private SelenideElement seachButton = $(".header__search-icon");

    private SelenideElement loginButton = $(".header__user-icon");

    private SelenideElement phoneData = $(".header__phone");

    private SelenideElement logo = $(".logo-claim");


    public Header() {
        loginButton.shouldBe(Condition.visible);
    }

    public LoginFrame goToLoginPage() {
        loginButton.click();
        return new LoginFrame();
    }


}
