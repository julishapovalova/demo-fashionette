import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class AccountPage {


    private SelenideElement personData = $($x("//a[@class='account__headline accordion--active']")),
                             nickName=$(".account__firstname");

    public AccountPage(String email) {
        nickName.shouldHave(Condition.matchText(email));
//        personData.shouldBe(Condition.visible);
    }

    public AccountPage() {
    }

    public boolean isVisiblePersonData(){
        if(personData.isDisplayed())
            return true;
        return false;
    }

    public SelenideElement getPersonData() {
        return personData;
    }

    public SelenideElement getNickName() {
        return nickName;
    }
}
