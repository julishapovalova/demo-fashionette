import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class AccountPage extends BasePage {


    private SelenideElement personData = $x("//a[@class='account__headline accordion--active']");
    private SelenideElement nickName = $(".account__firstname");

    AccountPage() {
    }

    public boolean isVisiblePersonData() {
        return personData.isDisplayed();
    }

    public SelenideElement getPersonData() {
        return personData;
    }

    public SelenideElement getNickName() {
        return nickName;
    }
}
