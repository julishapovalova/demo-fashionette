import org.testng.annotations.Test;


public class LoginPageTest extends Background {
    LoginPage loginPage;


    @Test(dataProvider = "loginData", dataProviderClass = Parametrs.class)
    public void canLogin(String email, String password) {
        loginPage = LoginPage.open();
        loginPage.login(email, password);

    }

}
