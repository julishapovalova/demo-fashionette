import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;


public class LoginPageTests extends BaseTest {

    @DataProvider(name = "loginTestData")
    public Object[][] loginTestData() {
        return new Object[][]{
                {"julianna197@gmail.com", "qwerty123456", "Yuliia"}
        };
    }

    @Test(dataProvider = "loginTestData")
    public void canLogin(String email, String password, String expectedUserName) {
        System.out.println("loginTestData" + Thread.currentThread().getId());

        LoginPage loginPage = new LoginPage().open();

        AccountPage accountPage = loginPage.login(email, password);

        assertTrue(accountPage.checkedIsOpen("/account/customer"));

        String actualUserName = accountPage.getUserName();

        assertTrue(actualUserName.equals(expectedUserName));

    }


    @DataProvider(name = "loginValidEmailTestData")
    public Object[][] loginValidEmailTestData() {
        return new Object[][]{
                {"yuli..ia@gmail.com"}
        };
    }

    @Test(dataProvider = "loginValidEmailTestData", groups = "validationError")
    public void canNotSeeValidationEmailError(String email) {
        System.out.println("canNotSeeValidationEmailError" + Thread.currentThread().getId());

        LoginPage loginPage = new LoginPage().open();

        loginPage.setEmailInput(email);

        assertFalse(loginPage.checkedIsEmailCorrect());

    }

    @DataProvider(name = "loginInvalidEmailTestData")
    public Object[][] loginInvalidEmailTestData() {
        return new Object[][]{
                {"", "Bitte gib Deine E-Mail-Adresse ein."},
                {"yul iia@gmail.com", "Bitte gib Deine E-Mail-Adresse im richtigen Format ein."},
        };
    }

    @Test(dataProvider = "loginInvalidEmailTestData", groups = "validationError")
    public void canSeeValidationEmailError(String email, String errorMessage) {
        System.out.println("canSeeValidationEmailError" + Thread.currentThread().getId());

        LoginPage loginPage = new LoginPage().open();

        loginPage.setEmailInput(email);

        assertTrue(loginPage.checkedIsEmailCorrect());
        assertEquals(loginPage.getEmailError(), errorMessage);
    }

    @DataProvider(name = "loginValidPasswordTestData")
    public Object[][] loginValidPasswordTestData() {
        return new Object[][]{
                {"qwertyui"}
        };
    }

    @Test(dataProvider = "loginValidPasswordTestData", groups = "validationError")
    public void canNotSeeValidationPasswordError(String email) {
        System.out.println("canNotSeeValidationPasswordError" + Thread.currentThread().getId());

        LoginPage loginPage = new LoginPage().open();

        loginPage.setPasswordInput(email);

        assertFalse(loginPage.checkedIsPasswordCorrect());
    }

    @DataProvider(name = "loginInvalidPasswordTestData")
    public Object[][] loginInvalidPasswordTestData() {
        return new Object[][]{
                {"", "Bitte gib Dein Passwort ein."},
                {"a", "Das Passwort muss mindestens 8 Zeichen lang sein und mindestens eine Zahl enthalten."},
        };
    }

    @Test(dataProvider = "loginInvalidPasswordTestData", groups = "validationError")
    public void canSeeValidationPasswordError(String password, String errorMessage) {
        System.out.println("canSeeValidationPasswordError" + Thread.currentThread().getId());

        LoginPage loginPage = new LoginPage().open();

        loginPage.setPasswordInput(password);

        assertTrue(loginPage.checkedIsPasswordCorrect());
        assertEquals(loginPage.getPasswordError(), errorMessage);
    }

}
