import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class AccountPage extends BasePage {


    private SelenideElement nickName = $(".account__firstname");

    AccountPage() {
    }

    public String getUserName() {
        return nickName.text();
    }
}
