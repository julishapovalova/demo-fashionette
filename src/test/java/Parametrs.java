import org.testng.annotations.DataProvider;

public class Parametrs {
    @DataProvider(name = "loginData")
    public static Object[][] loginData() {
        Object[][] data = new Object[][]{
                {"hello", "hello"},
                {"hello1", "hello2"}
        };
        return data;
    }
}
