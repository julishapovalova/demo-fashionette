import Pages.AccountPage;
import Pages.LoginPage;
import com.codeborne.selenide.Condition;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
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
        LoginPage loginPage = new LoginPage().open();

        AccountPage accountPage = loginPage.login(email, password);

        assertTrue(accountPage.checkedIsOpen());

        accountPage.nickName.should(Condition.text(expectedUserName));
    }


    @DataProvider(name = "loginValidEmailTestData")
    public Object[][] loginValidEmailTestData() {
        return new Object[][]{
                {"yuli..ia@gmail.com"}
        };
    }

    @Test(dataProvider = "loginValidEmailTestData", groups = "validationError")
    public void canNotSeeValidationEmailError(String email) {
        LoginPage loginPage = new LoginPage().open();

        loginPage.setInput(loginPage.emailInput, email);

        loginPage.emailInput.shouldHave(Condition.attribute("aria-invalid", "false"));
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
        LoginPage loginPage = new LoginPage().open();

        loginPage.setInput(loginPage.emailInput, email);

        loginPage.emailInput.shouldHave(Condition.attribute("aria-invalid", "true"));
        assertEquals(loginPage.emailError.text(), errorMessage);
    }

    @DataProvider(name = "loginValidPasswordTestData")
    public Object[][] loginValidPasswordTestData() {
        return new Object[][]{
                {"qwertyui"}
        };
    }

    @Test(dataProvider = "loginValidPasswordTestData", groups = "validationError")
    public void canNotSeeValidationPasswordError(String password) {
        LoginPage loginPage = new LoginPage().open();

        loginPage.setInput(loginPage.passwordInput, password);

        loginPage.passwordInput.shouldHave(Condition.attribute("aria-invalid", "false"));
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
        LoginPage loginPage = new LoginPage().open();

        loginPage.setInput(loginPage.passwordInput, password);

        loginPage.passwordInput.shouldHave(Condition.attribute("aria-invalid", "true"));
        assertEquals(loginPage.passwordError.text(), errorMessage);
    }

}
