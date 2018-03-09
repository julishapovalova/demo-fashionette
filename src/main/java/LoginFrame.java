import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginFrame {

    private SelenideElement loginButton = $(By.xpath("//button[contains(text(),\"Einloggen\")]")),
            usernameInput = $(By.xpath("//input[@name='email']")),
            passwordInput = $(By.xpath("//input[@name='password']")),
            errorEmail=$("#email-error"),
            errorPassword=$("#password-error"),
            errorLogin=$(".login__errortext");

    LoginFrame() {
        passwordInput.shouldBe(Condition.visible);
    }

    public AccountPage login(String username, String password) {
        usernameInput.setValue(username);
        passwordInput.setValue(password);
        loginButton.getWrappedElement().click();

        return new AccountPage();
    }


    public static LoginFrame open() {
        Selenide.open("/login");
        return new LoginFrame();
    }
}
