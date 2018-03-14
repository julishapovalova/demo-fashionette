import org.testng.annotations.DataProvider;

public class LoginData {

    @DataProvider(name = "loginTestData")
    public static Object[][] loginTestData() {
        return new Object[][]{
                {"julianna197@gmail.com", "qwerty123456", "Yuliia"}
        };
    }
}
