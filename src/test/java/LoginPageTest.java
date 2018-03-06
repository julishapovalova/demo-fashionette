import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginPageTest extends Background {
    LoginFrame loginFrame;
    AccountPage accountPage;

    @Test(dataProvider = "loginDataPositive", dataProviderClass = Parametrs.class)
    public void canLoginPositive(String email, String password) {
        loginFrame = LoginFrame.open();
        accountPage=loginFrame.login(email, password);
        Assert.assertTrue(accountPage.isVisiblePersondata());
    }

    @Test(dataProvider = "loginDataNegative", dataProviderClass = Parametrs.class)
    public void canLoginNegative(String email, String password) {
        loginFrame = LoginFrame.open();
        accountPage=loginFrame.login(email, password);
        Assert.assertFalse(accountPage.isVisiblePersondata());
    }

}
