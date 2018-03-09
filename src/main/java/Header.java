import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class Header {

    private SelenideElement loginButton = $(".header__user-icon");

    public Header() {
        loginButton.shouldBe(Condition.visible);
    }

    public LoginFrame goToLoginPage() {
        loginButton.click();
        return new LoginFrame();
    }


}
