import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class Header {

    private SelenideElement loginButton = $(".header__user-icon");

    Header() {
        loginButton.shouldBe(Condition.visible);
    }

    public LoginPage goToLoginPage() {
        loginButton.click();
        return new LoginPage();
    }
}
