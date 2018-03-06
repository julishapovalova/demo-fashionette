import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginFrame {

    private SelenideElement loginButton = $(By.xpath("//button[contains(text(),\"Einloggen\")]"));
    private SelenideElement usernameInput = $(By.xpath("//input[@name='email']"));
    private SelenideElement passwordInput = $(By.xpath("//input[@name='password']"));
    private SelenideElement errorEmail=$("#email-error");
    private SelenideElement errorPassword=$("#password-error");
    private SelenideElement errorLogin=$(".login__errortext");


    LoginFrame() {

        passwordInput.shouldBe(Condition.visible
        );
    }

    public AccountPage login(String username, String password) {
        usernameInput.setValue(username);
//        errorEmail.shouldNot(Condition.visible);
        passwordInput.setValue(password);
//        errorPassword.shouldNot(Condition.appear);
        loginButton.getWrappedElement().click();
        return new AccountPage();
    }


    public static LoginFrame open() {
        Selenide.open("/login");
        return new LoginFrame();
    }
}
