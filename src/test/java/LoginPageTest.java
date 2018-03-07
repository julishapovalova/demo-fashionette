import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginPageTest extends Background {
    LoginFrame loginFrame;
    AccountPage accountPage;


    /**
     * test buy pattern Arrange-Act-Assert
     * @param email
     * @param password
     * @param result
     */
    @Test(dataProvider = "loginDataPositive", dataProviderClass = LoginData.class)
    public void canLoginPositive(String email, String password,boolean result) {
        System.out.println("In Test   "+email);
        loginFrame.open();
        accountPage=loginFrame.login(email,password);

        boolean actual=accountPage.isVisiblePersondata();

        Assert.assertEquals(result,actual);
    }

//    @Test(dataProvider = "loginDataNegative", dataProviderClass = LoginData.class)
//    public void canLoginNegative(String email, String password) {
//        loginFrame = LoginFrame.open();
//        accountPage=loginFrame.login(email, password);
//        Assert.assertFalse(accountPage.isVisiblePersondata());
//    }



}
