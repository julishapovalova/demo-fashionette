import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends BaseTest {


    @Test
    public void openPage() {
        HomePage homePage = new HomePage();

        LoginPage loginPage = homePage.header.goToLoginPage();
        System.out.println("HomePage tests\n");
        Assert.assertTrue(loginPage.checkedIsOpen("/login"));
    }

}
