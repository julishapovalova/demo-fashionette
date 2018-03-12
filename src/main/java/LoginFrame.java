import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginFrame {

    private SelenideElement loginButton =  $($x("*//div[@class='page-content']//div[4]//button")),
            usernameInput = $(By.xpath("//input[@name='email']")),
            passwordInput = $(By.xpath("//input[@name='password']"));

    LoginFrame() {
        passwordInput.shouldBe(Condition.visible);
    }

    public AccountPage login(String username, String password) {
        usernameInput.setValue(username);
        passwordInput.setValue(password);
        loginButton.getWrappedElement().click();

        return new AccountPage();
    }
    public AccountPage login(String username, String password,String nickname) {
        usernameInput.setValue(username);
        passwordInput.setValue(password);
        loginButton.getWrappedElement().click();

        return new AccountPage(nickname);
    }


    public static LoginFrame open() {
        Selenide.open("/login");
        return new LoginFrame();
    }
}
