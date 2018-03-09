import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class AccountPage {


    private SelenideElement personData = $($x("//a[@class='account__headline accordion--active']")),
            nickName = $(".account__firstname");

    public AccountPage(String email) {
        nickName.shouldHave(Condition.matchText(email));
    }

    public AccountPage() {
    }

    public boolean isVisiblePersonData() {
        if (personData.isDisplayed())
            return true;
        return false;
    }
}
