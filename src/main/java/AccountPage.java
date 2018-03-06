import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class AccountPage {


    private SelenideElement personData = $(By.xpath("//a[@class='account__headline accordion--active']"));

    public AccountPage(String email) {
        personData.shouldBe(Condition.visible);
    }

    public AccountPage() {
    }

    public boolean isVisiblePersondata(){
        if(personData.isDisplayed())
            return true;
        return false;
    }
}
