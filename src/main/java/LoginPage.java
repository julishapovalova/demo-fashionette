import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    SelenideElement loginButton = $("#menu");
    SelenideElement usernameInput = $("");
    SelenideElement passwordInput = $("");

    LoginPage(){
        loginButton.shouldBe(Condition.visible);
    }

    public void login(String username,String password){
        usernameInput.setValue(username);
        passwordInput.setValue(password);
        loginButton.click();
    }
}
