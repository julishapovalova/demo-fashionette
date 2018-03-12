import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


public class LoginPageTests extends Background {
    LoginFrame loginFrame;
    AccountPage accountPage;

    @Test(dataProvider = "loginTestData", dataProviderClass = LoginData.class)
    public void canLogin(String email, String password, String expectedUserName) {
        loginFrame = loginFrame.open();

        accountPage = loginFrame.login(email, password);

        accountPage.getPersonData().shouldBe(Condition.visible);
        accountPage.getNickName().shouldBe(Condition.text(expectedUserName));
    }

    @AfterMethod
    public void logOut(){
        Selenide.clearBrowserCookies();
        Selenide.refresh();
    }
    
    @Test(dataProvider = "loginTestData", dataProviderClass = LoginData.class)
    public void canLogin1(String email, String password, String expectedUserName) {
        loginFrame = loginFrame.open();


        accountPage = loginFrame.login(email, password);
        String actualUserName = accountPage.getNickName().getText();

        Assert.assertEquals(actualUserName,expectedUserName);
    }

    @Test(dataProvider = "loginTestData", dataProviderClass = LoginData.class)
    public void canLogin2(String email, String password, String expectedUserName) {
        loginFrame = loginFrame.open();

        accountPage = loginFrame.login(email, password,expectedUserName);
    }
}
