import com.codeborne.selenide.Condition;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginPageTests extends Background {
    LoginFrame loginFrame;
    AccountPage accountPage;

    @Test(dataProvider = "loginTestData", dataProviderClass = LoginData.class)
    public void canLogin(String email, String password, boolean result) {
        accountPage = loginFrame.open().login(email, password);

        Assert.assertEquals(accountPage.isVisiblePersonData(), result);
    }

}
