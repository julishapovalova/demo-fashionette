package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class AccountPage extends BasePage {


   public SelenideElement nickName = $(".account__firstname");

    AccountPage() {
    }


   public boolean checkedIsOpen() {
        return checkedIsOpen("/account/customer");
    }
}
