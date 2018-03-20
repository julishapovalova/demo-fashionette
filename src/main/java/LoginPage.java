import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage extends BasePage {

    private SelenideElement loginButton = $x("*//div[@class='page-content']//div[4]//button");
    private SelenideElement emailInput = $x("//input[@name='email']");
    private SelenideElement passwordInput = $x("//input[@name='password']");
    private SelenideElement passwordError = $("#password-error");
    private SelenideElement emailError = $("#email-error");

    LoginPage() {
    }

    public AccountPage login(String email, String password) {
        emailInput.setValue(email);
        passwordInput.setValue(password);
        loginButton.getWrappedElement().click();

        return new AccountPage();
    }

    @Override
    public void open() {
        Selenide.open("/login");
    }

    public void setEmailInput(String email) {
        emailInput.setValue(email);
        emailInput.pressTab();
    }

    public boolean checkedIsEmailCorrect() {
        return Boolean.valueOf(emailInput.getAttribute("aria-invalid"));
    }

    public void setPasswordInput(String email) {
        passwordInput.setValue(email);
        emailInput.pressTab();

    }

    public boolean checkedIsPasswordCorrect() {
        return Boolean.valueOf(passwordInput.getAttribute("aria-invalid"));
    }

    public String getPasswordError() {
        return passwordError.text();
    }

    public String getEmailError() {
        return emailError.text();
    }

}
