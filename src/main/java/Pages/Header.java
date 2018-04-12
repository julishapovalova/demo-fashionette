package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class Header {

    public SelenideElement loginButton = $(".header__user-icon");

    Header() {

    }

   public LoginPage goToLoginPage() {
        loginButton.click();
        return new LoginPage();
    }
}
