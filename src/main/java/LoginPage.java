import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage extends BasePage {

     SelenideElement loginButton = $x("*//div[@class='page-content']//div[4]//button");
     SelenideElement emailInput = $x("//input[@name='email']");
     SelenideElement passwordInput = $x("//input[@name='password']");
     SelenideElement passwordError = $("#password-error");
     SelenideElement emailError = $("#email-error");

    LoginPage() {
    }

    public AccountPage login(String email, String password) {
        emailInput.setValue(email);
        passwordInput.setValue(password);
        loginButton.getWrappedElement().click();

        return new AccountPage();
    }

    @Override
    public LoginPage open() {
        Selenide.open("/login");
        return new LoginPage();
    }

    boolean checkedIsOpen() {
        return checkedIsOpen("/login");

    }

     void setInput(SelenideElement input, String data) {
        input.setValue(data);
        input.pressTab();
    }
}
