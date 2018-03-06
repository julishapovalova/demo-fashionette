import org.testng.annotations.DataProvider;

public class Parametrs {
    @DataProvider(name = "loginDataPositive")
    public static Object[][] loginData() {
        Object[][] data = new Object[][]{
//                {"hello", "hello"},
//                {"hello1", "hello2"},
                {"julianna197@gmail.com","qwerty123456"}
        };
        return data;
    }
    @DataProvider(name = "loginDataNegative")
    public static Object[][] loginDataNegative() {
        Object[][] data = new Object[][]{
                {"hello", "hello"},
                {"hello1", "hello2"}
//                {"julianna197@gmail.com","qwerty123456"}
        };
        return data;
    }
}
