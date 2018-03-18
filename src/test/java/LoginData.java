import org.testng.annotations.DataProvider;

public class LoginData {

    @DataProvider(name = "loginTestData")
    public static Object[][] loginTestData() {
        return new Object[][]{
                {"julianna197@gmail.com", "qwerty123456", "Yuliia"}
        };
    }

    @DataProvider
    public Object[][] loginValidEmailTestData() {
        return new Object[][]{
                {"YULIIA@GMAIL.COM"},
                {"yuliia7@gmail.com"},
                {"yulii7@gmail1.com"},
                {"yuliia-sh@gmail1.com"},
                {"yuliia@gma-il1.com"},
                {"yuliia_s@gmail1.com"},
                {"yuliia@gma_il.com"},
                {"yuli.ia@gmail.com"},
                {"yuli..ia@gmail.com"}
        };
    }

    @DataProvider
    public Object[][] loginInvalidEmailTestData() {
        return new Object[][]{
                {"", "Bitte gib Deine E-Mail-Adresse ein."},
                {"yuliia@gmailcom", "Bitte gib Deine E-Mail-Adresse im richtigen Format ein."},
                {"yul iia@gmail.com", "Bitte gib Deine E-Mail-Adresse im richtigen Format ein."},
                {"yuliia@gm ail.com", "Bitte gib Deine E-Mail-Adresse im richtigen Format ein."},
                {"@gmail.com", "Bitte gib Deine E-Mail-Adresse im richtigen Format ein."},
                {"yuliia", "Bitte gib Deine E-Mail-Adresse im richtigen Format ein."},
                {"yuliiagmailcom", "Bitte gib Deine E-Mail-Adresse im richtigen Format ein."},
                {"ydddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddduliia@gmailcom", "Bitte gib Deine E-Mail-Adresse im richtigen Format ein."}
        };
    }

    @DataProvider
    public Object[][] loginValidPasswordTestData() {
        return new Object[][]{
                {"qwerty12345"},
                {"qwertyui"}
        };
    }

    @DataProvider
    public Object[][] loginInvalidPasswordTestData() {
        return new Object[][]{
                {"", "Bitte gib Dein Passwort ein."},
                {"a", "Das Passwort muss mindestens 8 Zeichen lang sein und mindestens eine Zahl enthalten."},
                {"1234567", "Das Passwort muss mindestens 8 Zeichen lang sein und mindestens eine Zahl enthalten."},
        };
    }
}
