import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {


    @Test
    public void openPage() {
        HomePage homePage = new HomePage();

        LoginPage loginPage = homePage.header.goToLoginPage();
        String loginUrl = loginPage.checkedIsOpen();

        Assert.assertTrue(loginUrl.contains("login"));
    }

}
