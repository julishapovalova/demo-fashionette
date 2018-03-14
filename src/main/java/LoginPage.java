import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage extends BasePage {

    private SelenideElement loginButton = $x("*//div[@class='page-content']//div[4]//button");
    private SelenideElement usernameInput = $x("//input[@name='email']");
    private SelenideElement passwordInput = $x("//input[@name='password']");

     LoginPage() {
    }

    public AccountPage login(String username, String password) {
        usernameInput.setValue(username);
        passwordInput.setValue(password);
        loginButton.getWrappedElement().click();

        return new AccountPage();
    }

    @Override
    public void open() {
        Selenide.open("/login");
    }
}
