import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;


public class LoginPageTests extends BaseTest {

    @Test(dataProvider = "loginTestData", dataProviderClass = LoginData.class)
    public void canLogin(String email, String password, String expectedUserName) {
        LoginPage loginPage = new LoginPage();

        AccountPage accountPage = loginPage.login(email, password);

        assertTrue(accountPage.checkedIsOpen("/account/customer"));

        String actualUserName = accountPage.getUserName();

        assertTrue(actualUserName.equals(expectedUserName));
    }

    @Test(dataProvider = "loginValidEmailTestData", dataProviderClass = LoginData.class, groups = "validationError")
    public void canNotSeeValidationEmailError(String email) {
        LoginPage loginPage = new LoginPage();

        loginPage.setEmailInput(email);

        assertFalse(loginPage.checkedIsEmailCorrect());
    }

    @Test(dataProvider = "loginInvalidEmailTestData", dataProviderClass = LoginData.class, groups = "validationError")
    public void canSeeValidationEmailError(String email, String errorMessage) {
        LoginPage loginPage = new LoginPage();

        loginPage.setEmailInput(email);

        assertTrue(loginPage.checkedIsEmailCorrect());
        assertEquals(loginPage.getEmailError(), errorMessage);
    }


    @Test(dataProvider = "loginValidPasswordTestData", dataProviderClass = LoginData.class, groups = "validationError")
    public void canNotSeeValidationPasswordError(String email) {
        LoginPage loginPage = new LoginPage();

        loginPage.setPasswordInput(email);

        assertFalse(loginPage.checkedIsPasswordCorrect());
    }

    @Test(dataProvider = "loginInvalidPasswordTestData", dataProviderClass = LoginData.class, groups = "validationError")
    public void canSeeValidationPasswordError(String password, String errorMessage) {
        LoginPage loginPage = new LoginPage();

        loginPage.setPasswordInput(password);

        assertTrue(loginPage.checkedIsPasswordCorrect());
        assertEquals(loginPage.getPasswordError(), errorMessage);
    }


}
