import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


public class LoginPageTests extends BaseTest {

    @Test(dataProvider = "loginTestData", dataProviderClass = LoginData.class)
    public void canLogin(String email, String password, String expectedUserName) {
        LoginPage loginPage = new LoginPage();
        loginPage.open();

        AccountPage accountPage = loginPage.login(email, password);
        String accountPageUrl = accountPage.checkedIsOpen();

        assertTrue(accountPageUrl.contains("account/customer"));
        accountPage.getNickName().shouldBe(Condition.text(expectedUserName));
    }


}
