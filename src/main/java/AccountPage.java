import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

class AccountPage extends BasePage {


    SelenideElement nickName = $(".account__firstname");

    AccountPage() {
    }


    boolean checkedIsOpen() {
        return checkedIsOpen("/account/customer");
    }
}
