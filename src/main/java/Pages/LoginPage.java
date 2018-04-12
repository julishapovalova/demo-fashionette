package Pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage extends BasePage {

    public SelenideElement loginButton = $x("*//div[@class='page-content']//div[4]//button");
    public SelenideElement emailInput = $x("//input[@name='email']");
    public SelenideElement passwordInput = $x("//input[@name='password']");
    public SelenideElement passwordError = $("#password-error");
    public SelenideElement emailError = $("#email-error");

    public LoginPage() {
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

    public boolean checkedIsOpen() {
        return checkedIsOpen("/login");

    }

    public void setInput(SelenideElement input, String data) {
        input.setValue(data);
        input.pressTab();
    }
}
