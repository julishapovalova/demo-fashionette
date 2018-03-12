import org.testng.annotations.DataProvider;

public class LoginData {

    @DataProvider(name = "loginTestData")
    public static Object[][] loginTestData() {
        Object[][] data = new Object[][]{
                {"hello", "", null},
                {"hello1", "hello2", null},
                {"", "hello2", null},
                {"", "", null},
                {"julianna197@gmail.com", "qwerty123456", "Yuliia"}
        };
        return data;
    }
}
