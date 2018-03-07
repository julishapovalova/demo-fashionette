import org.testng.annotations.DataProvider;

public class LoginData {
    @DataProvider(name = "loginDataPositive")
    public static Object[][] loginData() {
        Object[][] data = new Object[][]{
                {"hello", "", false},
                {"hello1", "hello2", false},
                {"", "hello2", false},
                {"", "", false},
                {"julianna197@gmail.com", "qwerty123456", true}
        };
        return data;
    }

}
