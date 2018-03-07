import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginPageTest extends Background {
    LoginFrame loginFrame;
    AccountPage accountPage;

    @Test(dataProvider = "loginDataPositive", dataProviderClass = LoginData.class)
    public void canLoginPositive(String email, String password,boolean result) {
        System.out.println("In Test   "+email);
        accountPage=loginFrame.open().login(email, password);
        Assert.assertEquals(accountPage.isVisiblePersondata(),result);
    }

//    @Test(dataProvider = "loginDataNegative", dataProviderClass = LoginData.class)
//    public void canLoginNegative(String email, String password) {
//        loginFrame = LoginFrame.open();
//        accountPage=loginFrame.login(email, password);
//        Assert.assertFalse(accountPage.isVisiblePersondata());
//    }



}
